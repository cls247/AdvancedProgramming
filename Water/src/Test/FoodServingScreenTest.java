package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

import Water.FoodServingScreen;

/**
 * FoodServingScreenTest
 * 
 * JUnit tests for the FoodServingScreenTest 
 * 
 * @author sophiakleyman
 *
 */
public class FoodServingScreenTest {

	// data members that will be tested in each of the functions 
	static FoodServingScreen testFoodServingScreen = new FoodServingScreen();
	int expectedNumberButtonsClicked;
	int actualNumberButtonsClicked;
	double expectedAmountOfWater;
	double actualTotalAmountOfWater;
	
	/**
	 * testFoodServingScreen()
	 * 
	 * Test the foodServingScreen constructor to ensure that the screen
	 * was constructed by testing that the data member testFoodServingScreen
	 * is not null/exists
	 */
	@Test
	public void testFoodServingScreen() {
		// check that the data member was created correctly
		assertNotNull(testFoodServingScreen);
	}
	
	/**
	 * testMakeTopButton()
	 * 
	 * Test to test that the makeTopButton function accurately create the 
	 * action listener for the buttons on the top panel so that when they are 
	 * clicked, the water footprint is accurately increased
	 */
	@Test
	public void testMakeTopButton() {
		// change the expected values: number of buttons clicked should be 1,
		// and the expected amount of water is the water footprint of one serving of beer
		expectedNumberButtonsClicked = 1;
		expectedAmountOfWater = 2024.0;

		// get the total amount of water after the cowButton has been clicked
		// (this happens in the setUp function)
		actualTotalAmountOfWater = testFoodServingScreen.getCurrentUser()
				.getFootPrint().getTotalAmountOfWater();

		// get the size of the buttonsOnBottomPanel array
		// size should be 1 because there should only be one button in that panel
		actualNumberButtonsClicked = testFoodServingScreen.getButtonArray()
				.size();

		// assert that the expected and actual are both one  
		assertEquals(expectedNumberButtonsClicked, actualNumberButtonsClicked,
				0);

		// assert that the actual and expected are both 2024.0
		assertEquals(expectedAmountOfWater, actualTotalAmountOfWater, 0);
	}
	
	/**
	 * testMakeBottomButton()
	 * 
	 * Tests that the function makeBottomButton accurately creates the action listener
	 * for the buttons on the bottom panel so that when they are clicked
	 * the water footprint accurately decreases
	 */
	@Test
	public void testMakeBottomButton() {
		// index 0 of the buttonsOnBottomPanel array is the button that was
		// clicked in setUp()
		JButton bottomButton = testFoodServingScreen.getButtonArray().get(0);
		
		// click the button to activate the action listener
		bottomButton.doClick();
		
		// both expected values should be 0 because the button should be removed 
		// from the array/panel
		expectedNumberButtonsClicked = 0;
		expectedAmountOfWater = 0;
		
		// get the total amount of water
		actualTotalAmountOfWater = testFoodServingScreen.getCurrentUser()
				.getFootPrint().getTotalAmountOfWater();
		
		// get the actual number of buttons clicked
		actualNumberButtonsClicked = testFoodServingScreen.getButtonArray()
				.size();
		
		// assert that both are 0
		assertEquals(actualNumberButtonsClicked, expectedNumberButtonsClicked,
				0);

		// assert that both are 0
		assertEquals(actualTotalAmountOfWater, expectedAmountOfWater, 0);
		
	}

	/**
	 * setUp()
	 * 
	 * Clicks the test button in the testFoodServingScreen so that the action
	 * listeners can be tested, and initializes the expected and actual data members
	 * to 0 so they can be accurately changed in each test
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		testFoodServingScreen.getTestButton().doClick();
		
		expectedNumberButtonsClicked = 0;
		actualNumberButtonsClicked = 0;
		expectedAmountOfWater = 0;
		actualTotalAmountOfWater = 0;
	}

}
