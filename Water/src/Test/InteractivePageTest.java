package Test;

import static org.junit.Assert.assertTrue;

import java.awt.Color;

import org.junit.Test;

import Water.FootPrint;
import Water.InteractiveScreen;
import Water.User;

/**
 * InteractivePageTest
 * 
 * JUnit tests for the InteractivePage Class
 * 
 */
public class InteractivePageTest {

	/**
	 * testCheckBooleans()
	 * 
	 * Tests the CheckBoolean method.
	 * 
	 */
	@Test
	public void testCheckBooleans() {
		// new user with all booleans set to false
		User testUser = new User();

		// create a new interactive page and add the test user
		InteractiveScreen testPage = new InteractiveScreen();
		testPage.receiveUser(testUser);

		// call checkBooleans and check that the appropriate booleans in the
		// users footprint were updated
		testPage.checkBooleans();

		boolean usesDishWasher = testPage.passOnUser().getFootPrint()
				.getUsesDishWasher();
		boolean handWashesClothes = testPage.passOnUser().getFootPrint()
				.getHandWashesClothes();
		boolean takesBaths = testPage.passOnUser().getFootPrint()
				.getTakesBaths();
		boolean handWaters = testPage.passOnUser().getFootPrint()
				.getHandWaters();
		boolean usesRecyclableWaterBottle = testPage.passOnUser()
				.getFootPrint().getUsesRecyclableWaterBottle();

		assertTrue(usesDishWasher);
		assertTrue(handWashesClothes);
		assertTrue(takesBaths);
		assertTrue(handWaters);
		assertTrue(usesRecyclableWaterBottle);
	}

	
	/**
	 * testReceiveAndPassOnUser()
	 * 
	 * Tests the methods that test and recieve the user.
	 * 
	 */
	@Test
	public void testReceiveAndPassOnUser() {

		// create a new user and get its associated footprint
		User testUser = new User();
		FootPrint testFootPrint = testUser.getFootPrint();

		// set the footprint's numberOfLoadsOfClothes equal to 19
		testFootPrint.setNumberOfLoadsOfClothes(19);

		// create a new interactive page and add the user
		InteractiveScreen testPage = new InteractiveScreen();
		testPage.receiveUser(testUser);

		// retrieve the user from the interactive page and check that
		// numberOfLoadsOfClothes still equals 99
		User resultUser = testPage.passOnUser();
		int resultNumberOfLoadsOfClothes = resultUser.getFootPrint()
				.getNumberOfLoadsOfClothes();

		assertTrue(resultNumberOfLoadsOfClothes == 19);
	}

	
	/**
	 * testUpdateConsumptionStatus()
	 * 
	 * Tests the method that updates the consumption 
	 * status.
	 * 
	 */
	@Test
	public void testUpdateConsumptionStatus() {

		// create a new interactive page
		InteractiveScreen testPage = new InteractiveScreen();

		// test the updateConsumptionStatus() on a value less than 1500
		testPage.setTextWater("100");
		testPage.updateConsumptionStatus();
		String goodConsumptionStatus = testPage.getConsumptionStatus()
				.getText();

		assertTrue(goodConsumptionStatus
				.equals("<html><p>You are consuming a healthy amount of water</p></html>"));

		// test the updateConsumptionStatus() on a value greather than 1500
		testPage.setTextWater("2000");
		testPage.updateConsumptionStatus();
		String badConsumptionStatus = testPage.getConsumptionStatus().getText();

		assertTrue(badConsumptionStatus
				.equals("You are consuming too much water"));
	}

	
	/**
	 * testUpdateSliders()
	 * 
	 * Tests the method that updates the sliders.
	 * 
	 */
	@Test
	public void testUpdateSliders() {

		// create a new user and get its associated footprint
		User testUser = new User();
		FootPrint testFootPrint = testUser.getFootPrint();

		// update all the values in the footprint
		testFootPrint.setNumberOfWaterBottles(1);
		testFootPrint.setNumberOfLoadsOfClothes(2);
		testFootPrint.setNumberOfTimesDoesDishes(3);
		testFootPrint.setNumberOfWashes(4);
		testFootPrint.setNumberOfTimesWaterPlants(5);
		testFootPrint.setServingOfBeef(6);
		testFootPrint.setServingOfChicken(7);
		testFootPrint.setServingOfLamb(8);
		testFootPrint.setServingOfEggs(9);
		testFootPrint.setServingOfLentils(10);
		testFootPrint.setServingOfPasta(11);
		testFootPrint.setServingOfCorn(12);
		testFootPrint.setServingOfVeggies(13);

		// create a new interactive page and add the above user
		InteractiveScreen testPage = new InteractiveScreen();
		testPage.receiveUser(testUser);

		// call updateSliders() and check that each slider and textTotal was
		// updated correctly
		testPage.updateSliders();
		for (int i = 0; i < 13; i++) {
			int currentSliderValue = testPage.getSlider(i).getValue();
			String currentTextTotalValue = testPage.getTextTotal(i).getText();

			assertTrue(currentSliderValue == i + 1);
			assertTrue(currentTextTotalValue.equals(Integer.toString(i + 1)));
		}
	}

	
	/**
	 *  testUpdateColor()
	 * 
	 * Tests the method that updates the colors
	 * of the sliders.
	 * 
	 */
	@Test
	public void testUpdateColor() {
		// create a new user and get its associated footprint
		User testUser = new User();
		FootPrint testFootPrint = testUser.getFootPrint();

		// update one of the values in the foot print
		testFootPrint.setNumberOfWaterBottles(10);

		// create a new interactive page and add the above user
		InteractiveScreen testPage = new InteractiveScreen();
		testPage.receiveUser(testUser);

		// update the color of the jslider that corresponds to the updated
		// footprint value
		testPage.updateColor(testPage.getSlider(0));

		// check that the new color is as expected
		Color resultColor = testPage.getSlider(0).getBackground();
		Color expectedColor = testPage.getColor(4);

		assertTrue(resultColor == expectedColor);

	}
}
