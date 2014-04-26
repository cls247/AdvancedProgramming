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
 * This should be the template for the page that has 
 * dragging features. This will be used for the 
 * grains, meats and fruits and vegetables.
 * 
 * @author Sand
 *
 */

public class ScreenWithDrag extends JPanel implements Runnable, Global, Screen {

	private ImageIcon plate=new ImageIcon("Water/plate.jpg");
	private Image platePicture=plate.getImage();
	private Thread dragToPlate=new Thread();
	private final int DELAY = 20;
	private ArrayList<String> picturesToDrag = new ArrayList<String>();
	//i was thinking about having a string that was 
	//meat, grains or fruits that said which it should be ???? not sure yet
	private String type;
	private Image bkgd;
	final JPanel bottomPanel = new JPanel();
	JPanel topPanel = new JPanel();
	//	JScrollPane animalScrollPane = new JScrollPane();

	final int BUTTON_WIDTH = 115;
	final int BUTTON_HEIGHT = 115; 
	int buttonX = 0;
	int buttonY = 0;
	int rowCount = 0;
	int columnCount = 0;

	private ArrayList<Dimension> buttonDimensions = new ArrayList<Dimension>();
	private ArrayList<JButton> buttonsOnRight = new ArrayList<JButton>();
	

	ImageIcon waterBottle;
	Image bottle;
	private Thread bottleThread;
	
	public ScreenWithDrag(String foodType){
		type = foodType;
		init();
	}

	/**
	 * This will take in an array of pictures that will be dragged
	 * @param pics
	 */
	public ScreenWithDrag(ArrayList<String> pics)
	{
		picturesToDrag=pics;
		
		
		//bottleThread=new Thread(this);
		//bottleThread.start();
		init();
		
	}
	
