package Water;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This is just the Welcome screen that is the first screen
 * that is shown. It welcomes the user and has buttons to 
 * manuvere throughout the program. 
 * @author Sand
 *
 */
public class CardDriver extends JPanel
{
	//all the screens that answer questions
	private static QuestionScreen chooseWaterBottle;
	private static QuestionScreen waterPlants;
	private static QuestionScreen washDishes;
	private static QuestionScreen bathingWin;
	private static QuestionScreen washClothes;
	private static FoodServingScreen meatScreen;
	
	//buttons to move backward and forward
	private JButton previousButton;
	private JButton nextButton;
	
	//Jpanel that holds the buttons
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
	 * This method sets up the button panel and all the 
	 * screens that go in the Card Layout.
	 */
	private void init() 
	{   		
		JPanel bigPane = new JPanel(new BorderLayout());

		buttonPanel = new JPanel(); 
		buttonPanel.setFocusable(true);

		//add a button to go backward
		makePreviousButton();

		//add a button to go forward
		makeNextButton();

		//add the buttons to the panel
		buttonPanel.add(previousButton);
		buttonPanel.add(nextButton);
    
		pages = new JPanel(new CardLayout());

		//make all the screens in the Card Layout
		makeScreens();

		bigPane.add(pages, BorderLayout.CENTER);
		bigPane.add(buttonPanel, BorderLayout.PAGE_END);

		//add the card layout to the screen
		add(bigPane);

	}

	/**
	 * makeScreens()
	 * 
	 * This method makes all the screen to be flipped 
	 * through throughout the CardDriver. Each of the screens
	 * are made and added to the card layout. 
	 */
	
	private void makeScreens() {
		
		StartScreen startScreen = new StartScreen();
		startScreen.receiveUser(currentUser);
		pages.add(startScreen,"start");

		allTheScreens.add((Screen) startScreen);
		chooseWaterBottle = new QuestionScreen("<html><p><h3>Do you use a recyclable water bottles?</h3></p></html>", 
				"<html><p><h3>Do you use disposable plastic water bottles?</h3></p></html>", 
				"<html><p><h3>How many water bottles do you use a week?</h3></p></html>", "bottle");
		pages.add(chooseWaterBottle, "first");

		allTheScreens.add((Screen) chooseWaterBottle);
		waterPlants = new QuestionScreen("<html><p><h3>Do you use sprinklers to water your lawn?</h3></p></html>", 
				"<html><p><h3>Do you water your lawn by hand?</h3></p></html>", 
				"<html><p><h3>How many times a week do you water your lawn?</h3></p></html>", "plants");
		pages.add(waterPlants, "second");

		allTheScreens.add((Screen) waterPlants);
		washDishes = new QuestionScreen("<html><p><h3>Do you use a dishwasher?</h3></p></html>", 
				"<html><p><h3>Do you wash your dishes by hand?</h3></p></html>", 
				"<html><p><h3>How many times a week do you wash your dishes?</h3></p></html>", "dishes");
		pages.add(washDishes, "third");

		allTheScreens.add((Screen) washDishes);
		washClothes = new QuestionScreen("<html><p><h3>Do you use a washing machine to do your laundry?</h3></p></html>", 
				"<html><p><h3>Do you wash your clothes by hand?</h3></p></html>", 
				"<html><p><h3>How many loads of laundry do you wash in a week?</h3></p></html>", "clothes");
		pages.add(washClothes, "fourth");

		allTheScreens.add((Screen) washClothes);
		bathingWin = new QuestionScreen("<html><p><h3>Do you take showers?</h3></p></html>", 
				"<html><p><h3>Do you take baths?</h3></p></html>", 
				"<html><p><h3>How many times a week do you shower or bathe?</h3></p></html>", "bathing");
		pages.add(bathingWin, "fifth");

		allTheScreens.add((Screen) bathingWin);
		meatScreen=new FoodServingScreen();

		allTheScreens.add((Screen) meatScreen);
		pages.add(meatScreen, "sixth");

		TipScreen finalTipScreen=new TipScreen();
		pages.add(finalTipScreen, "seventh");

		InteractivePage interactive = new InteractivePage();
		pages.add(interactive, "eigth");

		allTheScreens.add((Screen) finalTipScreen);
		allTheScreens.add((Screen) interactive);
	}

