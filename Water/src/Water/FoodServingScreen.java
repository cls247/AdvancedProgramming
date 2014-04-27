package Water;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * This should be the template for the page that has dragging features. This
 * will be used for the grains, meats and fruits and vegetables.
 * 
 * @author Sand
 * 
 */

public class FoodServingScreen extends JPanel implements Runnable, Screen {

	private Thread dragToPlate = new Thread();
	private final int DELAY = 20;

	private ImageIcon waterBottle;
	private Image bottle;
	private Image bkgd;

	private final JPanel bottomPanel = new JPanel();
	private JPanel topPanel = new JPanel();
	private JPanel foodButtonPanel = new JPanel();
	private JScrollPane foodScrollPane = new JScrollPane(bottomPanel);

	private final int ROWS = 8;
	private final int COLUMNS = 8;
	private final int BUTTON_WIDTH = 95;
	private final int BUTTON_HEIGHT = 95;
	private ArrayList<JButton> buttonsOnBottomPanel = new ArrayList<JButton>();

	private final ImageIcon chickenIcon = new ImageIcon("chicken.jpg");
	private final ImageIcon lambIcon = new ImageIcon("lamb.jpg");
	private final ImageIcon beefIcon = new ImageIcon("beef.jpg");
	private final ImageIcon eggIcon = new ImageIcon("egg.jpg");
	private final ImageIcon cornIcon = new ImageIcon("corn.jpg");
	private final ImageIcon lentilIcon = new ImageIcon("lentils.jpg");
	private final ImageIcon pastaIcon = new ImageIcon("pasta.jpg");
	private final ImageIcon veggiesIcon = new ImageIcon("veggies.jpg");

	private final JButton chickenButton = new JButton();
	private final JButton lambButton = new JButton();
	private final JButton cowButton = new JButton();
	private final JButton eggButton = new JButton();
	private final JButton cornButton = new JButton();
	private final JButton lentilButton = new JButton();
	private final JButton pastaButton = new JButton();
	private final JButton veggiesButton = new JButton();

	private int cowServings = 0;
	private int chickenServings = 0;
	private int lambServings = 0;
	private int eggServings = 0;
	private int cornServings = 0;
	private int lentilServings = 0;
	private int pastaServings = 0;
	private int veggieServings = 0;

	private User currentUser = new User();

	/**
	 * ScreenWithDrag()
	 * 
	 * Constructor that calls the init() function to initialize the screen and
	 * its various components
	 */
	public FoodServingScreen() {

		init();
	}

	/**
	 * init()
	 * 
	 * This method initialized the screen and its components. It calls functions
	 * that initialize the background image, set the images of the buttons,
	 * places them on the screen in their specific positions, and adds the two
	 * different type of listeners.
	 * 
	 */
	public void init() {
		// set the basic elements of the frame
		// setBkgd() will paint the background image on the screen
		setPreferredSize(new Dimension(800, 600));
		drawBackground();

		{
			addNotify();
			setLayout(new GridLayout(2, 0));

			// initializing the top and bottom panels so that the buttons
			// can be added to them
			initTopPanel();
			initBottomPanel();

			// initializing the buttons by setting their images, sizes and
			// locations on the screen
			initIcons();
			initButtons();
			// and then adding them to the foodButtonPanel that will go in the
			// top panel
			initButtonPanel();

			// adding the top and bottom panels to the screen
			// the bottom panel is in the scrollPane so that more buttons can be
			// added to the panel
			add(topPanel);
			add(foodScrollPane);

			final ActionListener bottomButtonListener = makeBottomButton();
			final ActionListener topButtonListener = makeTopButton(bottomButtonListener);
			
			// add the listeners to every button
			addAllListeners(topButtonListener);

		}
	}