	@Override
	public void init()
	{
		setPreferredSize(new Dimension(800,600));
				try{
		
		
					bkgd = ImageIO.read(new File("background.jpg"));
					
					Dimension size = new Dimension(bkgd.getWidth(null), bkgd.getHeight(null));
					setPreferredSize(size);
					setMinimumSize(size);
					setMaximumSize(size);
					setSize(size);
					setLayout(null);
					
					
				}catch(IOException error){
		
		
				}
				
		{
			addNotify();
			setLayout(new GridLayout(2,0));

			bottomPanel.setBackground(Color.white);
			//topPanel.setBackground(Color.green);
			
			topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
			bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
			bottomPanel.setPreferredSize(new Dimension(200, 2000));
			//topPanel.setPreferredSize(new Dimension(100,600));
			
			

			final ImageIcon chickenIcon = new ImageIcon("smallChicken.jpg");
			chickenIcon.setDescription("Chicken");
			final ImageIcon lambIcon = new ImageIcon("lamb.jpeg");
			lambIcon.setDescription("Lamb");
			final ImageIcon beefIcon = new ImageIcon("cow.jpg");
			beefIcon.setDescription("Cow");

			final JButton chickenButton = new JButton();
			final JButton lambButton = new JButton();
			final JButton cowButton = new JButton();

			
			JLabel prompt = new JLabel();
			prompt.setText("     Please select the number of servings of meat you eat per week:");
			prompt.setVisible(true);
			topPanel.add(prompt);
			
			
			
			
			cowButton.setIcon(beefIcon);
			cowButton.setBounds(20, 100, BUTTON_WIDTH, BUTTON_HEIGHT);
			cowButton.setVisible(true);
			lambButton.setIcon(lambIcon);
			lambButton.setBounds(20+BUTTON_WIDTH, 100, BUTTON_WIDTH, BUTTON_HEIGHT);
			lambButton.setVisible(true);
			chickenButton.setIcon(chickenIcon);
			chickenButton.setBounds(20+BUTTON_WIDTH*2, 100, BUTTON_WIDTH, BUTTON_HEIGHT);
			chickenButton.setVisible(true);
			
			
			JPanel animalButtonPanel = new JPanel();
			animalButtonPanel.setLayout(null);
			animalButtonPanel.add(cowButton);
			animalButtonPanel.add(lambButton);
			animalButtonPanel.add(chickenButton);
			animalButtonPanel.setVisible(true);
			
			
			/*
			topPanel.add(chickenButton);
			topPanel.add(lambButton);
			topPanel.add(cowButton);
			 */
			
			animalButtonPanel.setOpaque(false);
			topPanel.add(animalButtonPanel);
			topPanel.validate();
			
			bottomPanel.setLayout(null);

			JScrollPane animalScrollPane = new JScrollPane(bottomPanel);
			animalScrollPane.setViewportView(bottomPanel);
			animalScrollPane.setVisible(true);
			animalScrollPane.setFocusable(true);
			animalScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//	animalScrollPane.setPreferredSize(new Dimension(100, 1000));

			//add(topPanel, BorderLayout.WEST);
			//add(animalScrollPane, BorderLayout.EAST);

			topPanel.setOpaque(false);
			
			add(topPanel);
			add(animalScrollPane);
			
			final ActionListener rightSideButtonListener = new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					JButton animalToDelete = (JButton) arg0.getSource();
					String desc = ((ImageIcon)animalToDelete.getIcon()).getDescription();

					if (desc == "Cow")
						currentUser.getFootPrint().setServingOfBeef(-1);
					if (desc == "Lamb")
						currentUser.getFootPrint().setServingOfLamb(-1);
					if (desc == "Chicken")
						currentUser.getFootPrint().setServingOfChicken(-1);

					System.out.println("*Removing the button*");
					System.out.println("   Size of the array: " + buttonsOnRight.size());
					
					//int index = buttonsOnRight.indexOf(animalToDelete);
					int toDeleteX = ((JButton)arg0.getSource()).getBounds().x;
					int toDeleteY = ((JButton)arg0.getSource()).getBounds().y;
					int index = 0;
					
					for (int i = 0; i < buttonsOnRight.size(); i ++){
						if (buttonsOnRight.get(i).getLocation().equals(new Point(toDeleteX, toDeleteY))){
							index = i;
						}
					}
					
					System.out.println("  index: " + index);
					
					System.out.println("    index of button: " + index);
					buttonsOnRight.remove(index);
					betterRepaintJP();
					
					/*
					int toDeleteX = ((JButton)arg0.getSource()).getBounds().x;
					int toDeleteY = ((JButton)arg0.getSource()).getBounds().y;
					Dimension dimensionToDelete = new Dimension(toDeleteX, toDeleteY);

					cleanUpGUI(animalToDelete);
					bottomPanel.remove(animalToDelete);
					*/
				}
			};

			cowButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){

					JButton newCowButton = new JButton();
					newCowButton.addActionListener(rightSideButtonListener);
					newCowButton.setIcon(beefIcon);
					buttonsOnRight.add(newCowButton);
					betterRepaintJP();
					currentUser.getFootPrint().setServingOfBeef(1);
					
					/*
					newCowButton.setBounds(buttonX, buttonY, BUTTON_WIDTH, BUTTON_HEIGHT);

					if (columnCount == 3){
						buttonX = 0;
						buttonY += BUTTON_HEIGHT;
						rowCount++;
						columnCount = 0;
						newCowButton.setBounds(buttonX, buttonY, BUTTON_WIDTH, BUTTON_HEIGHT);
					}
					columnCount++;

					System.out.println("--Button Dimensions (Cow)-- ");
					System.out.println("   x: " + buttonX);
					System.out.println("   y: " + buttonY);

					buttonDimensions.add(new Dimension(buttonX, buttonY));
					buttonsOnRight.add(newCowButton);
					bottomPanel.add(newCowButton);

					buttonX += BUTTON_WIDTH;
					validate();

					

					newCowButton.repaint();
*/
				}
			});

			chickenButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){

					JButton newChickenButton = new JButton();
					buttonsOnRight.add(newChickenButton);
					newChickenButton.addActionListener(rightSideButtonListener);
					newChickenButton.setIcon(chickenIcon);
					betterRepaintJP();
					currentUser.getFootPrint().setServingOfChicken(1);
					
					/*
					newChickenButton.setBounds(buttonX, buttonY, BUTTON_WIDTH, BUTTON_HEIGHT);


					if (columnCount == 3){
						buttonX = 0;
						buttonY += BUTTON_HEIGHT;
						rowCount++;
						columnCount = 0;
						newChickenButton.setBounds(buttonX, buttonY, BUTTON_WIDTH, BUTTON_HEIGHT);
					}
					columnCount++;

					System.out.println("--Button Dimensions (Chicken)-- ");
					System.out.println("   x: " + buttonX);
					System.out.println("   y: " + buttonY);

					buttonDimensions.add(new Dimension(buttonX, buttonY));
					buttonsOnRight.add(newChickenButton);
					bottomPanel.add(newChickenButton);

					buttonX += BUTTON_WIDTH;
					validate();

					

					newChickenButton.repaint();
					*/
				}
			});



			lambButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){


					JButton newLambButton = new JButton();
					newLambButton.addActionListener(rightSideButtonListener);
					newLambButton.setIcon(lambIcon);
					buttonsOnRight.add(newLambButton);
					betterRepaintJP();
					currentUser.getFootPrint().setServingOfLamb(1);
					
					/*
					newLambButton.setBounds(buttonX, buttonY, BUTTON_WIDTH, BUTTON_HEIGHT);


					if (columnCount == 3){
						buttonX = 0;
						buttonY += BUTTON_HEIGHT;
						rowCount++;
						columnCount = 0;
						newLambButton.setBounds(buttonX, buttonY, BUTTON_WIDTH, BUTTON_HEIGHT);
					}
					columnCount++;

					System.out.println("--Button Dimensions (Lamb)-- ");
					System.out.println("   x: " + buttonX);
					System.out.println("   y: " + buttonY);

					buttonDimensions.add(new Dimension(buttonX, buttonY));
					buttonsOnRight.add(newLambButton);
					bottomPanel.add(newLambButton);

					buttonX += BUTTON_WIDTH;
					currentUser.getFootPrint().setServingOfLamb(1);

					validate();
					repaint();

*/
				}
			});
		}
	}

	public void betterRepaintJP(){
		int row = 0;
		int column = 0;
		
		if (buttonsOnRight.size() == 0){
			bottomPanel.removeAll();
		}
		
		for (int i = 0; i < buttonsOnRight.size(); i++){
			System.out.println("*In Repaint*");
			row = i/6;
			column = i%6;
			System.out.println("  row: " + row + ", column: " + column);
			buttonsOnRight.get(i).setBounds(column*BUTTON_WIDTH, row*BUTTON_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT);
			System.out.println("  newX: " + column*BUTTON_WIDTH + ", newY: " + row*BUTTON_HEIGHT);
	
			bottomPanel.add(buttonsOnRight.get(i));
		}
		
		repaint();
		
	}
	
	public void cleanUpGUI(JButton buttonToDelete){	
		System.out.println("**CleanUpGUI**");
		int index = 0;
		int toShiftX = 0;
		int toShiftY = 0;
		Point toDeleteLocation = buttonToDelete.getLocation();

		int toDelX = buttonToDelete.getLocation().x;
		int toDelY = buttonToDelete.getLocation().y;

		//int toDeleteX = buttonToDelete.getBounds().x;
		//int toDeleteY = buttonToDelete.getBounds().y;
		//Dimension dimensionToDelete = new Dimension(toDeleteX, toDeleteY);

		for (int i = 0; i < buttonsOnRight.size(); i++){
			System.out.println("Location of button: " + buttonsOnRight.get(i).getLocation() + ", location to delete: " + toDeleteLocation);

			if ((buttonsOnRight.get(i).getLocation()).equals(toDeleteLocation)){
				System.out.println(" Removing the button at position " + i + ", size before: " + buttonsOnRight.size());
				index = i;
				buttonsOnRight.remove(i);
				buttonsOnRight.trimToSize();
			}
		}

		System.out.println("***** buttonsOnRight size= " + buttonsOnRight.size() + ", index = " + index);
		if (buttonsOnRight.size() != 0){
			if (index == buttonsOnRight.size()){
				System.out.println("  index == buttonsOnRight.size(): index= " + index + ", size= " + buttonsOnRight.size());
				toShiftX = buttonsOnRight.get(index-1).getLocation().x;
				toShiftY = buttonsOnRight.get(index-1).getLocation().y;
				System.out.println("     toShiftX = " + toShiftX + ", toShiftY= " + toShiftY);
			}

			else{
				for (int j = index; j < buttonsOnRight.size(); j++){
					System.out.println("-*-Inside the for loop in remove");
					toShiftX = buttonsOnRight.get(j).getX();
					toShiftY = buttonsOnRight.get(j).getY();

					if (toShiftX != 0){

						System.out.println("** Shifting NOT at x = 0 **");
						System.out.println("    toDeleteX: " + toShiftX + ", toDeleteY: " + toShiftY);
						System.out.println("    New dimensions:");

						buttonsOnRight.get(j).setBounds(toShiftX -= BUTTON_WIDTH, toShiftY, BUTTON_WIDTH, BUTTON_HEIGHT);

						System.out.println("      new toDeleteX: " + toShiftX + ", new toDeleteY: " + toShiftY);
					}
					else{
						System.out.println("** Shifting at x = 0 **");
						System.out.println("    toDeleteX: " + toShiftX + ", toDeleteY: " + toShiftY);
						System.out.println("    New dimensions:");

						buttonsOnRight.get(j).setBounds(toShiftX += (BUTTON_WIDTH*2), toShiftY -= BUTTON_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT);

						System.out.println("      new toDeleteX: " + toShiftX + ", new toDeleteY: " + toShiftY);
					}

				}
			}
		}

		System.out.println(" ---checking the shiftX: ");
		System.out.println("     ShiftX: " + toShiftX);
		System.out.println("     ShiftY: " + toShiftY);

		if (toShiftX == 0){
			buttonX = BUTTON_WIDTH;
			buttonY = toShiftY;
			columnCount = 1;
			
			System.out.println("    toShiftX == 0, buttonx = " + buttonX + ", buttony = " + buttonY);
		}

		else if (toShiftX == BUTTON_WIDTH){
			buttonX = BUTTON_WIDTH*2;
			buttonY = toShiftY;
			columnCount = 2;
			System.out.println("    toShiftX == B_W, buttonx = " + buttonX + ", buttony = " + buttonY);
		}
		else if (toShiftX == BUTTON_WIDTH*2){
			buttonX = 0;
			buttonY = toShiftY;
			columnCount = 3;
			System.out.println("    toShiftX == B_W*2, buttonx = " + buttonX + ", buttony = " + buttonY);
		}

		repaintJP();
	}

	public void repaintJP(){
		bottomPanel.removeAll();

		for (int i = 0; i < buttonsOnRight.size(); i++){
			bottomPanel.add(buttonsOnRight.get(i));
		}

		validate();
		repaint();
	}

	/**
	 * addNotify()
	 * 
	 * This method creates a new Thread for the game to run on.
	 * 
	 */
	@Override
	public void addNotify() {
		super.addNotify();
		dragToPlate = new Thread(this);
		dragToPlate.start();
	} 

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bkgd, 0,0, null);

		 waterBottle=currentUser.getFootPrint().getWaterBottle().getImage();
		 bottle=waterBottle.getImage();
		 g.drawImage(bottle, 450 ,20, null);
		//Graphics2D graphicsObject2d = (Graphics2D) g;
		//graphicsObject2d.drawImage(platePicture, 200, 200, this);

		//System.out.println(bkgd.getWidth(null));
	}	

	@Override
	public void run() {


		//************
		//below here is just the stuff to create a thread and have it move smoothly
		long beforeTime, timeDiff, timeSleep;
		beforeTime = System.currentTimeMillis();


		while (true) {

			repaint();

			//proper time delay to make the elements
			//loop like that are properly animated
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
}
