package Water;

/**
 * This is an example of a footprint. It has lots of private data variables that
 * hold all the information that is entered by the user. It just have getters
 * and setters for all of the data. In addition, it has a method that can be
 * called that will update the total. This method can be called every time that
 * something is updated.
 * 
 * @author Sand
 * 
 */
public class FootPrint {

	// booleans for type of water bottle used
	private boolean usesRecyclableWaterBottle = false;
	private boolean usesPlasticWaterBottle = false;

	// constants for the liters per each type of bottle
	private final double literPerPlaticWaterBottle = 1.8;
	private final double literPerRecycableWaterBottle = .6;
	private int numberOfWaterBottles = 0;

	// booleans for the type of lawn-watering the user does
	private boolean usesSprinklers = false;
	private boolean handWaters = false;

	// constant for the liters of water used per each type
	private final int literPerSprinklerPerTime = 90;
	private final int literPerHandWaterTime = 50;
	private int numberOfTimesWaterPlants = 0;

	// booleans for the type of dish washing the user does
	private boolean usesDishWasher = false;
	private boolean doesDishedByHand = false;

	// constants for the liters per water used by each kind
	private final int literPerDishWater = 3;
	private final int literPerDishesByHand = 10;
	private int numberOfTimesDoesDishes = 0;

	// constants for the liters of water used for each type of food
	private final int literPerServingOfBeef = 2024;
	private final int literPerServingOfChicken = 350;
	private final int literPerServingOfLamb = 914;
	private final int literPerServingOfVeggies = 20;
	private final int literPerServingOfLentils = 59;
	private final int literPerServingOfPasta = 150;
	private final int literPerServingOfCorn = 70;
	private final int literPerServingOfEggs = 135;

	// number of servings of each type of food
	private int servingOfBeef = 0;
	private int servingOfChicken = 0;
	private int servingOfLamb = 0;
	private int servingOfVeges = 0;
	private int servingOfLentils = 0;
	private int servingOfPasta = 0;
	private int servingOfCorn = 0;
	private int servingOfEggs = 0;

	// booleans for different types of bathing options
	private boolean takesShowers = false;
	private boolean takesBaths = false;

	// constants for amount of water used
	private final double literPerShowerPerMinute = 35;
	private final double litersPerBath = 50;
	private int numberOfWashes = 0;

	// booleans for clothing washing
	private boolean usesWashingMachine = false;
	private boolean handWashesClothes = false;
	private int numberOfLoadsOfClothes = 0;

	// constants for the amount of water each type uses
	private final int litersPerLoadsOfClothersWashingMachine = 20;
	private final int litersPerLoadsOfClothesHandWashing = 37;
	private double totalLitersAmountOfWater = 0;

	// waterBottle to be drawn on the screen
	private Bottle waterBottle;

	// string arrays for storing tips
	String[] usesPlasticWaterBottleTips = {
			"You should try using Recycleable Water Bottles.",
			"It takes 3 times as much water to make a disposable plastic bottle as it does to fill it" };

	String[] doesDishesByHandArray = {
			"You should consider using a dishwasher to wash you dishes.",
			"An energy efficient dishwasher will actually use less water.",
			"Make sure that your sinks do not have leaks.",
			"Scrap excess food off of your dishes instead of rinsing them before putting them in dish washer.",
			"If washing dishes by hand, don't let the water run. Fill a basin with water instead." };

	String[] takesBathsArray = {
			"You should take showers instead of baths. They use less water.",
			"Or at least try to make your showers quick",
			"Don't fill bathtubs to the tops with water to reduce splashing" };

	String[] meatArray = {
			"You should try decreasing the amount of Meat you eat.",
			"Vegetables use less water to produce. It is better for the environment and for you." };

	String[] takesShowersArray = { "You should shower less times per week. It will conserver water" };

	String[] usesAppliancesArray = {
			"You should be sure that you are using water efficient appliances",
			"Washing dark colored clothes in cold water helps to save water" };

	String[] usesSprinklersArray = {
			"Water dry spots on your lawn by hand instead of using a sprinkler system",
			"Only water your lawn when it is absolutely necessary",
			"Collect rain water and use it to water lawns and garden",
			"Don't water your lawn on windy days",
			"Lawns can go a lot longer without water than you thing" };

