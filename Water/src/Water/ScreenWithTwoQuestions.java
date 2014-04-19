package Water;

import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScreenWithTwoQuestions extends JPanel{

	
	private String firstQuestion;
	private String secondQuestion;
	private String thirdQuestion;
	
	public ScreenWithTwoQuestions(String firstQuestion1, String secondQuestion1, String thirdQuestion1)
	{
		firstQuestion=firstQuestion1;
		secondQuestion=secondQuestion1;
		thirdQuestion=thirdQuestion1;
		init();
	}
	public void init()
	{
		//we need to save all this data, I didn't do that
		//here we would add the background image
		setLayout(new GridLayout(2, 2));
		//ask the first question
		JLabel firstQuestionLabel = new JLabel(firstQuestion+"?", JLabel.CENTER);
		add(firstQuestionLabel);
		//answer the first question
		final JCheckBox firstQuestionBox = new JCheckBox();
		add(firstQuestionBox);
		//ask the second questions
		JLabel secondQuestionlabel = new JLabel(secondQuestion+"?", JLabel.CENTER);
		add(secondQuestionlabel);
		//answer the second question
		final JCheckBox secondQuestionBox = new JCheckBox();
		add(secondQuestionBox);
		//need error checking to make sure that these two questions are mutually exclusive
		
		//ask the third question
		JLabel thirdQuestionLabel = new JLabel(thirdQuestion+"?", JLabel.CENTER);
		add(thirdQuestionLabel);
		//answer the third question
		JFormattedTextField answerToThirdQuestion = new JFormattedTextField();
		answerToThirdQuestion.setBounds(25, 330, 56, 20);
        add(answerToThirdQuestion);
        answerToThirdQuestion.setValue(new Double(10.0));
        //we need to save this data, and error check to make sure that the numbers are responable
		
	}



}
