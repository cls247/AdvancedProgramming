package Water;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		JPanel jp = new JPanel();
		jp.setPreferredSize(new Dimension(400,800));// changed it to preferredSize, Thanks!
		frame.getContentPane().add( jp );// adding to content pane will work here. Please read the comment bellow.
		frame.pack();
		//ImageIcon background=new ImageIcon("Water/background");
		//Image bkgrd=background.getImage();
		
		

		//this is that thing that holds all the card
		final JPanel contentPane = new JPanel();
		contentPane.setLayout(new CardLayout(100, 100));
		contentPane.setPreferredSize(new Dimension(400,600));

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
				"How many water bottles do you use a week?", "bottle");
		contentPane.add(chooseWaterBottle, CARD_JRADIOBUTTON);
		ScreenWithTwoQuestions waterPlants = new ScreenWithTwoQuestions("Do you use sprinkles?", 
				"Do you water your lawn by hand?", 
				"How many times a week do you water the lawn?", "plants");
		contentPane.add(waterPlants, CARD_JRADIOBUTTON);
		ScreenWithTwoQuestions washDishes = new ScreenWithTwoQuestions("Do you use a dishwasher?", 
				"Do you wash dishes by hand?", 
				"How many times a week do you wash dishes", "dishes");
		contentPane.add(washDishes, CARD_JRADIOBUTTON);
		ScreenWithTwoQuestions washClothes = new ScreenWithTwoQuestions("Do you use a washing machine?", 
				"Do you wash clothes by hand", 
				"How many loads of laundry do you do in a week?", "clothes");
		contentPane.add(washClothes, CARD_JRADIOBUTTON);
		ScreenWithTwoQuestions bathingWin = new ScreenWithTwoQuestions("Do you take showers?", 
				"Do you take baths", 
				"How many times a week do you wash yourself?", "clothes");
		contentPane.add(bathingWin, CARD_JRADIOBUTTON);
		TipScreen finalTipScreen=new TipScreen();
		contentPane.add(finalTipScreen, CARD_JRADIOBUTTON);
		
        ScreenWithFoodQuestions  chooseMeat = new ScreenWithFoodQuestions("How many servings of meat do you eat each week?");
        contentPane.add(chooseMeat, CARD_JRADIOBUTTON);
        ScreenWithFoodQuestions  chooseGrains = new ScreenWithFoodQuestions("How many servings of grains do you eat each week?");
        contentPane.add(chooseGrains, CARD_JRADIOBUTTON);
        ScreenWithFoodQuestions  chooseFruitsAndVeggies = new ScreenWithFoodQuestions("How many servings of fruits and veggies do you eat each week?");
        contentPane.add(chooseFruitsAndVeggies, CARD_JRADIOBUTTON);
        ScreenWithDraw DragMeat = new ScreenWithDraw("Meat");
        contentPane.add(DragMeat, CARD_JRADIOBUTTON);
		
		
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