	/**
	 * FootPrint()
	 * 
	 * constructor for the FootPrint class
	 */
	public FootPrint() {
		waterBottle = new Bottle();
	}

	// There are alot of getters and setters in order to edit the FootPrint
	// appropriately:

	/**
	 * setUsesRecyclableWaterBottle()
	 * 
	 * This method sets the usesRecyclableWaterBottle to true and
	 * usesPlasticWaterBottle to false
	 */
	public void setUsesRecyclableWaterBottle() {
		// if the user uses recyclable water bottles, usesRecyclable should be
		// true
		// and usesPlastic should be false
		usesRecyclableWaterBottle = true;
		usesPlasticWaterBottle = false;
		updateTotalAmountOfWater();

	}

	/**
	 * setUsesPlasticWaterBottle()
	 * 
	 * This method sets the usesPlasticWaterBottle to true and
	 * usesRecycableWaterBottle to false
	 */
	public void setUsesPlasticWaterBottle() {
		// if the user uses plastic water bottles, usesRecyclable should be
		// false
		// and usesPlastic should be true

		usesPlasticWaterBottle = true;
		usesRecyclableWaterBottle = false;
		updateTotalAmountOfWater();
	}

	/**
	 * setNumberOfWaterBottles(int numberOfWaterBottles1)
	 * 
	 * This method sets the numberOfWaterBottles to the number passed into the
	 * method
	 */
	public void setNumberOfWaterBottles(int numberOfWaterBottles1) {
		numberOfWaterBottles = numberOfWaterBottles1;
		updateTotalAmountOfWater();
	}

	/**
	 * getNumberOfWaterBottles()
	 * 
	 * @return numberOfWaterBottles
	 */
	public int getNumberOfWaterBottles() {
		return numberOfWaterBottles;
	}

	/**
	 * setUsesDishWasher()
	 * 
	 * This method sets usesDishWasher to true and doesDishesByHand to false
	 */
	public void setUsesDishWasher() {
		// if the user uses a dishwasher, that boolean should be true and
		// doesByHand should be false
		usesDishWasher = true;
		doesDishedByHand = false;
		updateTotalAmountOfWater();
	}

	/**
	 * setDoesDishedByHand()
	 * 
	 * This method sets usesDishWasher to false and doesDishedByHand to true.
	 */

	public void setDoesDishedByHand() {
		// if they user does dishes by hand, usesDishWasher should be false;
		// and doesDishedByHand should be true
		usesDishWasher = false;
		doesDishedByHand = true;
		updateTotalAmountOfWater();
	}

	/**
	 * setNumberOfTimesDoesDishes(int setNumberOfTimesDoesDishes)
	 * 
	 * This method sets the numberOfTimesDoesDishes to the number passed in.
	 * 
	 * @param setNumberOfTimesDoesDishes
	 */
	public void setNumberOfTimesDoesDishes(int setNumberOfTimesDoesDishes) {
		numberOfTimesDoesDishes = setNumberOfTimesDoesDishes;
		updateTotalAmountOfWater();
	}

	/**
	 * getNumberOfTimesDoesDishes()
	 * 
	 * @return numberOfTimesDoesDishes
	 */
	public int getNumberOfTimesDoesDishes() {
		return numberOfTimesDoesDishes;
	}

	/**
	 * setServingOfBeef(int setServingOfBeef)
	 * 
	 * This method sets the servingOfBeef to the number that is passed in.
	 * 
	 * @param setServingOfBeef
	 */
	public void setServingOfBeef(int setServingOfBeef) {
		servingOfBeef = setServingOfBeef;
		updateTotalAmountOfWater();
	}

	/**
	 * getServingOfBeef()
	 * 
	 * @return servingOfBeef
	 */
	public int getServingOfBeef() {
		return servingOfBeef;
	}

	/**
	 * setServingOfChicken(int setServingOfChicken )
	 * 
	 * This method sets the servingOfChicken to the number passed in and updates
	 * the total.
	 * 
	 * @param setServingOfChicken
	 */
	public void setServingOfChicken(int setServingOfChicken) {
		servingOfChicken = setServingOfChicken;
		updateTotalAmountOfWater();
	}

	/**
	 * getServingOfChicken
	 * 
	 * @return servingOfChicken
	 */
	public int getServingOfChicken() {
		return servingOfChicken;
	}

