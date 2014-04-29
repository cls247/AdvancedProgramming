package Test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Water.FootPrint;
import Water.InteractivePage;
import Water.User;

public class updateSlidersTest {

	@Test
	public void test() {

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
		InteractivePage testPage = new InteractivePage();
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

}
