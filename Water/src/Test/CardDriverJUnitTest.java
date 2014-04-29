package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Water.CardDriver;
import Water.User;

public class CardDriverJUnitTest {

	/**
	 * testCardDriverConstructor()
	 * 
	 * tests the cardDriver class constructor method
	 */
	@Test
	public void testCardDriverConstructor() {

		CardDriver testCardDriver = new CardDriver();
		int screenNumber = 9;
		assertEquals(screenNumber, testCardDriver.getTotalOfScreens());

	}

	/**
	 * testAddNextButton()
	 * 
	 * test the addNextButton() method
	 */
	@Test
	public void testAddNextButton() {
		int testIndex = 2;
		CardDriver testCardDriver = new CardDriver();

		// make the next button and simulate that it has been clicked
		testCardDriver.makeNextButton();
		testCardDriver.setIndex(testIndex);
		testCardDriver.getNext().doClick();

		// test that the indexes are equal
		assertEquals(testIndex + 1, testCardDriver.getIndex());

	}

	/**
	 * testMoveUserForward()
	 * 
	 * test the moveUserForward() method
	 */
	@Test
	public void testMoveUserForward() {

		// create a new test cardDriver and User
		CardDriver testCardDriver = new CardDriver();
		User testUser = new User();
		int testServing = 10;
		int testIndex = 2;

		// get the user's footprint
		testUser.getFootPrint().setServingOfPasta(testServing);

		// move the test user forward
		testCardDriver.moveUserForward(testIndex);

		assertEquals(testServing, testUser.getFootPrint().getServingOfPasta());

	}

	/**
	 * testAddPreviousButton()
	 * 
	 * test the addPreviousButton method
	 */
	@Test
	public void testAddPreviousButton() {

		int testIndex = 2;
		CardDriver testCardDriver = new CardDriver();

		// make the previous button and set the index
		testCardDriver.makePreviousButton();
		testCardDriver.setIndex(testIndex);

		// simulate a click
		testCardDriver.getPrevious().doClick();

		assertEquals(testIndex - 1, testCardDriver.getIndex());

	}

	/**
	 * testMoveUserBackward()
	 * 
	 * test the moveUserBackward method
	 */
	@Test
	public void testMoveUserBackward() {

		// create a new cardDriver and User
		CardDriver testCardDriver = new CardDriver();
		User testUser = new User();
		int testServing = 10;
		int testIndex = 2;

		// set the serving size of pasta
		testUser.getFootPrint().setServingOfPasta(testServing);

		// move the user back
		testCardDriver.moveUserBackward(testIndex);

		assertEquals(testServing, testUser.getFootPrint().getServingOfPasta());

	}

}