	/**
	 * setServingOfLamb(int setServingOfLamb)
	 * 
	 * This method sets the servingOfLamb to the number passed in and updates
	 * the total.
	 * 
	 * @param setServingOfLamb
	 */
	public void setServingOfLamb(int setServingOfLamb) {
		servingOfLamb = setServingOfLamb;
		updateTotalAmountOfWater();
	}

	/**
	 * getServingOfLamb()
	 * 
	 * @return servingOfLamb
	 */
	public int getServingOfLamb() {
		return servingOfLamb;
	}

	/**
	 * setServingOfEggs(int setServingOfEggs)
	 * 
	 * This method sets the servingOfEggs to the number passed in and updates
	 * the total.
	 * 
	 * @param servingOfEggs
	 */
	public void setServingOfEggs(int setServingOfEggs) {
		servingOfEggs = setServingOfEggs;
		updateTotalAmountOfWater();
	}

	/**
	 * getServingOfEggs()
	 * 
	 * @return servingOfEggs
	 */
	public int getServingOfEggs() {
		return servingOfEggs;
	}

	/**
	 * setServingOfVeggies(int setServingOfVeggies)
	 * 
	 * This method sets the servingOfVeges to the number passed in and updates
	 * the total.
	 * 
	 * @param setServingOfVeggies
	 */
	public void setServingOfVeggies(int setServingOfVeggies) {
		servingOfVeges = setServingOfVeggies;
		updateTotalAmountOfWater();
	}

	/**
	 * getServingsOfVeggies()
	 * 
	 * @return servingOfVeges
	 */
	public int getServingsOfVeggies() {
		return servingOfVeges;
	}

	/**
	 * setServingOfLentils(int setServingOfLentils)
	 * 
	 * This method sets the servingOfLentils to the number passed in and updates
	 * the total.
	 * 
	 * 
	 * @param setServingOfLentils
	 */
	public void setServingOfLentils(int setServingOfLentils) {
		servingOfLentils = setServingOfLentils;
		updateTotalAmountOfWater();
	}

	/**
	 * getServingOfLentils
	 * 
	 * @return servingOfLentils
	 */
	public int getServingOfLentils() {
		return servingOfLentils;
	}

	/**
	 * setServingOfPasta(int setServingOfPasta)
	 * 
	 * This method sets the servingOfPasta to the number passed in and updates
	 * the total.
	 * 
	 * 
	 * @param servingOfPasta
	 */
	public void setServingOfPasta(int setServingOfPasta) {
		servingOfPasta = setServingOfPasta;
		updateTotalAmountOfWater();
	}

	/**
	 * getServingOfPasta()
	 * 
	 * @return servingOfPasta
	 */
	public int getServingOfPasta() {
		return servingOfPasta;
	}

	/**
	 * setServingOfCorn(int setServingOfCorn)
	 * 
	 * This method sets the servingOfCorn to the number passed in and updates
	 * the total.
	 * 
	 * 
	 * @param setServingOfCorn
	 */
	public void setServingOfCorn(int setServingOfCorn) {
		servingOfCorn = setServingOfCorn;
		updateTotalAmountOfWater();
	}

	/**
	 * getServingOfCorn()
	 * 
	 * @return servingOfCorn;
	 */
	public int getServingOfCorn() {
		return servingOfCorn;
	}

	/**
	 * setTakesShowers()
	 * 
	 * This method sets takesShowers to true and takesBaths to false;
	 * 
	 * 
	 * @param setServingOfCorn
	 */
	public void setTakesShowers() {
		// if the user takes showers and not baths,
		// takesShowers is true and takesBaths is false;
		takesShowers = true;
		takesBaths = false;
		updateTotalAmountOfWater();
	}

	/**
	 * setTakesBaths()
	 * 
	 * This method sets takesShowers to false and takesBaths to true;
	 * 
	 * 
	 * @param setServingOfCorn
	 */
	public void setTakesBaths() {
		// if the user takes baths and not showers,
		// takesShowers is false and takesBaths is true;
		takesShowers = false;
		takesBaths = true;
		updateTotalAmountOfWater();
	}

	/**
	 * setNumberOfWashes(int setNumberOfWashes)
	 * 
	 * This method sets numberOfWashes to the number passed in and updates the
	 * total.
	 * 
	 * @param setNumberOfWashes
	 */
	public void setNumberOfWashes(int setNumberOfWashes) {
		numberOfWashes = setNumberOfWashes;
		updateTotalAmountOfWater();
	}

