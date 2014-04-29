package Water;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This is the template for the majority of the pages. It gets questions in its
 * constructor to change the each page so it is specific to the information to
 * be input.
 */


public class QuestionScreen extends JPanel implements ActionListener, Runnable,
		Screen {

	// questions that are to be asked
	private String firstQuestion;
	private String secondQuestion;
	private String thirdQuestion;

	// type of questions that are asked on this screen
	private String type;

	// this image is the background
	private Image bkgd;
	JLabel imageLabel;

	// this is the image for the water bottle to print
	ImageIcon waterBottle;
	Image bottle;
	private final int DELAY = 20;

	// this is the thread for this question to run on
	private Thread bottleThread;
	private User currentUser = new User();

	// these are the toggle boxes for the first two questions
	final JCheckBox firstQuestionBox = new JCheckBox();
	final JCheckBox secondQuestionBox = new JCheckBox();

	// this is the label and answer box for the third question
	JSpinner m_numberSpinner = new JSpinner();
	JLabel thirdQuestionLabel = new JLabel();

	/**
	 * QuestionScreen(String firstQuestion1, String secondQuestion1, String
	 * thirdQuestion1, String type1)
	 * 
	 * This constructor makes a screen that has the three questions that are
	 * passed in and sets a type for the screen.
	 * 
	 * @param firstQuestion1
	 * @param secondQuestion1
	 * @param thirdQuestion1
	 * @param type1
	 *            this is the type that the question screen is going to be of
	 */
	public QuestionScreen(String firstQuestion1, String secondQuestion1,
			String thirdQuestion1, String type1) {
		firstQuestion = firstQuestion1;
		secondQuestion = secondQuestion1;
		thirdQuestion = thirdQuestion1;
		type = type1;
		init();
	}

	/**
	 * init()
	 * 
	 * This method sets all the main details for the screen.
	 */
	@Override
	public void init() {
		startThread();
		drawBackground();
		createFirstLabelAndButton();
		createSecondLabelAndButton();
		createThirdLabelAndSpinner();
	}

	/**
	 * createThirdLabelAndSpinner()
	 * 
	 * This method sets up the third question and the answer for the question.
	 */
	private void createThirdLabelAndSpinner() {

		// ask the third question
		thirdQuestionLabel = new JLabel(thirdQuestion);
		thirdQuestionLabel.setSize(350, 50);
		thirdQuestionLabel.setLocation(125, 300);

		// make a spinner for the third question to
		// be answered
		SpinnerNumberModel m_numberSpinnerModel;
		Double current = new Double(0.00);
		Double min = new Double(0.00);
		Double max = new Double(20.00);
		Double step = new Double(1.00);

		// set the max
		m_numberSpinnerModel = new SpinnerNumberModel(current, min, max, step);
		m_numberSpinner = new JSpinner(m_numberSpinnerModel);

		// set the default information on the spinner
		m_numberSpinner.setSize(100, 50);
		m_numberSpinner.setLocation(500, 300);
		((JSpinner.DefaultEditor) m_numberSpinner.getEditor())
				.setPreferredSize(new Dimension(10, 10));
		((JSpinner.DefaultEditor) m_numberSpinner.getEditor()).getTextField()
				.setEditable(false);

		spinnerAction();

		add(m_numberSpinner);
		add(thirdQuestionLabel);

		m_numberSpinner.setVisible(false);
		thirdQuestionLabel.setVisible(false);
	}

	private void spinnerAction() {
		m_numberSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				Double answer = (Double) (m_numberSpinner.getValue());

				int temp = answer.intValue();

				// check the type of the question and set the footprint
				// accordingly
				if (type == "bottle")
					currentUser.getFootPrint().setNumberOfWaterBottles(temp);
				if (type == "plants")
					currentUser.getFootPrint()
							.setNumberOfTimesWaterPlants(temp);
				if (type == "bathing")
					currentUser.getFootPrint().setNumberOfWashes(temp);
				if (type == "dishes")
					currentUser.getFootPrint().setNumberOfTimesDoesDishes(temp);
				if (type == "clothes")
					currentUser.getFootPrint().setNumberOfLoadsOfClothes(temp);
			}
		});
	}

	private void createSecondLabelAndButton() {
		// ask the second questions
		JLabel secondQuestionlabel = new JLabel(secondQuestion);
		secondQuestionlabel.setVisible(true);
		secondQuestionlabel.setSize(250, 50); // ***NICK MADE CHANGES HERE
		secondQuestionlabel.setLocation(125, 200);
		add(secondQuestionlabel);

		// answer the second question
		// final JCheckBox secondQuestionBox = new JCheckBox();
		secondQuestionBox.setVisible(true);
		secondQuestionBox.setSize(50, 50);
		secondQuestionBox.setLocation(400, 200);
		add(secondQuestionBox);

		// need error checking to make sure that these two questions are
		// mutually exclusive
		secondQuestionBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				firstQuestionBox.setSelected(false);

				// check the type of the question and set the footprint
				// accordingly
				if (type == "bottle")
					currentUser.getFootPrint().setUsesPlasticWaterBottle();
				if (type == "plants")
					currentUser.getFootPrint().setHandWaters();
				if (type == "bathing")
					currentUser.getFootPrint().setTakesBaths();
				if (type == "dishes")
					currentUser.getFootPrint().setDoesDishedByHand();
				if (type == "clothes")
					currentUser.getFootPrint().setHandWashesClothes();

			}

		});
	}

	private void createFirstLabelAndButton() {
		// create and set up the first question
		JLabel firstQuestionLabel = new JLabel(firstQuestion);
		firstQuestionLabel.setVisible(true);
		firstQuestionLabel.setSize(250, 50);
		firstQuestionLabel.setLocation(125, 85);

		// add it to the screen
		add(firstQuestionLabel);

		// answer the first question
		firstQuestionBox.setVisible(true);
		firstQuestionBox.setSize(50, 20);
		firstQuestionBox.setLocation(400, 100);
		add(firstQuestionBox);
		firstQuestionBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				secondQuestionBox.setSelected(false);

				// check the type of the question and set the footprint
				// accordingly
				if (type == "bottle")
					currentUser.getFootPrint().setUsesRecyclableWaterBottle();
				if (type == "plants")
					currentUser.getFootPrint().setUsesSprinklers();
				if (type == "bathing")
					currentUser.getFootPrint().setTakesShowers();
				if (type == "dishes")
					currentUser.getFootPrint().setUsesDishWasher();
				if (type == "clothes")
					currentUser.getFootPrint().setUsesWashingMachine();
			}
		});
	}

	/**
	 * setBackground()
	 * 
	 * sets the background image and dimensions
	 */
	private void setBackground() {
		setPreferredSize(new Dimension(800, 600));
		try {

			// get the image from the file
			bkgd = ImageIO.read(new File("background.jpg"));

			// get the dimensions of the image
			Dimension size = new Dimension(bkgd.getWidth(null),
					bkgd.getHeight(null));

			// set the frame dimensions based on the image size
			setPreferredSize(size);
			setMinimumSize(size);
			setMaximumSize(size);
			setSize(size);
			setLayout(null);

		} catch (IOException error) {

		}
	}

	/**
	 * startThread()
	 * 
	 * funtion that starts theThread
	 */
	private void startThread() {
		bottleThread = new Thread(this);
		bottleThread.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * paintComponent(Graphics g)
	 * 
	 * paints the background and other elements onto the screen
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// draw the background image
		g.drawImage(bkgd, 0, 0, null);

		// get the waterBottle and draw it on the screen
		waterBottle = currentUser.getFootPrint().getWaterBottle().getImage();
		bottle = waterBottle.getImage();
		g.drawImage(bottle, 600, 20, null);

		addMoreQuestions();
		checkForCheckedBoxes();
	}

	/**
	 * addMoreQuestions()
	 * 
	 * If either question box on the screen is checked, this method will display
	 * a third question with a spinner asking the user to select how much they
	 * consume per week
	 */
	private void addMoreQuestions() {

		// check that either one of the two questions is selected
		if (firstQuestionBox.isSelected() || secondQuestionBox.isSelected()) {

			// display the third question/spinner
			m_numberSpinner.setVisible(true);
			thirdQuestionLabel.setVisible(true);

		}

		// check if neither has been checked
		if ((!firstQuestionBox.isSelected())
				&& (!secondQuestionBox.isSelected())) {

			// set the question/spinner to invisible
			m_numberSpinner.setVisible(false);
			thirdQuestionLabel.setVisible(false);
		}
	}

	/**
	 * checkForCheckedBoxes()
	 * 
	 * This method will check if the first or second question on each screen was
	 * selected, and set the opposite to unchecked so that only one can be
	 * checked at a time
	 */
	private void checkForCheckedBoxes() {

		// check if the first question is not selected
		if ((!firstQuestionBox.isSelected())) {
			// set everything unclicked
			if (type == "bottle")
				currentUser.getFootPrint()
						.setUsesRecyclableWaterBottleUnclicked();
			if (type == "plants")
				currentUser.getFootPrint().setUsesSprinklersUnclicked();
			if (type == "bathing")
				currentUser.getFootPrint().setShowersUnclicked();
			if (type == "dishes")
				currentUser.getFootPrint().setUsesDishWasherUnclicked();
			if (type == "clothes")
				currentUser.getFootPrint().setUsesWashingMachineUnclicked();
		}

		// check if the second question is not selected
		if ((!secondQuestionBox.isSelected())) {
			// set everythign to unclicked
			if (type == "bottle")
				currentUser.getFootPrint().setUsesPlasticWaterBottleUnclicked();
			if (type == "plants")
				currentUser.getFootPrint().setHandWatersUnclicked();
			if (type == "bathing")
				currentUser.getFootPrint().setBathsUnclicked();
			if (type == "dishes")
				currentUser.getFootPrint().setDoesDishesByHandUnclicked();
			if (type == "clothes")
				currentUser.getFootPrint().setHandWashesClothesUnclicked();
		}

		// update the total amount of water
		currentUser.getFootPrint().updateTotalAmountOfWater();

	}

	/**
	 * run()
	 * 
	 * Override the run method to start the thread and make the animation move
	 * smoothly
	 */
	@Override
	public void run() {
		long beforeTime, timeDiff, timeSleep;
		beforeTime = System.currentTimeMillis();

		while (true) {
			repaint();

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
	 * passOnUser()
	 * 
	 * this method passes the user out of the screen so it can be received by
	 * another one
	 */
	@Override
	public User passOnUser() {
		return currentUser;
	}

	/**
	 * receiveUser()
	 * 
	 * receives the user from the previous page and updates values on the page
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
			System.out
					.println("Error in drawBackground: image file failed to load!");
		}

	}

	/**
	 * getFirstQuestion()
	 * 
	 * @return firstQuestion
	 */
	public String getFirstQuestion() {
		return firstQuestion;
	}

	/**
	 * getSpinner()
	 * 
	 * @return m_numberSpinner
	 */
	public JSpinner getSpinner() {
		return m_numberSpinner;
	}

	/**
	 * getButton2()
	 * 
	 * @return secondQuestionBox
	 */
	public JCheckBox getButton2() {
		return secondQuestionBox;
	}

	/**
	 * getButton1()
	 * 
	 * @return firstQuestionBox
	 */
	public JCheckBox getButton1() {
		return firstQuestionBox;
	}

}