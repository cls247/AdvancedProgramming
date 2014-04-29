package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Water.FootPrint;


/**
 * FootPrintTest
 * 
 * JUnit tests for the Footprint Class
 * 
 */
public class FootPrintTest {

	FootPrint testFootPrint = new FootPrint();

	/**
	 * testFootPrint()
	 * 
	 * test the FootPrint constructor to make sure that all the data members are
	 * set to default values of 0
	 */
	@Test
	public void testFootPrint() {
		// assert that the data members are all 0
		assertEquals(testFootPrint.getWaterBottle().getWaterLevel(), 0, 0);
		assertEquals(testFootPrint.getWaterBottle().getCurrentBottle(), 0, 0);
		assertEquals(testFootPrint.getWaterBottle().getCurrentOverflow(), 0);

	}

	/**
	 * testSetUsesRecyclableWaterBottle()
	 * 
	 * test that the setUsesRecyclableWaterBottle function accurately sets the
	 * appropriate booleans to true and false, and updates the total waterLevel
	 * accurately
	 */
	@Test
	public void testSetUsesRecyclableWaterBottle() {
		// set the expected booleans and total waterLevel
		boolean expectedUsesPlasticBottle = false;
		boolean expectedUsesRecyclableBottle = true;
		double expectedTotal = 2172.6;

		// set each of the footPrint's data members that affect the total
		// waterLevel, and then update the total
		testFootPrint.setUsesRecyclableWaterBottle();
		testFootPrint.setNumberOfWaterBottles(1);
		testFootPrint.setUsesSprinklers();
		testFootPrint.setNumberOfTimesWaterPlants(1);
		testFootPrint.setUsesDishWasher();
		testFootPrint.setNumberOfTimesDoesDishes(1);
		testFootPrint.setUsesWashingMachine();
		testFootPrint.setNumberOfLoadsOfClothes(1);
		testFootPrint.setTakesShowers();
		testFootPrint.setNumberOfWashes(1);
		testFootPrint.setServingOfBeef(1);

		// update the total
		testFootPrint.updateTotalAmountOfWater();

		// assert that the expected booleans and total are equal
		assertEquals(expectedUsesPlasticBottle,
				testFootPrint.getUsesPlasticWaterBottle());
		assertEquals(expectedUsesRecyclableBottle,
				testFootPrint.getUsesRecyclableWaterBottle());
		assertEquals(expectedTotal, testFootPrint.getTotalAmountOfWater(), 0);
	}

	/**
	 * testUpdateTotalAmountOfWater()
	 * 
	 * test that the updateTotalAmountOfWater accurately updates the total
	 * amount of water based on the values of the different data members of the
	 * footPrint
	 */
	@Test
	public void testUpdateTotalAmountOfWater() {
		// set usesPlasticWaterBottle to true
		testFootPrint.setUsesPlasticWaterBottle();

		// set the expected booleans and total
		boolean expectedUsesPlasticBottle = true;
		boolean expectedUsesRecyclableBottle = false;
		double expectedTotal = 2173.8;

		// set each of the footPrint's data members that affect the total
		// waterLevel, and then update the total
		testFootPrint.setUsesPlasticWaterBottle();
		testFootPrint.setNumberOfWaterBottles(1);
		testFootPrint.setUsesSprinklers();
		testFootPrint.setNumberOfTimesWaterPlants(1);
		testFootPrint.setUsesDishWasher();
		testFootPrint.setNumberOfTimesDoesDishes(1);
		testFootPrint.setUsesWashingMachine();
		testFootPrint.setNumberOfLoadsOfClothes(1);
		testFootPrint.setTakesShowers();
		testFootPrint.setNumberOfWashes(1);
		testFootPrint.setServingOfBeef(1);

		// update the total
		testFootPrint.updateTotalAmountOfWater();

		// assert that the expected booleans and total are equal
		assertEquals(testFootPrint.getUsesPlasticWaterBottle(),
				expectedUsesPlasticBottle);
		assertEquals(testFootPrint.getUsesRecyclableWaterBottle(),
				expectedUsesRecyclableBottle);
		assertEquals(testFootPrint.getBottle().getWaterLevel(), expectedTotal,
				0);

	}