	private ActionListener makeTopButton(
			final ActionListener bottomButtonListener) {
		// action listener for the buttons on the top panel so that when a
		// button is clicked it is added to the bottom
		// panel and the footprint is updated
		final ActionListener topButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// get the button that was clicked
				JButton animalSelected = (JButton) arg0.getSource();
				String desc = ((ImageIcon) animalSelected.getIcon())
						.getDescription();

				// create a new JButton so that it can be added to the
				// bottom panel and get a listener
				JButton newButton = new JButton();
				newButton.addActionListener(bottomButtonListener);

				// check the description of the button to know which type of
				// food was selected
				// set the icon of the new button so that the same button
				// appears when added to the bottom screen
				if (desc == "Cow") {
					currentUser.getFootPrint().setServingOfBeef(1);
					newButton.setIcon(beefIcon);
					cowServings++;
				}
				if (desc == "Lamb") {
					currentUser.getFootPrint().setServingOfLamb(1);
					newButton.setIcon(lambIcon);
					lambServings++;
				}
				if (desc == "Chicken") {
					currentUser.getFootPrint().setServingOfChicken(1);
					newButton.setIcon(chickenIcon);
					chickenServings++;
				}
				if (desc == "Egg") {
					currentUser.getFootPrint().setServingOfEggs(1);
					newButton.setIcon(eggIcon);
					eggServings++;
				}
				if (desc == "Corn") {
					currentUser.getFootPrint().setServingOfLamb(1);
					newButton.setIcon(cornIcon);
					cornServings++;
				}
				if (desc == "Lentils") {
					currentUser.getFootPrint().setServingOfLentils(1);
					newButton.setIcon(lentilIcon);
					lentilServings++;
				}
				if (desc == "Pasta") {
					currentUser.getFootPrint().setServingOfPasta(1);
					newButton.setIcon(pastaIcon);
					pastaServings++;
				}
				if (desc == "Veggies") {
					currentUser.getFootPrint().setServingOfVeggies(1);
					newButton.setIcon(veggiesIcon);
					veggieServings++;
				}

				// add the new button to the array so that it can be
				// repainted onto the screen
				buttonsOnBottomPanel.add(newButton);
				repaintAfterDelete();
			}
		};
		return topButtonListener;
	}

	private ActionListener makeBottomButton() {
		// action listener for the buttons on the bottom of the panel so
		// that they can be deleted and removed from this
		// panel by clicking on each once
		final ActionListener bottomButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// get the the button that should be removed
				JButton animalToDelete = (JButton) arg0.getSource();
				String desc = ((ImageIcon) animalToDelete.getIcon())
						.getDescription();

				// each image has a description that was set in initIcons(),
				// so we can check the
				// description to know which button was clicked and which
				// serving amount should be changed
				if (desc == "Cow") {
					currentUser.getFootPrint().setServingOfBeef(-1);
					cowServings--;
				}
				if (desc == "Lamb") {
					currentUser.getFootPrint().setServingOfLamb(-1);
					lambServings--;
				}
				if (desc == "Chicken") {
					currentUser.getFootPrint().setServingOfChicken(-1);
					chickenServings--;
				}
				if (desc == "Egg") {
					currentUser.getFootPrint().setServingOfEggs(-1);
					eggServings--;
				}
				if (desc == "Corn") {
					currentUser.getFootPrint().setServingOfLamb(-1);
					cornServings--;
				}
				if (desc == "Lentils") {
					currentUser.getFootPrint().setServingOfLentils(-1);
					lentilServings--;
				}
				if (desc == "Pasta") {
					currentUser.getFootPrint().setServingOfPasta(-1);
					pastaServings--;
				}
				if (desc == "Veggies") {
					currentUser.getFootPrint().setServingOfVeggies(-1);
					veggieServings--;
				}

				// get the dimensions of the button on the screen so that
				// the others can be shifted accordingly
				int toDeleteX = ((JButton) arg0.getSource()).getBounds().x;
				int toDeleteY = ((JButton) arg0.getSource()).getBounds().y;

				// index will be the index in the arrayList
				// buttonsOnBottomPanel of the button that should be removed
				int index = 0;

				for (int i = 0; i < buttonsOnBottomPanel.size(); i++) {
					// check if the location of each button matches the one
					// that should be deleted by creating a new Point
					// object with the dimensions found above
					if (buttonsOnBottomPanel.get(i).getLocation()
							.equals(new Point(toDeleteX, toDeleteY))) {
						index = i;
					}
				}

				// remove the button and repaint the screen
				buttonsOnBottomPanel.remove(index);
				repaintAfterDelete();
			}
		};
		return bottomButtonListener;
	}
	/**
	 * addAllListeners()
	 * 
	 * This method takes in an ActionListener as a parameter to add it to each
	 * of the buttons so that when they are clicked they can be added to the
	 * bottom panel
	 * 
	 * @param topButtonListener
	 *            - listener that adds the selected button to the bottom panel
	 */
	private void addAllListeners(ActionListener topButtonListener) {
		// add the listener to each of the buttons
		cowButton.addActionListener(topButtonListener);
		chickenButton.addActionListener(topButtonListener);
		lambButton.addActionListener(topButtonListener);
		eggButton.addActionListener(topButtonListener);
		lentilButton.addActionListener(topButtonListener);
		cornButton.addActionListener(topButtonListener);
		pastaButton.addActionListener(topButtonListener);
		veggiesButton.addActionListener(topButtonListener);
	}

	/**
	 * initBottomPanel()
	 * 
	 * Initializes the bottomPanel by setting its color, dimensions, visibility,
	 * etc. The foodScrollPane, which the bottom panel is contained in, is also
	 * initialized and the dimensions are set so that the user is able to scroll
	 */
	private void initBottomPanel() {
		// initialize the basic elements of the bottomPanel
		bottomPanel.setBackground(Color.white);
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
		bottomPanel.setPreferredSize(new Dimension(200, 2000));
		bottomPanel.setLayout(null);

		// initialize the foodScroolPane
		foodScrollPane.setViewportView(bottomPanel);
		foodScrollPane.setVisible(true);
		foodScrollPane.setFocusable(true);

		// ensures that the scrollbars will always be visible
		foodScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		foodScrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		foodScrollPane.setPreferredSize(new Dimension(10, 1000));
		bottomPanel.setOpaque(false);

	}

	/**
	 * initTopPanel()
	 * 
	 * Initializes the top panel by setting the layoutManager and adding the
	 * text at the top that instructs the user what to do
	 */
	private void initTopPanel() {
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

		// create a new JLabel with the screen instructions
		JLabel prompt = new JLabel();
		prompt.setText("Please select the number of servings of meat you eat per week:");
		prompt.setLocation(200, 0);
		prompt.setVisible(true);

		// add the prompt to the panel and set it opaque so that the background
		// and logo
		// can be seen behind it
		topPanel.add(prompt);
		topPanel.setOpaque(false);

	}

	/**
	 * initButtonPanel()
	 * 
	 * Initialized the buttonPanel that contains the 7 food buttons. They are
	 * placed in this panel so that their locations can be set and displayed
	 * neatly within the button panel (locations set in initButtons().
	 */
	private void initButtonPanel() {
		// set the layout to null so that the locations can be set manually
		foodButtonPanel.setLayout(null);

		// add the buttons to the panel
		foodButtonPanel.add(cowButton);
		foodButtonPanel.add(lambButton);
		foodButtonPanel.add(chickenButton);
		foodButtonPanel.add(eggButton);
		foodButtonPanel.add(cornButton);
		foodButtonPanel.add(lentilButton);
		foodButtonPanel.add(pastaButton);
		foodButtonPanel.add(veggiesButton);
		foodButtonPanel.setVisible(true);
		foodButtonPanel.setOpaque(false);

		// add the panel to the topPanel
		topPanel.add(foodButtonPanel);
	}

	/**
	 * initButtons()
	 * 
	 * Initializes the icons and bounds of each button so that when they are
	 * later added to the screen they have an icon and are neatly aligned
	 */
	private void initButtons() {
		// set the icon of each button to a specific food icon created earlier
		// set the bounds so that the icons are located in neat rows by
		// incrementing the
		// x and y cordinates accordingly
		cowButton.setIcon(beefIcon);
		cowButton.setBounds(120, 40, BUTTON_WIDTH, BUTTON_HEIGHT);

		lambButton.setIcon(lambIcon);
		lambButton.setBounds(120 + BUTTON_WIDTH, 40, BUTTON_WIDTH,
				BUTTON_HEIGHT);

		chickenButton.setIcon(chickenIcon);
		chickenButton.setBounds(120 + BUTTON_WIDTH * 2, 40, BUTTON_WIDTH,
				BUTTON_HEIGHT);

		eggButton.setIcon(eggIcon);
		eggButton.setBounds(120 + (BUTTON_WIDTH * 3), 40, BUTTON_WIDTH,
				BUTTON_HEIGHT);

		cornButton.setIcon(cornIcon);
		cornButton.setBounds(120, 40 + BUTTON_HEIGHT, BUTTON_WIDTH,
				BUTTON_HEIGHT);

		lentilButton.setIcon(lentilIcon);
		lentilButton.setBounds(120 + BUTTON_WIDTH, 40 + BUTTON_HEIGHT,
				BUTTON_WIDTH, BUTTON_HEIGHT);

		pastaButton.setIcon(pastaIcon);
		pastaButton.setBounds(120 + (BUTTON_WIDTH * 2), 40 + BUTTON_HEIGHT,
				BUTTON_WIDTH, BUTTON_HEIGHT);

		veggiesButton.setIcon(veggiesIcon);
		veggiesButton.setBounds(120 + (BUTTON_WIDTH * 3), 40 + BUTTON_HEIGHT,
				BUTTON_WIDTH, BUTTON_HEIGHT);

	}

	/**
	 * initIcons()
	 * 
	 * Initializes the icon descriptions of each of image icons
	 */
	private void initIcons() {
		// set the description to the type of food the icon is of so that the
		// description can later be checked to see which button/icon was clicked
		chickenIcon.setDescription("Chicken");
		lambIcon.setDescription("Lamb");
		beefIcon.setDescription("Cow");
		eggIcon.setDescription("Egg");
		cornIcon.setDescription("Corn");
		lentilIcon.setDescription("Lentils");
		pastaIcon.setDescription("Pasta");
		veggiesIcon.setDescription("Veggies");
	}

	/**
	 * repaintAfterDelete()
	 * 
	 * Removes all of the buttons from the bottom panel and then recalculates
	 * their positions so that there are no gaps in the panel between buttons
	 * after one has been deleted
	 */
	public void repaintAfterDelete() {
		int row = 0;
		int column = 0;

		// remove all the buttons from the panel
		bottomPanel.removeAll();

		// recalculate the positions by getting the row and column positions and
		// then
		// resetting the bounds of each button with those dimensions
		for (int i = 0; i < buttonsOnBottomPanel.size(); i++) {
			row = i / ROWS;
			column = i % COLUMNS;
			buttonsOnBottomPanel.get(i).setBounds(column * BUTTON_WIDTH,
					row * BUTTON_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT);
			bottomPanel.add(buttonsOnBottomPanel.get(i));
		}

		repaint();
	}

	/**
	 * addNotify()
	 * 
	 * This method creates a new Thread for the game to run on.
	 */
	@Override
	public void addNotify() {
		super.addNotify();

		// create the thread and then start it
		dragToPlate = new Thread(this);
		dragToPlate.start();
	}

	/**
	 * paintComponent()
	 * 
	 * Overriding the paintComponent method to paint the background, serving
	 * counters, and water bottle on the screen. The serving counters increment
	 * each time the appropriate button is clicked, and the water bottle is
	 * updated according to the waterLevel. When the water level going beyond
	 * the maximum allowed level, the overflow design is painted
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// paint the background
		g.drawImage(bkgd, 0, 0, null);

		// paint each of the serving counters
		g.drawString("Servings of beef: ", 520, 40);
		g.drawString(Integer.toString(cowServings), 660, 40);

		g.drawString("Servings of chicken: ", 520, 60);
		g.drawString(Integer.toString(chickenServings), 660, 60);

		g.drawString("Servings of lamb: ", 520, 80);
		g.drawString(Integer.toString(lambServings), 660, 80);

		g.drawString("Servings of egg: ", 520, 100);
		g.drawString(Integer.toString(eggServings), 660, 100);

		g.drawString("Servings of corn: ", 520, 120);
		g.drawString(Integer.toString(cornServings), 660, 120);

		g.drawString("Servings of lentil: ", 520, 140);
		g.drawString(Integer.toString(lentilServings), 660, 140);

		g.drawString("Servings of pasta: ", 520, 160);
		g.drawString(Integer.toString(pastaServings), 660, 160);

		g.drawString("Servings of veggies: ", 520, 180);
		g.drawString(Integer.toString(veggieServings), 660, 180);

		// paint the water bottle if it is not full
		if (currentUser.getFootPrint().getWaterBottle().isNotFull()) {
			waterBottle = currentUser.getFootPrint().getWaterBottle()
					.getImage();
			bottle = waterBottle.getImage();
			g.drawImage(bottle, 700, 20, null);
			// if full, paint the overflow
		} else {
			// paint the overflow stuff
		}

	}

	/**
	 * run()
	 * 
	 * Override the run method to start the thread and make the animation move
	 * smoothly
	 */
	@Override
	public void run() {

		// ************
		// below here is just the stuff to create a thread and have it move
		// smoothly
		long beforeTime, timeDiff, timeSleep;
		beforeTime = System.currentTimeMillis();

		while (true) {

			repaint();

			// proper time delay to make the elements
			// loop like that are properly animated
			timeDiff = System.currentTimeMillis() - beforeTime;
			timeSleep = DELAY - timeDiff;

			if (timeSleep < 0) {
				timeSleep = 2;
			}

			try {
				Thread.sleep(timeSleep);
			} catch (InterruptedException e) {
				System.out.println("Interrupted: " + e.getMessage());
			}

			beforeTime = System.currentTimeMillis();
		}
	}

	/**
	 * passOnUser() This method returns the user to the control class.
	 */
	@Override
	public User passOnUser() {
		return currentUser;
	}

	/**
	 * receiveUser(User setCurrentUser) This method takes in a User and sets the
	 * current user to the user that is passed in.
	 */
	@Override
	public void receiveUser(User setCurrentUser) {
		currentUser = setCurrentUser;

	}

	/**
	 * drawBackground()
	 * 
	 * This method created an image from an image file to set the background of
	 * the frame so that it can be repainted every time. The other size
	 * dimensions are set based on the size of the image so covered the entire
	 * frame
	 * 
	 * @exception error
	 *                - if the file is not found, throws an IOException
	 */
	@Override
	public void drawBackground() {
		try {

			// process the image file
			bkgd = ImageIO.read(new File("background.jpg"));

			// set the size of the frame based on the size of the image so that
			// the entire background is covered
			Dimension size = new Dimension(bkgd.getWidth(null),
					bkgd.getHeight(null));

			// set all of the dimensions using the size
			setPreferredSize(size);
			setMinimumSize(size);
			setMaximumSize(size);
			setSize(size);
			setLayout(null);

			// if there is an error with the file, throw and IOException
		} catch (IOException error) {
			System.out.println("Error in setBkgd: image file failed to load!");
		}

	}

}