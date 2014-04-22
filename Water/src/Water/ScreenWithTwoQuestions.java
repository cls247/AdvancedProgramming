package Water;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
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

public class ScreenWithTwoQuestions extends JPanel implements ActionListener, Global{

	
	private String firstQuestion;
	private String secondQuestion;
	private String thirdQuestion;
	private String type;
	private Image bkgd;
	
	public ScreenWithTwoQuestions(String firstQuestion1, String secondQuestion1, String thirdQuestion1, String type1)
	{
		firstQuestion=firstQuestion1;
		secondQuestion=secondQuestion1;
		thirdQuestion=thirdQuestion1;
		type=type1;
		init();
	}
	public void init()
	{
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
		setLayout(new GridLayout(4, 4));
		//ask the first question
		JLabel firstQuestionLabel = new JLabel(firstQuestion+"?", JLabel.CENTER);
		add(firstQuestionLabel);
		//answer the first question
		final JCheckBox firstQuestionBox = new JCheckBox();
		add(firstQuestionBox);
		firstQuestionBox.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(type=="bottle")
					Global.currentUser.getFootPrint().setUsesRecyclableWaterBottle(true);				
				if(type=="plants")
					Global.currentUser.getFootPrint().setUsesSprinklers(true);
				if(type=="bathing")
					Global.currentUser.getFootPrint().setTakesShowers(true);
				if(type=="dishes")
					Global.currentUser.getFootPrint().setUsesDishWasher(true);
				if(type=="clothes")
					Global.currentUser.getFootPrint().setUsesWashingMachine(true);
			}
			
		});
		//ask the second questions
		JLabel secondQuestionlabel = new JLabel(secondQuestion+"?", JLabel.CENTER);
		add(secondQuestionlabel);
		//answer the second question
		final JCheckBox secondQuestionBox = new JCheckBox();
		add(secondQuestionBox);
		//need error checking to make sure that these two questions are mutually exclusive
		secondQuestionBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(type=="bottle")
					Global.currentUser.getFootPrint().setUsesPlasticWaterBottle(true);				
				if(type=="plants")
					Global.currentUser.getFootPrint().setHandWaters(true);
				if(type=="bathing")
					Global.currentUser.getFootPrint().setTakesBaths(true);
				if(type=="dishes")
					Global.currentUser.getFootPrint().setDoesDishedByHand(true);
				if(type=="clothes")
					Global.currentUser.getFootPrint().setHandWashesClothes(true);
			}
			
		});
		//ask the third question
		JLabel thirdQuestionLabel = new JLabel(thirdQuestion+"?", JLabel.CENTER);
		add(thirdQuestionLabel);
		//answer the third question
		//JFormattedTextField answerToThirdQuestion = new JFormattedTextField();
		//answerToThirdQuestion.setBounds(25, 330, 56, 20);
        //add(answerToThirdQuestion);
        //answerToThirdQuestion.setValue(new Double(10.0));
        //String answer=answerToThirdQuestion.getText();
		final JSpinner m_numberSpinner;
	    SpinnerNumberModel m_numberSpinnerModel;
	    Double current = new Double(1.00);
	    Double min = new Double(0.00);
	    Double max = new Double(100.00);
	    Double step = new Double(1.00);
	    m_numberSpinnerModel = new SpinnerNumberModel(current, min, max, step);
	    m_numberSpinner = new JSpinner(m_numberSpinnerModel);
	    add(m_numberSpinner);
	    m_numberSpinner.addChangeListener(new ChangeListener()
	    {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				Double answer= (Double) (m_numberSpinner.getValue());
			    int temp=answer.intValue();
		        if(type=="bottle")
					Global.currentUser.getFootPrint().setNumberOfWaterBottles(temp);				
				if(type=="plants")
					Global.currentUser.getFootPrint().setNumberOfTimesWaterPlants(temp);
				if(type=="bathing")
					Global.currentUser.getFootPrint().setNumberOfWashes(temp);
				if(type=="dishes")
					Global.currentUser.getFootPrint().setNumberOfTimesDoesDishes(temp);
				if(type=="clothes")
					Global.currentUser.getFootPrint().setNumberOfLoadsOfClothes(temp);
			}
	    	
	    });

        //we need to save this data, and error check to make sure that the numbers are responable
	    
	    
	    JLabel imageLabel=new JLabel();
	    ImageIcon waterBottle=currentUser.getFootPrint().getWaterBottle().getImage();

	    
	    imageLabel.setIcon(waterBottle);
	    add(imageLabel);

		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void paintComponent(Graphics g){

		
		g.drawImage(bkgd, 0,0, null);

		}

	}

