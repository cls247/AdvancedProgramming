package Water;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class firstScreen
{
	private static final String CARD_JBUTTON =  "Card JButton";
	private static final String CARD_JTEXTFIELD = "Card JTextField";    
	private static final String CARD_JRADIOBUTTON = "Card JRadioButton";

	private static void createAndShowGUI()
	{
		//here you make the frame
		JFrame frame = new JFrame("Water");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		//this is that thing that holds all the card
		final JPanel contentPane = new JPanel();
		contentPane.setLayout(new CardLayout(200, 200));

		//make all the card and add them to the contentPane above
		WelcomeScreen welcomeWin = new WelcomeScreen();
		contentPane.add(welcomeWin, CARD_JBUTTON);
		AboutScreen aboutWin=new AboutScreen();
		contentPane.add(aboutWin, CARD_JBUTTON);
		AllTipScreen tipsScreen=new AllTipScreen();
		contentPane.add(tipsScreen, CARD_JBUTTON);
		TeacherPage teachWin=new TeacherPage();
		contentPane.add(teachWin, CARD_JBUTTON); 
		InteractivePage interactiveWin=new InteractivePage();
		contentPane.add(interactiveWin, CARD_JBUTTON);
		ScreenWithTwoQuestions chooseWaterBottle = new ScreenWithTwoQuestions("Do you use recyclable bottles?", 
				"Do you use plastic water bottles?", 
				"How many water bottles do you use a week?");
		contentPane.add(chooseWaterBottle, CARD_JRADIOBUTTON);
		ScreenWithTwoQuestions waterPlants = new ScreenWithTwoQuestions("Do you use sprinkles?", 
				"Do you water your lawn by hand?", 
				"How many times a week do you water the lawn?");
		contentPane.add(waterPlants, CARD_JRADIOBUTTON);

		//this is the buttons to go forward and backward
		JPanel buttonPanel = new JPanel(); 
		final JButton aboutButton=new JButton("ABOUT");
		final JButton teacherButton=new JButton("TEACHER");
		final JButton tipButton=new JButton("TIP");
		final JButton welcomeButton=new JButton("WELCOME");
		final JButton startButton=new JButton("START");
		aboutButton.setBackground(Color.BLACK);       
		aboutButton.setForeground(Color.WHITE);

		final JButton previousButton = new JButton("PREVIOUS");
		previousButton.setBackground(Color.BLACK);
		previousButton.setForeground(Color.WHITE);

		final JButton nextButton = new JButton("NEXT");
		nextButton.setBackground(Color.RED);
		nextButton.setForeground(Color.WHITE);

		buttonPanel.add(previousButton);
		buttonPanel.add(nextButton);
		buttonPanel.add(aboutButton);
		buttonPanel.add(teacherButton);
		buttonPanel.add(tipButton);
		buttonPanel.add(welcomeButton);
		buttonPanel.add(startButton);

		//this starts the event
		startButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
				cardLayout.show(contentPane, "chooseWaterBottle");
			}
		});
		
		//this switches to the about screen
		aboutButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
				cardLayout.show(contentPane, "aboutWin");
			}
		});

		//this switches to the tip screen
		tipButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
				cardLayout.show(contentPane, "teachWin");
			}
		});
		//this flips to the teacher screen
		teacherButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
				cardLayout.show(contentPane, "teacherScreen");
			}
		});
		//this flips to the previous card
		previousButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
				cardLayout.previous(contentPane);
			}
		});

		//this flips to the next card
		nextButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
				cardLayout.next(contentPane);   
			}
		});

		frame.add(contentPane, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.PAGE_END);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String... args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				createAndShowGUI();
			}
		});
	}
} 