	/**
	 * testSetNumberOfWaterBottles()
	 * 
	 * test that the setNumberOfWaterBottle function accurately sets the
	 * appropriate booleans to true and false, and updates the total waterLevel
	 * accurately
	 */
	@Test
	public void testSetNumberOfWaterBottles() {
		// sets the actual usesPlasticWaterBottles to true
		testFootPrint.setUsesPlasticWaterBottle();

		// set the expected booleans and total
		boolean expectedUsesPlasticBottle = true;
		boolean expectedUsesRecyclableBottle = false;
		double expectedTotal = 2173.8;

		// set each of the footPrint's data members that affect the total
		// waterLevel, and then update the total
		testFootPrint.setUsesPlasticWaterBottle();
		testFootPrint.setNumberOfWaterBottles(1);
		testFootPrint.setUsesSprinklers();
		testFootPrint.setNumberOfTimesWaterPlants(1);
		testFootPrint.setUsesDishWasher();
		testFootPrint.setNumberOfTimesDoesDishes(1);
		testFootPrint.setUsesWashingMachine();
		testFootPrint.setNumberOfLoadsOfClothes(1);
		testFootPrint.setTakesShowers();
		testFootPrint.setNumberOfWashes(1);
		testFootPrint.setServingOfBeef(1);

		// update the total
		testFootPrint.updateTotalAmountOfWater();

		// assert that the expected booleans and total are equal
		assertEquals(testFootPrint.getUsesPlasticWaterBottle(),
				expectedUsesPlasticBottle);
		assertEquals(testFootPrint.getUsesRecyclableWaterBottle(),
				expectedUsesRecyclableBottle);
		assertEquals(testFootPrint.getBottle().getWaterLevel(), expectedTotal,
				0);

	}

	/**
	 * testCalculateWaterForFood()
	 * 
	 * Tests the calculateWaterForFood function by setting the different food
	 * servings and tests that the total amount of water used for the good is
	 * calculated correctly
	 */
	@Test
	public void testCalculateWaterForFood() {
		// set the expected total result
		double expectedTotal = 4985.0;

		// set the different serving sizes, and update the total
		testFootPrint.setServingOfBeef(1);
		testFootPrint.setServingOfChicken(1);
		testFootPrint.setServingOfLamb(2);
		testFootPrint.setServingOfEggs(3);
		testFootPrint.setServingOfCorn(1);
		testFootPrint.setServingOfLentils(2);
		testFootPrint.setServingOfPasta(1);
		testFootPrint.setServingOfVeggies(2);

		// update the total
		testFootPrint.updateTotalAmountOfWater();

		// assert that the actual total is equal to the expected total
		assertEquals(testFootPrint.getTotalAmountOfWater(), expectedTotal, 0);

	}

	/**
	 * testTips()
	 * 
	 * test the Tips() function by setting the different data members and
	 * checking that the tip string generated by the Tips function is accurate
	 */
	@Test
	public void testTips() {
		// set the expected tips string
		String expectedTips = "You should be sure that you are using water efficient appliances.\n"
				+ "Washing dark colored clothes in cold water helps to save water \n"
				+ "Water dry spots on your lawn by hand instead of using a sprinkler system. \n"
				+ "Only water your lawn when it is absolutely necessary. \n"
				+ "Collect rain water and use it to water lawns and garden\n"
				+ "Don't water your lawn on windy days\n"
				+ "Lawns can go a lot longer without water than you thing.\n"
				+ "Use water calculators like this one to track your water each month!\n";

		// set the different data members
		testFootPrint.setUsesRecyclableWaterBottle();
		testFootPrint.setNumberOfWaterBottles(1);
		testFootPrint.setUsesSprinklers();
		testFootPrint.setNumberOfTimesWaterPlants(1);
		testFootPrint.setUsesDishWasher();
		testFootPrint.setNumberOfTimesDoesDishes(1);
		testFootPrint.setUsesWashingMachine();
		testFootPrint.setNumberOfLoadsOfClothes(1);
		testFootPrint.setTakesShowers();
		testFootPrint.setNumberOfWashes(1);
		testFootPrint.setServingOfBeef(1);

		// update the total
		testFootPrint.updateTotalAmountOfWater();

		// call the Tips() method
		String testTips = testFootPrint.Tips();

		// assert that the actual and expected are the same
		assertEquals(testTips, expectedTips);
	}

}