	/**
	 * makeNextButton()
	 * 
	 * This method makes the "next" buttons and writes
	 * the code for what it does when it is clicked.
	 * 
	 */
	public void makeNextButton() {
		nextButton = new JButton("NEXT");
		nextButton.setBackground(Color.RED);
		nextButton.setForeground(Color.BLACK);
		nextButton.setFocusable(true);
		
		//this flips to the next card
		nextButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(indexOfCardLayout+1<=numberOfCards)
				{

					indexOfCardLayout++;
					//frame.setVisible(false);
					pages.setVisible(true);
					CardLayout cardLayout = (CardLayout) pages.getLayout();
					cardLayout.next(pages);  
					moveUserForward(indexOfCardLayout);
				}
				//set the next and previous buttons only to be shown if 
				//they are able to be pressed
				if(indexOfCardLayout!=numberOfCards)
					nextButton.setVisible(true);
				else
					nextButton.setVisible(false);
				if(indexOfCardLayout!=1)
					previousButton.setVisible(true);
				else
					previousButton.setVisible(false);
			}
		});
	}
	
	/**
	 * makePreviousButton()
	 * 
	 * This method makes the "previous" button and
	 * has the code for what occurs when the button
	 * is pressed.
	 * 
	 */

	public void makePreviousButton() {
		//make the button to move backward in the card layout
		previousButton = new JButton("PREVIOUS");
		previousButton.setBackground(Color.BLACK);
		previousButton.setForeground(Color.BLACK);
		previousButton.setFocusable(true);
		previousButton.setVisible(false);

		//this moves backward through the card layout
		previousButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				//*****NICK DELETED A SYSTEM.OUT HERE
				if(indexOfCardLayout-1>0)
				{
					indexOfCardLayout--;
					//*****NICK DELETED A SYSTEM.OUT HERE
					CardLayout cardLayout = (CardLayout) pages.getLayout();

					cardLayout.previous(pages);
					moveUserBackward(indexOfCardLayout);
				}

				//set the buttons so they will only be shown if they can
				//be pressed
				if(indexOfCardLayout!=numberOfCards)
					nextButton.setVisible(true);
				else
					nextButton.setVisible(false);
				if(indexOfCardLayout!=1)
					previousButton.setVisible(true);
				else
					previousButton.setVisible(false);
			}
		});
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
		
		if(index <8)
		{
			int currentScreenIndex = index;
			int nextScreenIndex = index+1;
			
			//get the current screen and the next screen and update
			//the user of the next screen
			Screen currentScreen = (Screen) allTheScreens.get(currentScreenIndex);
			Screen nextScreen = (Screen) allTheScreens.get(nextScreenIndex);
			User userToPass = currentScreen.passOnUser();
			nextScreen.receiveUser(userToPass);
		}
	}

	
	/**
	 * moveUserBackward(int index)
	 * 
	 * This method is used to move the User from one screen
	 * to the next screen moving in a backward direction.
	 * 
	 * @param index is the index of the screen that is being updated
	 */
	public void moveUserBackward(int index){
		
		int currentScreenIndex = index;
		int previousScreenIndex = index-1;
		Screen currentScreen = (Screen) allTheScreens.get(currentScreenIndex);
		Screen previousScreen = (Screen) allTheScreens.get(previousScreenIndex);
		User userToPass = currentScreen.passOnUser();
		previousScreen.receiveUser(userToPass);
		
	}
	
	//from here onward, these accessor functions are for JUnit testing
	public JButton getNext(){
		
		return nextButton;
		
	}
	
	public JButton getPrevious(){
		
		return previousButton;
		
	}

	public int getIndex(){
		
		return indexOfCardLayout;
		
	}
	
	public void setIndex(int thisIndexOfCardLayout){
		
		indexOfCardLayout = thisIndexOfCardLayout;
		
	}
	
	public int getTotalOfScreens(){
		
		return allTheScreens.size();
		
	}

}



