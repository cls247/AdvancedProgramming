package Water;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This is just the Welcome screen that is the first screen
 * that is shown. It welcomes the user and has buttons to 
 * manuvere throughout the program. 
 * @author Sand
 *
 */
class CardDriver extends JPanel
{
	//string that holds the text to welcome the user
	private String welcomeText = "Welcome to Help2Out, a water footprint calculator!";

	//all the screens that answer questions
	private static ScreenWithTwoQuestions chooseWaterBottle;
	private static ScreenWithTwoQuestions waterPlants;
	private static ScreenWithTwoQuestions washDishes;
	private static ScreenWithTwoQuestions bathingWin;
	private static ScreenWithTwoQuestions washClothes;
	private static FoodServingScreen meatScreen;
	
	//button to move backward and forward
	private JButton previousButton;
	private JButton nextButton;
	
	private JPanel buttonPanel;
	
	//arraylist of all the screens 
	private ArrayList<Screen> allTheScreens=new ArrayList<Screen>();
	
	//user that will be passed in and out of the 
	// screen in order to update the user
	private User currentUser=new User();

	//this is the current index of the card that the cardlayout is displaying
	private static int indexOfCardLayout=0;
	
	//this is the number of cards that there are in the cardlayout
	private static int numberOfCards=8;

	//this is the JPanel that has the cardlayout that is going to be flippe through
	private JPanel pages;

	/**
	 * CardDriver()
	 * 
	 * This method just calls init to set default values of the screen.
	 * 
	 */
	public CardDriver()
	{
		init();
	}

	/**
	 * init() 
	 * 
	 */
	private void init() 
	{   		
		JPanel bigPane = new JPanel(new BorderLayout());

		buttonPanel = new JPanel(); 
		buttonPanel.setFocusable(true);

		//add a button to go forward
		previousButton = new JButton("PREVIOUS");
		previousButton.setBackground(Color.BLACK);
		previousButton.setForeground(Color.BLACK);
		previousButton.setFocusable(true);

		nextButton = new JButton("NEXT");
		nextButton.setBackground(Color.RED);
		nextButton.setForeground(Color.BLACK);
		nextButton.setFocusable(true);

		buttonPanel.add(previousButton);
		buttonPanel.add(nextButton);
    
		pages = new JPanel(new CardLayout());

		StartScreen startScreen = new StartScreen();
		startScreen.receiveUser(currentUser);
		pages.add(startScreen,"start");

		allTheScreens.add((Screen) startScreen);
		chooseWaterBottle = new ScreenWithTwoQuestions("Do you use recyclable bottles?", 
				"Do you use plastic water bottles?", 
				"How many water bottles do you use a week?", "bottle");
		pages.add(chooseWaterBottle, "first");

		allTheScreens.add((Screen) chooseWaterBottle);
		waterPlants = new ScreenWithTwoQuestions("Do you use sprinkles?", 
				"Do you water your lawn by hand?", 
				"How many times a week do you water the lawn?", "plants");
		pages.add(waterPlants, "second");

		allTheScreens.add((Screen) waterPlants);
		washDishes = new ScreenWithTwoQuestions("Do you use a dishwasher?", 
				"Do you wash dishes by hand?", 
				"How many times a week do you wash dishes", "dishes");
		pages.add(washDishes, "third");

		allTheScreens.add((Screen) washDishes);
		washClothes = new ScreenWithTwoQuestions("Do you use a washing machine?", 
				"Do you wash clothes by hand", 
				"How many loads of laundry do you do in a week?", "clothes");
		pages.add(washClothes, "fourth");

		allTheScreens.add((Screen) washClothes);
		bathingWin = new ScreenWithTwoQuestions("Do you take showers?", 
				"Do you take baths", 
				"How many times a week do you wash yourself?", "clothes");
		pages.add(bathingWin, "fifth");

		allTheScreens.add((Screen) bathingWin);
		meatScreen=new FoodServingScreen();

		allTheScreens.add((Screen) meatScreen);
		pages.add(meatScreen, "sixth");

		TipScreen finalTipScreen=new TipScreen();
		pages.add(finalTipScreen, "sixth");

		InteractivePage interactive = new InteractivePage();
		pages.add(interactive, "seventh");

		allTheScreens.add((Screen) finalTipScreen);
		allTheScreens.add((Screen) interactive);
		previousButton.setVisible(false);

		//this moves backward through the card layout
		previousButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("index of card"+indexOfCardLayout);
				if(indexOfCardLayout-1>0)
				{
					indexOfCardLayout--;
					System.out.println("is this working");
					CardLayout cardLayout = (CardLayout) pages.getLayout();

					cardLayout.previous(pages);
					moveUserBackward(indexOfCardLayout);
				}
				if(indexOfCardLayout==numberOfCards)
					nextButton.setVisible(false);
				else
					nextButton.setVisible(true);
				if(indexOfCardLayout!=0)
					previousButton.setVisible(true);
				else
					previousButton.setVisible(false);
			}
		});

		//this flips to the next card
		nextButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(indexOfCardLayout+1<=numberOfCards)
				{

					indexOfCardLayout++;
					System.out.println("is the next button wokring");
					//frame.setVisible(false);
					pages.setVisible(true);
					CardLayout cardLayout = (CardLayout) pages.getLayout();
					cardLayout.next(pages);  
					moveUserForward(indexOfCardLayout);
				}
				if(indexOfCardLayout==numberOfCards)
					nextButton.setVisible(false);
				else
					nextButton.setVisible(true);
				if(indexOfCardLayout!=0)
					previousButton.setVisible(true);
				else
					previousButton.setVisible(false);
			}
		});
		bigPane.add(pages, BorderLayout.CENTER);
		bigPane.add(buttonPanel, BorderLayout.PAGE_END);

		add(bigPane);

	}
	
	
	/**
	 * moveUserForward(int index)
	 * 
	 * This method is used to move the User from one screen
	 * to the next screen moving in a forward direction.
	 * 
	 * @param index is the index of the screen that is being updated
	 */
	public void moveUserForward(int index){


		int currentScreenIndex = index;
		int nextScreenIndex = index+1;
		//get the current screen and the next screen and update
		//the user of the next screen
		Screen currentScreen = (Screen) allTheScreens.get(currentScreenIndex);
		Screen nextScreen = (Screen) allTheScreens.get(nextScreenIndex);
		User userToPass = currentScreen.passOnUser();
		nextScreen.receiveUser(userToPass);
	}

	public void moveUserBackward(int index){
		int currentScreenIndex = index;
		int previousScreenIndex = index-1;
		Screen currentScreen = (Screen) allTheScreens.get(currentScreenIndex);
		Screen previousScreen = (Screen) allTheScreens.get(previousScreenIndex);
		User userToPass = currentScreen.passOnUser();
		previousScreen.receiveUser(userToPass);
	}


}