	/**
	 * getNumberOfWashes()
	 * 
	 * @return numberOfWashes
	 */
	public int getNumberOfWashes() {
		return numberOfWashes;
	}

	/**
	 * setUsesWashingMachine()
	 * 
	 * This method sets usesWashingMachine to true and handWashesClothes to
	 * false.
	 * 
	 * @param setNumberOfWashes
	 */
	public void setUsesWashingMachine() {
		// if the user uses a washing machine, set usesWashingMachine to true
		// and
		// handWashesClothes to false.
		usesWashingMachine = true;
		handWashesClothes = false;
		updateTotalAmountOfWater();
	}

	/**
	 * setHandWashesClothes()
	 * 
	 * This method sets usesWashingMachine to false and handWashesClothes to
	 * true.
	 * 
	 * @param setNumberOfWashes
	 */
	public void setHandWashesClothes() {
		// if the user hand washes, set usesWashingMachine to false
		// and handWashesClothes to true
		usesWashingMachine = false;
		handWashesClothes = true;
		updateTotalAmountOfWater();
	}

	/**
	 * setNumberOfLoadsOfClothes(int setNumberOfLoadsOfClothes)
	 * 
	 * This method numberOfLoadsOfClothes to the number passed in
	 * 
	 * @param setNumberOfLoadsOfClothes
	 */
	public void setNumberOfLoadsOfClothes(int setNumberOfLoadsOfClothes) {
		numberOfLoadsOfClothes = setNumberOfLoadsOfClothes;
		updateTotalAmountOfWater();
	}

	/**
	 * getNumberOfLoadsOfClothes()
	 * 
	 * @return the numberOfLoadsOfClothes
	 */
	public int getNumberOfLoadsOfClothes() {
		return numberOfLoadsOfClothes;
	}

	/**
	 * setUsesSprinklers()
	 * 
	 * This method sets usesSprinklers to true and handWaters to false;
	 */
	public void setUsesSprinklers() {
		usesSprinklers = true;
		handWaters = false;
		updateTotalAmountOfWater();
	}

	/**
	 * setHandWaters()
	 * 
	 * This method sets usesSprinklers to false and handWaters to true;
	 */
	public void setHandWaters() {
		usesSprinklers = false;
		handWaters = true;
		updateTotalAmountOfWater();
	}

	/**
	 * setNumberOfTimesWaterPlants(int setNumberOfTimesWaterPlants)
	 * 
	 * This method sets the number passed in numberOfTimesWaterPlants.
	 * 
	 * @param setNumberOfTimesWaterPlants
	 */
	public void setNumberOfTimesWaterPlants(int setNumberOfTimesWaterPlants) {
		numberOfTimesWaterPlants = setNumberOfTimesWaterPlants;
		updateTotalAmountOfWater();
	}

	/**
	 * getNumberOfTimesWaterPlants()
	 * 
	 * 
	 * @return the numberOfTimesWaterPlants
	 */
	public int getNumberOfTimesWaterPlants() {
		return numberOfTimesWaterPlants;
	}

	/**
	 * updateTotalAmountOfWater()
	 * 
	 * This method updates the total amount of water in the food print based on
	 * the private data variables and a calculation. This method is called
	 * everytime that anything is changed in the Footprint in order to ensure
	 * that the total is always up to date.
	 */
	public void updateTotalAmountOfWater() {

		// start with the total at 0 so it is recalculated every time
		totalLitersAmountOfWater = 0;

		// this is a long equation that, based on the options the user selected
		// and what has been set by ther setters, will calculate the total
		// amount of
		// water used, in liters
		if (usesRecyclableWaterBottle) {

			totalLitersAmountOfWater += (literPerRecycableWaterBottle * numberOfWaterBottles);

		}
		if (usesPlasticWaterBottle) {
			totalLitersAmountOfWater += (literPerPlaticWaterBottle * numberOfWaterBottles);
		}

		if (usesDishWasher) {
			totalLitersAmountOfWater += literPerDishWater
					* numberOfTimesDoesDishes;
		}

		if (doesDishedByHand) {
			totalLitersAmountOfWater += literPerDishesByHand
					* numberOfTimesDoesDishes;
		}

		// call the method that will calculate the water used by just the food
		calculateWaterForFood();

		if (takesShowers) {
			totalLitersAmountOfWater += literPerShowerPerMinute
					* numberOfWashes;
		}

		if (takesBaths) {
			totalLitersAmountOfWater += litersPerBath * numberOfWashes;
		}

		if (usesWashingMachine) {
			totalLitersAmountOfWater += litersPerLoadsOfClothersWashingMachine
					* numberOfLoadsOfClothes;
		}

		if (handWashesClothes) {
			totalLitersAmountOfWater += litersPerLoadsOfClothesHandWashing
					* numberOfLoadsOfClothes;
		}

		if (usesSprinklers) {
			totalLitersAmountOfWater += literPerSprinklerPerTime
					* numberOfTimesWaterPlants;
		}

		if (handWaters) {
			totalLitersAmountOfWater += literPerHandWaterTime
					* numberOfTimesWaterPlants;
		}

		// set the waterbottle by passing in the totalLiters of water
		// that was just calculated
		waterBottle.setWaterBottle(totalLitersAmountOfWater);
	}

