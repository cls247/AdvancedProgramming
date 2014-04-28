package Water;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

/**
 * Despite the name, this is not a class. It is actually the driver of all the classes.
 * The name will change eventually.
 * This class sets up all the tabs for the project and allows the user to flip
 * through all of the tabs. It creates an instance of a class for every screen
 * that is to be shown. 
 *
 *
 */
public class ScreenDriver
{
	//create all the screens that are going to be tabs
	//from the first page
	
	private static CardDriver welcomeScreen;
	private static TeacherPage teacherScreen;
	private static AboutScreen aboutScreen;
	private static AllTipScreen tips;
	

	
	public void addComponentToPane(final Container pane){
		
		JTabbedPane tabs = new JTabbedPane();
		
		//create all of the first couple of screens
		welcomeScreen = new CardDriver();
		teacherScreen = new TeacherPage();
		aboutScreen=new AboutScreen();
		tips=new AllTipScreen();
		
		//add all the screens to the card layout
		pane.add(welcomeScreen);
		pane.add(teacherScreen);
		pane.add(aboutScreen);
		pane.add(tips);
		/*
		//make all the screens with the appropriate questions
		ScreenWithTwoQuestions chooseWaterBottle = new ScreenWithTwoQuestions("Do you use recyclable bottles?", 
		"Do you use plastic water bottles?", 
		"How many water bottles do you use a week?", "bottle");
		//pane.add(chooseWaterBottle);
		ScreenWithTwoQuestions waterPlants = new ScreenWithTwoQuestions("Do you use sprinkles?", 
		"Do you water your lawn by hand?", 
		"How many times a week do you water the lawn?", "plants");
		//pane.add(waterPlants);
		ScreenWithTwoQuestions washDishes = new ScreenWithTwoQuestions("Do you use a dishwasher?", 
		"Do you wash dishes by hand?", 
		"How many times a week do you wash dishes", "dishes");
		//pane.add(washDishes);
		ScreenWithTwoQuestions washClothes = new ScreenWithTwoQuestions("Do you use a washing machine?", 
		"Do you wash clothes by hand", 
		"How many loads of laundry do you do in a week?", "clothes");
		//pane.add(washClothes);
		ScreenWithTwoQuestions bathingWin = new ScreenWithTwoQuestions("Do you take showers?", 
		"Do you take baths", 
		"How many times a week do you wash yourself?", "clothes");
		//pane.add(bathingWin);
		ScreenWithDraw tempBeef=new ScreenWithDraw("meat");
		ScreenWithFoodQuestions  chooseMeat = new ScreenWithFoodQuestions("How many servings of meat do you eat each week?");
		//pane.add(chooseMeat);

		ScreenWithFoodQuestions  chooseGrains = new ScreenWithFoodQuestions("How many servings of grains do you eat each week?");
		//pane.add(chooseGrains);

		ScreenWithFoodQuestions  chooseFruitsAndVeggies = new ScreenWithFoodQuestions("How many servings of fruits and veggies do you eat each week?");
		//pane.add(chooseFruitsAndVeggies);

		TipScreen finalScreen = new TipScreen();
		//pane.add(finalScreen);
		*/
		//make tabs for all of the screen so that we can flip between them.
		tabs.addTab("Home", welcomeScreen);
		tabs.addTab("Teacher", teacherScreen);
		tabs.addTab("About", aboutScreen);
		tabs.addTab("Tips", tips);
		//this is what i took out
		/*
		tabs.addTab("Water bottles", chooseWaterBottle);
		tabs.addTab("Water plants", waterPlants);
		
		tabs.addTab("Wash dishes", washDishes);
		tabs.addTab("Wash clothes", washClothes);
		
		tabs.addTab("Bath", bathingWin);
		tabs.addTab("Temporary beef", tempBeef);
		tabs.addTab("Meat", chooseMeat);
		tabs.addTab("Grains", chooseGrains);
		
		tabs.addTab("Fruits and Veggies", chooseFruitsAndVeggies);

		tabs.addTab("final", finalScreen);
		
		finalScreen.updateTotal();
		*/
		pane.add(tabs, BorderLayout.CENTER);
		
	}
	
