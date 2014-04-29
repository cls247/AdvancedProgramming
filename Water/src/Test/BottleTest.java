package Test;

/**
 * 
 * A class that tests the functions of the water bottle.
 * 
 */

import static org.junit.Assert.assertEquals;

import javax.swing.ImageIcon;

import org.junit.Test;

import Water.Bottle;

public class BottleTest {

	/********** CLASS METHODS ******/

	/**
	 * testBottle()
	 * 
	 * Test the constructor method
	 * 
	 */
	@Test
	public void testBottle() {
		// create a new bottle
		Bottle testBottle = new Bottle();

		// test that the default values are set correctly
		assertEquals(testBottle.getWaterBottleArray().size(), 21, 0);
		assertEquals(testBottle.getOverFlowArray().size(), 22, 0);
	}

	/**
	 * testAddWater()
	 * 
	 * Test the addWater() method
	 * 
	 */
	@Test
	public void testAddWater() {
		// create a new botle
		Bottle testBottle = new Bottle();

		// test that the water is set correctly
		testBottle.addWater();
		for (int i = 0; i < 21; i++) {
			String shouldBe = String.valueOf(i + 1) + ".jpg";
			assertEquals(testBottle.getImageBottle(i), "water" + shouldBe);
		}
	}

	/**
	 * testAddOverFlow()
	 * 
	 * Test the addWater() method
	 * 
	 */
	@Test
	public void testAddOverFlow() {
		// create a new bottle
		Bottle testBottle = new Bottle();

		// test that the overflow is set correctly
		testBottle.addOverflow();
		for (int i = 0; i < 22; i++) {
			String shouldBe = String.valueOf(i + 1) + ".jpg";
			assertEquals(testBottle.getOverFlowImage(i), "overflow" + shouldBe);
		}
	}

	/**
	 * testSetWaterBottle(double total)
	 * 
	 * This method test the setWaterBottle method of the water bottle class.
	 */
	public void testSetWaterBottle(double total) {
		// create a new bottle
		Bottle testBottle = new Bottle();

		// set the waterBottle to 200
		testBottle.setWaterBottle(2000);

		// test that the water level, image, and current bottle are set
		// correctly
		assertEquals(testBottle.getWaterLevel(), 2000, 0);
		assertEquals(testBottle.getCurrentBottle(), 0, 0);
		ImageIcon testImage = new ImageIcon("water1.jpg");
		assertEquals(testBottle.getImage(), testImage);

	}

	/**
	 * testIsNotFull()
	 * 
	 * @return if the currentBottle is less than or equal to 21
	 */
	public void testIsNotFull() {
		// create a new bottle and set the water bottle
		Bottle testBottle = new Bottle();
		testBottle.setWaterBottle(4000);

		// test that the bottle is not full
		assertEquals(true, testBottle.isNotFull());

		// change the water bottle and check that it is now full
		testBottle.setWaterBottle(210000);
		assertEquals(false, testBottle.isNotFull());
	}
}