	/**
	 * calculateWaterForFood()
	 * 
	 * This method increases the total amount of water used by the amount used
	 * for water.
	 */
	private void calculateWaterForFood() {
		// equation to calculate the total liters of water that just the
		// different servings of food use
		totalLitersAmountOfWater += servingOfBeef * literPerServingOfBeef;
		totalLitersAmountOfWater += servingOfChicken * literPerServingOfChicken;
		totalLitersAmountOfWater += servingOfLamb * literPerServingOfLamb;
		totalLitersAmountOfWater += servingOfVeges * literPerServingOfVeggies;
		totalLitersAmountOfWater += servingOfLentils * literPerServingOfLentils;
		totalLitersAmountOfWater += servingOfPasta * literPerServingOfPasta;
		totalLitersAmountOfWater += servingOfEggs * literPerServingOfEggs;
		totalLitersAmountOfWater += servingOfCorn * literPerServingOfCorn;
	}

	/**
	 * getWaterBottle()
	 * 
	 * @return the water bottle
	 */
	public Bottle getWaterBottle() {
		return waterBottle;
	}

	/**
	 * getTotalAmountOfWater()
	 * 
	 * @return the total amount of water used in the water bottle
	 */
	public double getTotalAmountOfWater() {
		return totalLitersAmountOfWater;
	}

	/**
	 * getBottle()
	 * 
	 * @return the water bottle
	 */
	public Bottle getBottle() {

		return waterBottle;

	}

	/**
	 * setUsesRecyclableWaterBottleUnclicked()
	 * 
	 * This method sets usesRecyclableWaterBottle to false.
	 */
	public void setUsesRecyclableWaterBottleUnclicked() {
		usesRecyclableWaterBottle = false;
	}

	/**
	 * setUsesPlasticWaterBottleUnclicked()
	 * 
	 * This method sets usesPlasticWaterBottle to false.
	 */
	public void setUsesPlasticWaterBottleUnclicked() {
		usesPlasticWaterBottle = false;
	}

	/**
	 * setUsesDishWasherUnclicked()
	 * 
	 * This method sets usesDishWasher to false.
	 */
	public void setUsesDishWasherUnclicked() {
		usesDishWasher = false;
	}

	/**
	 * setDoesDishesByHandUnclicked()
	 * 
	 * This method sets doesDishedByHand to false.
	 */
	public void setDoesDishesByHandUnclicked() {
		doesDishedByHand = false;
	}

	/**
	 * setShowersUnclicked()
	 * 
	 * This method sets takesShowers to false.
	 */
	public void setShowersUnclicked() {
		takesShowers = false;
	}

	/**
	 * setBathsUnclicked()
	 * 
	 * This method sets takesBaths to false.
	 */
	public void setBathsUnclicked() {
		takesBaths = false;
	}

	/**
	 * setUsesWashingMachineUnclicked()
	 * 
	 * This method sets usesWashingMachine to false.
	 */
	public void setUsesWashingMachineUnclicked() {
		usesWashingMachine = false;
	}

	/**
	 * setHandWashesClothesUnclicked()
	 * 
	 * This method sets handWashesClothes to false.
	 */
	public void setHandWashesClothesUnclicked() {
		handWashesClothes = false;
	}

