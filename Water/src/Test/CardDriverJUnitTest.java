package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Water.*;

public class CardDriverJUnitTest {
	
	@Test
	public void testCardDriverConstructor(){
		
		CardDriver testCardDriver = new CardDriver();
		int screenNumber = 9;
		assertEquals(screenNumber, testCardDriver.getTotalOfScreens());
		
	}
	
	@Test
	public void testAddNextButton(){
		
		int testIndex = 2;
		CardDriver testCardDriver = new CardDriver();
		testCardDriver.makeNextButton();
		testCardDriver.setIndex(testIndex);
		testCardDriver.getNext().doClick();
		
		assertEquals(testIndex+1, testCardDriver.getIndex());
		
	}
	
	@Test
	public void testMoveUserForward(){
		
		CardDriver testCardDriver = new CardDriver();
		User testUser = new User();
		int testServing = 10;
		int testIndex = 2;
		
		testUser.getFootPrint().setServingOfPasta(testServing);

		testCardDriver.moveUserForward(testIndex);
		
		assertEquals(testServing, testUser.getFootPrint().getServingOfPasta());
		
	}
	
	@Test
	public void testAddPreviousButton(){
		
		int testIndex = 2;
		CardDriver testCardDriver = new CardDriver();
		testCardDriver.makePreviousButton();
		testCardDriver.setIndex(testIndex);
		
		testCardDriver.getPrevious().doClick();
		
		assertEquals(testIndex-1, testCardDriver.getIndex());
		
	}
	
	@Test
	public void testMoveUserBackward(){
		
		CardDriver testCardDriver = new CardDriver();
		User testUser = new User();
		int testServing = 10;
		int testIndex = 2;
		
		testUser.getFootPrint().setServingOfPasta(testServing);

		testCardDriver.moveUserBackward(testIndex);
		
		assertEquals(testServing, testUser.getFootPrint().getServingOfPasta());
		
	}
	
	

}
