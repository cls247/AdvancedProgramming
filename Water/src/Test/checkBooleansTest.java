package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Water.FootPrint;
import Water.InteractivePage;
import Water.User;

public class checkBooleansTest {

	@Test
	public void test() {		
		//new user with all booleans set to false
		User testUser = new User();
		
		//create a new interactive page and add the test user
		InteractivePage testPage = new InteractivePage();
		testPage.receiveUser(testUser);
		
		//call checkBooleans and check that the appropriate booleans in the users footprint were updated
		testPage.checkBooleans();
		
		boolean usesDishWasher = testPage.passOnUser().getFootPrint().getUsesDishWasher();
		boolean handWashesClothes = testPage.passOnUser().getFootPrint().getHandWashesClothes();
		boolean takesBaths = testPage.passOnUser().getFootPrint().getTakesBaths();
		boolean handWaters = testPage.passOnUser().getFootPrint().getHandWaters();
		boolean usesRecyclableWaterBottle = testPage.passOnUser().getFootPrint().getUsesRecyclableWaterBottle();
		
		assertTrue(usesDishWasher);		
		assertTrue(handWashesClothes);
		assertTrue(takesBaths);
		assertTrue(handWaters);
		assertTrue(usesRecyclableWaterBottle);
	}

}
