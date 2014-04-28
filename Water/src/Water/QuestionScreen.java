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
 * This is the template for the majority of the pages.
 * It gets questions in its constuctor to change the 
 * each page so it is specific to the information to 
 * be input. 
 * 
 * @author Sand
 *
 */

public class QuestionScreen extends JPanel implements ActionListener, Runnable, Screen{


	//questions that are to be asked
	private String firstQuestion;
	private String secondQuestion;
	private String thirdQuestion;
	
	//type of questions that are asked on this screen
	private String type;
	
	//this image is the background
	private Image bkgd;
	JLabel imageLabel;
	
	//this is the image for the water bottle to print
	ImageIcon waterBottle;
	Image bottle;
	private final int DELAY = 20;
	
	//this is the thread for this question to run on
	private Thread bottleThread;
	private User currentUser = new User();

	//these are the toggle boxes for the first two questions
	final JCheckBox firstQuestionBox = new JCheckBox();
	final JCheckBox secondQuestionBox = new JCheckBox();
	
	//this is the label and answer box for the third question
	JSpinner m_numberSpinner = new JSpinner();
	JLabel thirdQuestionLabel = new JLabel();

	
	/**
	 * QuestionScreen(String firstQuestion1, String secondQuestion1, String thirdQuestion1, String type1)
	 * 
	 * This constructor makes a screen that has the three questions that 
	 * are passed in and sets a type for the screen.
	 * 
	 * @param firstQuestion1
	 * @param secondQuestion1
	 * @param thirdQuestion1
	 * @param type1 this is the type that the question screen is going to be of
	 */
	public QuestionScreen(String firstQuestion1, String secondQuestion1, String thirdQuestion1, String type1)
	{
		firstQuestion=firstQuestion1;
		secondQuestion=secondQuestion1;
		thirdQuestion=thirdQuestion1;
		type=type1;
		init();
	}
	
	/**
	 * init()
	 * 
	 * This method sets all the main details for the screen.
	 */
	@Override
	public void init()
	{
		startThread();
		drawBackground();
		//setBackground();
		createFirstLabelAndButton();
		createSecondLabelAndButton();
		createThirdLabelAndSpinner();
	}
	
	/**
	 * createThirdLabelAndSpinner()
	 * 
	 * This method sets up the third question and the answer
	 * for the question.
	 */
	private void createThirdLabelAndSpinner() {
		
		//ask the third question
		thirdQuestionLabel = new JLabel(thirdQuestion);
		thirdQuestionLabel.setSize(350,20);
		thirdQuestionLabel.setLocation(125, 300);

		//make a spinner for the third question to 
		//be answered
		SpinnerNumberModel m_numberSpinnerModel;
		Double current = new Double(1.00);
		Double min = new Double(0.00);
		Double max = new Double(100.00);
		Double step = new Double(1.00);
		
		//set the max
		m_numberSpinnerModel = new SpinnerNumberModel(current, min, max, step);
		m_numberSpinner = new JSpinner(m_numberSpinnerModel);

		//set the default information on the spinner
		m_numberSpinner.setSize(100,50);
		m_numberSpinner.setLocation(500,300);
		((JSpinner.DefaultEditor) m_numberSpinner.getEditor()).setPreferredSize(new Dimension(10,10));
		((JSpinner.DefaultEditor) m_numberSpinner.getEditor()).getTextField().setEditable(false);

		
		spinnerAction();

		add(m_numberSpinner);
		add(thirdQuestionLabel);

		m_numberSpinner.setVisible(false);
		thirdQuestionLabel.setVisible(false);
	}