	/**
	 * setUsesSprinklersUnclicked()
	 * 
	 * This method sets usesSprinklers to false.
	 */
	public void setUsesSprinklersUnclicked() {
		usesSprinklers = false;
	}

	/**
	 * setHandWatersUnclicked()
	 * 
	 * This method sets handWaters to false.
	 */
	public void setHandWatersUnclicked() {
		handWaters = false;
	}

	/**
	 * Tips()
	 * 
	 * This method will be called on the last screen where the user gets their
	 * total amount of water and then prints a bunch of tips that are specific
	 * to their water footprint.
	 * 
	 * @return a string a tips that are specifically based on the footprint and
	 *         what the user has entered.
	 * 
	 */
	public String Tips() {
		String tipsToReturn = "";
		tipsToReturn = setTips(tipsToReturn);
		return tipsToReturn;
	}

	/**
	 * setTips(String tipsToReturn)
	 * 
	 * This method returns the tips that are specific to the information entered
	 * in the footprint.
	 * 
	 * @param tipsToReturn
	 * @return
	 */

	private String getTips(String[] tipsArray) {

		// create a new string
		String newTips = "";

		// go through the corresponding array of tips
		for (int i = 0; i < tipsArray.length; i++) {
			// add a bullet point
			newTips += "\u2022";
			// add the tip
			newTips += tipsArray[i];
			// add a line break
			newTips += "\n";
			;
		}

		// add another line break
		newTips += "\n";

		return newTips;
	}

	private String setTips(String tipsToReturn) {

		// add the necessary tips depending on what the user selected
		if (usesPlasticWaterBottle)
			tipsToReturn += getTips(usesPlasticWaterBottleTips);
		if (doesDishedByHand)
			tipsToReturn += getTips(doesDishesByHandArray);
		if (takesBaths)
			tipsToReturn += getTips(takesBathsArray);
		if (servingOfLamb + servingOfChicken + servingOfBeef >= 5)
			tipsToReturn += getTips(meatArray);
		if (numberOfWashes > 7 && takesShowers)
			tipsToReturn += getTips(takesShowersArray);
		if (usesWashingMachine || usesDishWasher)
			tipsToReturn += getTips(usesAppliancesArray);
		if (usesSprinklers) {
			tipsToReturn += getTips(usesSprinklersArray);
		}
		tipsToReturn += "Use water calculators like this one to track your water each month!\n";
		return tipsToReturn;
	}

	/**
	 * getDoesDishesByHand()
	 * 
	 * @return doesDishedByHand
	 */
	public boolean getDoesDishesByHand() {
		return doesDishedByHand;
	}

	/**
	 * getHandWashesClothes()
	 * 
	 * @return handWashesClothes
	 */
	public boolean getHandWashesClothes() {
		return handWashesClothes;
	}

	/**
	 * getHandWaters()
	 * 
	 * @return handWaters
	 */
	public boolean getHandWaters() {
		return handWaters;
	}

	/**
	 * getUsesDishWasher()
	 * 
	 * @return usesDishWasher
	 */
	public boolean getUsesDishWasher() {
		return usesDishWasher;
	}

	/**
	 * getUsesPlasticWaterBottle()
	 * 
	 * @return usesPlasticWaterBottle
	 */
	public boolean getUsesPlasticWaterBottle() {
		return usesPlasticWaterBottle;
	}

	/**
	 * getUsesRecyclableWaterBottle() {
	 * 
	 * @return usesRecyclableWaterBottle
	 */
	public boolean getUsesRecyclableWaterBottle() {
		return usesRecyclableWaterBottle;
	}

	/**
	 * getUsesSprinklers()
	 * 
	 * @return usesSprinklers
	 */
	public boolean getUsesSprinklers() {
		return usesSprinklers;
	}

	/**
	 * getUsesWashingMachine()
	 * 
	 * @return usesWashingMachine
	 */
	public boolean getUsesWashingMachine() {
		return usesWashingMachine;
	}

	/**
	 * getTakesBaths()
	 * 
	 * @return takesBaths
	 */
	public boolean getTakesBaths() {
		return takesBaths;
	}

	/**
	 * getTakesShowers()
	 * 
	 * @return takesShowers
	 */
	public boolean getTakesShowers() {
		return takesShowers;
	}

}