	/**
	 * createAndShowGUI()
	 * 
	 * This method sets up the JFrame in order to show the GUI to the user.
	 * 
	 */
	private static void createAndShowGUI()
	{
    	//here you make the frame to contain all the tabs
		final JFrame frame = new JFrame("Water");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setPreferredSize(new Dimension(1000,800));
		frame.setFocusable(true);
		
//		JPanel jp = new JPanel();
//		jp.setPreferredSize(new Dimension(800,600));// changed it to preferredSize, Thanks!
//		frame.getContentPane().add( jp );// adding to content pane will work here. Please read the comment bellow.
//		frame.pack();

		//this is the driver to switch between panels
		ScreenDriver driver = new ScreenDriver();
		driver.addComponentToPane(frame.getContentPane());
		
		frame.pack();
		frame.setVisible(true);
		
		//this is that thing that holds all the card
		final JPanel contentPane = new JPanel();
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.setPreferredSize(new Dimension(800, 600));
		contentPane.setVisible(false);
		contentPane.setFocusable(true);
		//***********
		frame.getContentPane().add(contentPane);

//*I COMMENTED IT OUT STARTING HERE -V		
////
////		//make all the card and add them to the contentPane above
////		WelcomeScreen welcomeWin = new WelcomeScreen();
////		contentPane.add(welcomeWin, CARD_JBUTTON);
////		
//////		AboutScreen aboutWin=new AboutScreen();
//////		contentPane.add(aboutWin, CARD_JBUTTON);
////		
//////		AllTipScreen tipsScreen=new AllTipScreen();
//////		contentPane.add(tipsScreen, CARD_JBUTTON);
////		
//////		TeacherPage teachWin=new TeacherPage();
//////		contentPane.add(teachWin, CARD_JBUTTON); 
////		
//////		InteractivePage interactiveWin=new InteractivePage();
//////		contentPane.add(interactiveWin, CARD_JBUTTON);
////		
//
////		
// //       ScreenWithFoodQuestions  chooseMeat = new ScreenWithFoodQuestions("How many servings of meat do you eat each week?");
////        contentPane.add(chooseMeat, CARD_JRADIOBUTTON);
////        
////        ScreenWithFoodQuestions  chooseGrains = new ScreenWithFoodQuestions("How many servings of grains do you eat each week?");
////        contentPane.add(chooseGrains, CARD_JRADIOBUTTON);
////        
////        ScreenWithFoodQuestions  chooseFruitsAndVeggies = new ScreenWithFoodQuestions("How many servings of fruits and veggies do you eat each week?");
////        contentPane.add(chooseFruitsAndVeggies, CARD_JRADIOBUTTON);
////        
////        ScreenWithDraw DragMeat = new ScreenWithDraw("Meat");
////        contentPane.add(DragMeat, CARD_JRADIOBUTTON);
////		
////		
////		//this is the buttons to go forward and backward
//		JPanel buttonPanel = new JPanel(); 
//		buttonPanel.setFocusable(true);
////		
////		final JButton aboutButton = new JButton("ABOUT");
////		final JButton teacherButton = new JButton("TEACHER");
////		final JButton tipButton = new JButton("TIP");
//////		final JButton welcomeButton = new JButton("WELCOME");
////		final JButton startButton = new JButton("START");
////		aboutButton.setBackground(Color.BLACK);       
////		aboutButton.setForeground(Color.BLACK);
////
//		final Button previousButton = new Button("PREVIOUS");
//		previousButton.setBackground(Color.BLACK);
//		previousButton.setForeground(Color.BLACK);
//		previousButton.setFocusable(true);
//		//		
////
//		final Button nextButton = new Button("NEXT");
//		nextButton.setBackground(Color.RED);
//		nextButton.setForeground(Color.BLACK);
//		nextButton.setFocusable(true);
////
//		buttonPanel.add(previousButton);
//		buttonPanel.add(nextButton);
////		buttonPanel.add(aboutButton);
////		buttonPanel.add(teacherButton);
////		buttonPanel.add(tipButton);
//////		buttonPanel.add(welcomeButton);
////		buttonPanel.add(startButton);
////
////		//this starts the event
////		startButton.addActionListener(new ActionListener()
////		{
////			public void actionPerformed(ActionEvent ae)
////			{
////				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
////				cardLayout.show(contentPane, "chooseWaterBottle");
////			}
////		});
////		
////		//this switches to the about screen
////		aboutButton.addActionListener(new ActionListener()
////		{
////			public void actionPerformed(ActionEvent ae)
////			{
//////				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
//////				cardLayout.show(contentPane, "aboutWin");
////				
////				AboutScreen aboutScreen=new AboutScreen();
////				contentPane.add(aboutScreen, "aboutScreen");
////			}
////		});
////
////		//this switches to the tip screen
////		tipButton.addActionListener(new ActionListener()
////		{
////			public void actionPerformed(ActionEvent ae)
////			{
//////				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
//////				cardLayout.show(contentPane, "teachWin");
////				
////				AllTipScreen tipsScreen=new AllTipScreen();
////				contentPane.add(tipsScreen, "tipsScreen");
////			}
////		});
////		//this flips to the teacher screen
////		teacherButton.addActionListener(new ActionListener()
////		{
////			public void actionPerformed(ActionEvent ae)
////			{
//////				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
//////				cardLayout.show(contentPane, "teachWin");
////			
//////				JPanel teacher = new JPanel();
//////				contentPane.add(teacher, "teachWin");
////				
////				TeacherPage teacherScreen = new TeacherPage();
////				contentPane.add(teacherScreen, "teacherScreen"); 
////				
////				
////			}
////		});
////	
////		
//		
//		
//		
//		chooseWaterBottle = new ScreenWithTwoQuestions("Do you use recyclable bottles?", 
//				"Do you use plastic water bottles?", 
//					"How many water bottles do you use a week?", "bottle");
//			contentPane.add(chooseWaterBottle, CARD_JRADIOBUTTON);
//			waterPlants = new ScreenWithTwoQuestions("Do you use sprinkles?", 
//					"Do you water your lawn by hand?", 
//					"How many times a week do you water the lawn?", "plants");
//			contentPane.add(waterPlants, CARD_JRADIOBUTTON);
//			washDishes = new ScreenWithTwoQuestions("Do you use a dishwasher?", 
//					"Do you wash dishes by hand?", 
//					"How many times a week do you wash dishes", "dishes");
//			contentPane.add(washDishes, CARD_JRADIOBUTTON);
//			washClothes = new ScreenWithTwoQuestions("Do you use a washing machine?", 
//					"Do you wash clothes by hand", 
//					"How many loads of laundry do you do in a week?", "clothes");
//			contentPane.add(washClothes, CARD_JRADIOBUTTON);
//			 bathingWin = new ScreenWithTwoQuestions("Do you take showers?", 
//					"Do you take baths", 
//					"How many times a week do you wash yourself?", "clothes");
//			contentPane.add(bathingWin, CARD_JRADIOBUTTON);
//			TipScreen finalTipScreen=new TipScreen();
//			contentPane.add(finalTipScreen, CARD_JRADIOBUTTON);
//		
//		
////		//this flips to the previous card
//		previousButton.addActionListener(new ActionListener()
//		{
//			public void actionPerformed(ActionEvent ae)
//			{
//				System.out.println("index of card"+indexOfCardLayout);
//				if(indexOfCardLayout-1>=0)
//				{
//
//				indexOfCardLayout--;
//				System.out.println("is this working");
//				contentPane.setVisible(true);
//				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
//				cardLayout.previous(contentPane);
//				}
//			}
//		});
//
//		//this flips to the next card
//		nextButton.addActionListener(new ActionListener()
//		{
//			public void actionPerformed(ActionEvent ae)
//			{
//				if(indexOfCardLayout+1<=numberOfCards)
//				{
//
//				indexOfCardLayout++;
//				System.out.println("is the next button wokring");
//				//frame.setVisible(false);
//				contentPane.setVisible(true);
//				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
//				cardLayout.next(contentPane);   
//				}
//			}
//		});

		frame.add(contentPane, BorderLayout.CENTER);
		//frame.add(buttonPanel, BorderLayout.PAGE_END);

		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * main(String[] args)
	 * 
	 * This method just runs and shows the GUI
	 * @param args
	 */
	public static void main(String[] args)
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
