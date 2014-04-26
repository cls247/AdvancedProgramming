package Water;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
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

public class ScreenWithTwoQuestions extends JPanel implements ActionListener, Runnable, Screen{

	// strings that hold the questions to print to the screen

	private String firstQuestion;
	private String secondQuestion;
	private String thirdQuestion;

	private String type;

	//image for the background
	private Image bkgd;

	private JLabel imageLabel;
	private ImageIcon waterBottle;
	Image bottle;

	//constant for the thread to look smooth
	private final int DELAY = 20;
	private Thread bottleThread;

	//user that is being updated
	private User currentUser=new User();

	private final JCheckBox firstQuestionBox = new JCheckBox();
	private final JCheckBox secondQuestionBox = new JCheckBox();
	private JSpinner m_numberSpinner = new JSpinner();
	private JLabel thirdQuestionLabel = new JLabel();

	/**
	 * ScreenWithTwoQuestions()
	 * 
	 * This constructor takes in strings that are the questions to print on the screen
	 * and a string to define the type of the screen with two questions.
	 * 
	 * @param firstQuestion1
	 * @param secondQuestion1
	 * @param thirdQuestion1
	 * @param type1
	 */
	public ScreenWithTwoQuestions(String firstQuestion1, String secondQuestion1, String thirdQuestion1, String type1)
	{
		firstQuestion=firstQuestion1;
		secondQuestion=secondQuestion1;
		thirdQuestion=thirdQuestion1;
		type=type1;
		init();
	}
	
	
	@Override
	public void init()
	{
		setPreferredSize(new Dimension(800,600));

		bottleThread=new Thread(this);
		bottleThread.start();
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
		//we need to save all this data, I didn't do that
		//here we would add the background image

		//ask the first question
		JLabel firstQuestionLabel = new JLabel(firstQuestion+"?");
		firstQuestionLabel.setVisible(true);
		firstQuestionLabel.setSize(250,20);
		firstQuestionLabel.setLocation(125, 100);
		add(firstQuestionLabel);

		//answer the first question
		//		final JCheckBox firstQuestionBox = new JCheckBox();
		firstQuestionBox.setVisible(true);
		firstQuestionBox.setSize(50,20);
		firstQuestionBox.setLocation(400, 100);
		add(firstQuestionBox);
		firstQuestionBox.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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

		//ask the second questions
		JLabel secondQuestionlabel = new JLabel(secondQuestion+"?");
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
		//ask the third question
		thirdQuestionLabel = new JLabel(thirdQuestion+"?");
		thirdQuestionLabel.setSize(350,20);
		thirdQuestionLabel.setLocation(125, 300);

		//answer the third question
		//JFormattedTextField answerToThirdQuestion = new JFormattedTextField();
		//answerToThirdQuestion.setBounds(25, 330, 56, 20);
		//add(answerToThirdQuestion);
		//answerToThirdQuestion.setValue(new Double(10.0));
		//String answer=answerToThirdQuestion.getText();
		SpinnerNumberModel m_numberSpinnerModel;
		Double current = new Double(1.00);
		Double min = new Double(0.00);
		Double max = new Double(100.00);
		Double step = new Double(1.00);
		m_numberSpinnerModel = new SpinnerNumberModel(current, min, max, step);
		m_numberSpinner = new JSpinner(m_numberSpinnerModel);

		m_numberSpinner.setSize(100,50);
		m_numberSpinner.setLocation(500,300);
		((JSpinner.DefaultEditor) m_numberSpinner.getEditor()).setPreferredSize(new Dimension(10,10));
		((JSpinner.DefaultEditor) m_numberSpinner.getEditor()).getTextField().setEditable(false);


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

		add(m_numberSpinner);
		add(thirdQuestionLabel);

		m_numberSpinner.setVisible(false);
		thirdQuestionLabel.setVisible(false);

		//		if(selected){
		//			//ask the third question
		//			JLabel thirdQuestionLabel = new JLabel(thirdQuestion+"?");
		//			thirdQuestionLabel.setVisible(true);
		//			thirdQuestionLabel.setSize(350,20);
		//			thirdQuestionLabel.setLocation(125, 300);
		//			add(thirdQuestionLabel);
		//			//answer the third question
		//			//JFormattedTextField answerToThirdQuestion = new JFormattedTextField();
		//			//answerToThirdQuestion.setBounds(25, 330, 56, 20);
		//	        //add(answerToThirdQuestion);
		//	        //answerToThirdQuestion.setValue(new Double(10.0));
		//	        //String answer=answerToThirdQuestion.getText();
		//			final JSpinner m_numberSpinner;
		//		    SpinnerNumberModel m_numberSpinnerModel;
		//		    Double current = new Double(1.00);
		//		    Double min = new Double(0.00);
		//		    Double max = new Double(100.00);
		//		    Double step = new Double(1.00);
		//		    m_numberSpinnerModel = new SpinnerNumberModel(current, min, max, step);
		//		    m_numberSpinner = new JSpinner(m_numberSpinnerModel);
		//		    
		//		    m_numberSpinner.setSize(100,50);
		//		    m_numberSpinner.setLocation(500,300);
		//		    ((JSpinner.DefaultEditor) m_numberSpinner.getEditor()).setPreferredSize(new Dimension(10,10));
		//		    ((JSpinner.DefaultEditor) m_numberSpinner.getEditor()).getTextField().setEditable(false);
		//		    add(m_numberSpinner);
		//		   
		//		    
		//		    m_numberSpinner.addChangeListener(new ChangeListener()
		//		    {
		//	
		//				@Override
		//				public void stateChanged(ChangeEvent arg0) {
		//					// TODO Auto-generated method stub
		//					Double answer= (Double) (m_numberSpinner.getValue());
		//					
		//				    int temp=answer.intValue();
		//				    System.out.println("the value of the spinner is"+temp);
		//			        if(type=="bottle")
		//						Global.currentUser.getFootPrint().setNumberOfWaterBottles(temp);				
		//					if(type=="plants")
		//						Global.currentUser.getFootPrint().setNumberOfTimesWaterPlants(temp);
		//					if(type=="bathing")
		//						Global.currentUser.getFootPrint().setNumberOfWashes(temp);
		//					if(type=="dishes")
		//						Global.currentUser.getFootPrint().setNumberOfTimesDoesDishes(temp);
		//					if(type=="clothes")
		//						Global.currentUser.getFootPrint().setNumberOfLoadsOfClothes(temp);
		//				}
		//		    });
		//	    	
		//		}

		//we need to save this data, and error check to make sure that the numbers are responable




	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(bkgd, 0,0, null);
		//		System.out.println("how many time is this called");
		//		System.out.println("the current water bottle is paint is "+ currentUser.getFootPrint().getWaterBottle().getCurrentBottle());
		waterBottle=currentUser.getFootPrint().getWaterBottle().getImage();
		bottle=waterBottle.getImage();
		g.drawImage(bottle, 600,20, null);

		addMoreQuestions();
	}

	/**
	 * addMoreQuestions()
	 * 
	 * This method makes sure that the thrid question is asked
	 * only after one of the first two questions is answered.
	 */
	private void addMoreQuestions(){

		if(firstQuestionBox.isSelected() || secondQuestionBox.isSelected()){

			m_numberSpinner.setVisible(true);
			thirdQuestionLabel.setVisible(true);

		}else if((!firstQuestionBox.isSelected())){

			m_numberSpinner.setVisible(false);
			thirdQuestionLabel.setVisible(false);

		}

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
	
	
	/**
	 * passOnUser()
	 * This method returns the user to the control class.
	 */
	@Override
	public User passOnUser() {
		return currentUser;
	}
	
	/**
	 *  receiveUser(User setCurrentUser)
	 * This method takes in a User and sets the current
	 * user to the user that is passed in.
	 */
	@Override
	public void receiveUser(User setCurrentUser) {
		currentUser=setCurrentUser;
		
	}

}