	private void spinnerAction() {
		m_numberSpinner.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				Double answer= (Double) (m_numberSpinner.getValue());

				int temp=answer.intValue();
				System.out.println("the value of the spinner is"+temp);
				if(type=="bottle")
					currentUser.getFootPrint().setNumberOfWaterBottles(temp);				
				if(type=="plants")
					currentUser.getFootPrint().setNumberOfTimesWaterPlants(temp);
				if(type=="bathing")
					currentUser.getFootPrint().setNumberOfWashes(temp);
				if(type=="dishes")
					currentUser.getFootPrint().setNumberOfTimesDoesDishes(temp);
				if(type=="clothes")
					currentUser.getFootPrint().setNumberOfLoadsOfClothes(temp);
			}
		});
	}
	
	private void createSecondLabelAndButton() {
		//ask the second questions
		JLabel secondQuestionlabel = new JLabel(secondQuestion);
		secondQuestionlabel.setVisible(true);
		secondQuestionlabel.setSize(250,20);
		secondQuestionlabel.setLocation(125,200);
		add(secondQuestionlabel);

		//answer the second question
		//		final JCheckBox secondQuestionBox = new JCheckBox();
		secondQuestionBox.setVisible(true);
		secondQuestionBox.setSize(50,20);
		secondQuestionBox.setLocation(400, 200);
		add(secondQuestionBox);

		//need error checking to make sure that these two questions are mutually exclusive
		secondQuestionBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				firstQuestionBox.setSelected(false);
				// TODO Auto-generated method stub
				if(type=="bottle")
					currentUser.getFootPrint().setUsesPlasticWaterBottle();				
				if(type=="plants")
					currentUser.getFootPrint().setHandWaters();
				if(type=="bathing")
					currentUser.getFootPrint().setTakesBaths();
				if(type=="dishes")
					currentUser.getFootPrint().setDoesDishedByHand();
				if(type=="clothes")
					currentUser.getFootPrint().setHandWashesClothes();

			}

		});
	}
	private void createFirstLabelAndButton() {
		JLabel firstQuestionLabel = new JLabel(firstQuestion+"?");
		firstQuestionLabel.setVisible(true);
		firstQuestionLabel.setSize(250,20);
		firstQuestionLabel.setLocation(125, 100);
		add(firstQuestionLabel);

		//answer the first question
		firstQuestionBox.setVisible(true);
		firstQuestionBox.setSize(50,20);
		firstQuestionBox.setLocation(400, 100);
		add(firstQuestionBox);
		firstQuestionBox.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				secondQuestionBox.setSelected(false);


				if(type=="bottle")
					currentUser.getFootPrint().setUsesRecyclableWaterBottle();				
				if(type=="plants")
					currentUser.getFootPrint().setUsesSprinklers();
				if(type=="bathing")
					currentUser.getFootPrint().setTakesShowers();
				if(type=="dishes")
					currentUser.getFootPrint().setUsesDishWasher();
				if(type=="clothes")
					currentUser.getFootPrint().setUsesWashingMachine();

			}

		});
	}
	
	private void setBackground() {
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
	}
	private void startThread() {
		bottleThread=new Thread(this);
		bottleThread.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(bkgd, 0,0, null);
		waterBottle=currentUser.getFootPrint().getWaterBottle().getImage();
		bottle=waterBottle.getImage();
		g.drawImage(bottle, 600,20, null);

		addMoreQuestions();
		checkForCheckedBoxes();
	}

	private void addMoreQuestions(){

		if(firstQuestionBox.isSelected() || secondQuestionBox.isSelected()){

			m_numberSpinner.setVisible(true);
			thirdQuestionLabel.setVisible(true);

		}
		if((!firstQuestionBox.isSelected())&&(!secondQuestionBox.isSelected())){

			m_numberSpinner.setVisible(false);
			thirdQuestionLabel.setVisible(false);

		}

	}

	private void checkForCheckedBoxes(){
		
		if((!firstQuestionBox.isSelected())){
			if(type=="bottle")
				currentUser.getFootPrint().setUsesRecyclableWaterBottleUnclicked();
			if(type=="plants")
				currentUser.getFootPrint().setUsesSprinklersUnclicked();
			if(type=="bathing")
				currentUser.getFootPrint().setShowersUnclicked();
			if(type=="dishes")
				currentUser.getFootPrint().setUsesDishWasherUnclicked();
			if(type=="clothes")
				currentUser.getFootPrint().setUsesWashingMachineUnclicked();
		}
		
		if((!secondQuestionBox.isSelected())){
			if(type=="bottle")
				currentUser.getFootPrint().setUsesPlasticWaterBottleUnclicked();
			if(type=="plants")
				currentUser.getFootPrint().setHandWatersUnclicked();
			if(type=="bathing")
				currentUser.getFootPrint().setBathsUnclicked();
			if(type=="dishes")
				currentUser.getFootPrint().setDoesDishesByHandUnclicked();
			if(type=="clothes")
				currentUser.getFootPrint().setDoesDishesByHandUnclicked();
		}
		
		currentUser.getFootPrint().refreshTotal();
		
	}

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
	@Override
	public User passOnUser() {
		return currentUser;
	}
	@Override
	public void receiveUser(User setCurrentUser) {
		currentUser=setCurrentUser;		
	}
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
			System.out.println("Error in drawBackground: image file failed to load!");
		}
		
	}
}