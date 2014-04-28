package Water;

/** 
 * This is an example of a footprint. It has lots of private
 * data variables that hold all the information that is entered
 * by the user. It just have getters and setters for all of the data.
 * In addition, it has a method that can be called that will update the 
 * total. This method can be called every time that something is updated.
 * @author Sand
 *
 */
public class FootPrint {

	private boolean usesRecyclableWaterBottle=false;
	private boolean usesPlasticWaterBottle=false;
	private final double literPerPlaticWaterBottle=1.8;
	private final double literPerRecycableWaterBottle=.6;
	private int numberOfWaterBottles=0;

	private boolean usesSprinklers=false;
	private final int literPerSprinklerPerTime=90;
	private boolean handWaters=false;
	private final int literPerHandWaterTime=50;
	private int numberOfTimesWaterPlants;

	private boolean usesDishWasher=false;
	private final int literPerDishWater=3;
	private boolean doesDishedByHand=false;
	private final int literPerDishesByHand=10;
	private int numberOfTimesDoesDishes=0;

	private int servingOfBeef=0;
	private final int literPerServingOfBeef=2024;
	private int servingOfChicken=0;
	private final int literPerServingOfChicken=350;
	private int servingOfLamb=0;
	private final int literPerServingOfLamb=914;
	private int servingOfVeges=0;
	private final int literPerServingOfVeggies=20;
	private int servingOfLentils=0;
	private final int literPerServingOfLentils=59;
	private int servingOfPasta=0;
	private final int literPerServingOfPasta=150;
	private int servingOfCorn=0;
	private final int literPerServingOfCorn=70;
	private int servingOfEggs=0;
	private final int literPerServingOfEggs=135;

	private boolean takesShowers=false;
	private final double literPerShowerPerMinute=35;
	private boolean takesBaths=false;
	private final double litersPerBath=50;
	private int numberOfWashes=0;

	private boolean usesWashingMachine=false;
	private boolean handWashesClothes=false;
	private int numberOfLoadsOfClothes=0;
	private final int litersPerLoadsOfClothersWashingMachine=20;
	private final int litersPerLoadsOfClothesHandWashing=37;

	private double totalLitersAmountOfWater=0;
	private Bottle waterBottle;


	/**
	 * This are alot of getters and setters in order to edit the FootPrint appropriately
	 */
	public FootPrint()
	{
		waterBottle=new Bottle();
	}

	/**
	 * setUsesRecyclableWaterBottle()
	 * 
	 * This method sets the usesRecyclableWaterBottle to true
	 * and usesPlasticWaterBottle to false
	 */
	public void setUsesRecyclableWaterBottle()
	{
		usesRecyclableWaterBottle=true;
		usesPlasticWaterBottle=false;
		updateTotalAmountOfWater();

	}

	/**
	 * setUsesPlasticWaterBottle()
	 * 
	 * This method sets the usesPlasticWaterBottle to true
	 * and usesRecycableWaterBottle to false
	 */
	public void setUsesPlasticWaterBottle()
	{
		usesPlasticWaterBottle=true;
		usesRecyclableWaterBottle=false;
		updateTotalAmountOfWater();
	}

	/**
	 * setNumberOfWaterBottles(int numberOfWaterBottles1)
	 * 
	 * This method sets the numberOfWaterBottles to the number
	 * passed into the method 
	 */
	public void setNumberOfWaterBottles(int numberOfWaterBottles1)
	{
		numberOfWaterBottles=numberOfWaterBottles1;
		updateTotalAmountOfWater();
	}	

	public int getNumberOfWaterBottles(){
		return numberOfWaterBottles;
	}

	/**
	 * setUsesDishWasher()
	 * 
	 * This method sets usesDishWasher to true
	 * and doesDishesByHand
	 */
	public void setUsesDishWasher()
	{
		usesDishWasher=true;
		doesDishedByHand=false;
		updateTotalAmountOfWater();
	}

	/**
	 * setDoesDishedByHand()
	 * 
	 * This method sets usesDishWasher to false and
	 * doesDishedByHand to true.
	 */

	public void setDoesDishedByHand()
	{
		usesDishWasher=false;
		doesDishedByHand=true;
		updateTotalAmountOfWater();
	}

	/**
	 * setNumberOfTimesDoesDishes(int setNumberOfTimesDoesDishes)
	 * 
	 * This method sets the numberOfTimesDoesDishes to the number 
	 * passed in.
	 * 
	 * @param setNumberOfTimesDoesDishes
	 */
	public void setNumberOfTimesDoesDishes(int setNumberOfTimesDoesDishes)
	{
		numberOfTimesDoesDishes=setNumberOfTimesDoesDishes;
		updateTotalAmountOfWater();
	}

	public int getNumberOfTimesDoesDishes(){
		return numberOfTimesDoesDishes;
	}

	/**setServingOfBeef(int setServingOfBeef)
	 * 
	 * This method sets the servingOfBeef to the number
	 * that is passed in.
	 * 
	 * @param setServingOfBeef
	 */
	public void setServingOfBeef(int setServingOfBeef)
	{
		servingOfBeef=setServingOfBeef;
		updateTotalAmountOfWater();
	}

	public int getServingOfBeef(){
		return servingOfBeef;
	}

	/**
	 * setServingOfChicken(int setServingOfChicken )
	 * 
	 * This method sets the servingOfChicken to the number passed in
	 * and updates the total. 
	 * 
	 * @param setServingOfChicken
	 */
	public void setServingOfChicken(int setServingOfChicken )
	{
		servingOfChicken=setServingOfChicken;
		updateTotalAmountOfWater();
	}

	public int getServingOfChicken(){
		return servingOfChicken;
	}

	/**
	 * setServingOfLamb(int setServingOfLamb)
	 * 
	 * This method sets the servingOfLamb to the number passed in
	 * and updates the total. 
	 * 
	 * @param setServingOfLamb
	 */
	public void setServingOfLamb(int setServingOfLamb)
	{
		servingOfLamb=setServingOfLamb;
		updateTotalAmountOfWater();
	}

	public int getServingOfLamb(){
		return servingOfLamb;
	}

	/**
	 * setServingOfEggs(int setServingOfEggs)
	 * 
	 * This method sets the servingOfEggs to the number passed in
	 * and updates the total. 
	 * 
	 * @param servingOfEggs
	 */
	public void setServingOfEggs(int setServingOfEggs)
	{
		servingOfEggs=setServingOfEggs;
		updateTotalAmountOfWater();
	}

	public int getServingOfEggs(){
		return servingOfEggs;
	}
	/**
	 * setServingOfVeggies(int setServingOfVeggies)
	 * 
	 * This method sets the servingOfVeges to the number passed in
	 * and updates the total. 
	 * 
	 * @param setServingOfVeggies
	 */
	public void setServingOfVeggies(int setServingOfVeggies)
	{
		servingOfVeges=setServingOfVeggies;
		updateTotalAmountOfWater();
	}

	public int getServingsOfVeggies(){
		return servingOfVeges;
	}

	/**
	 *  setServingOfLentils(int setServingOfLentils)
	 * 
	 * This method sets the servingOfLentils to the number passed in
	 * and updates the total. 
	 * 
	 * 
	 * @param setServingOfLentils
	 */
	public void setServingOfLentils(int setServingOfLentils)
	{
		servingOfLentils=setServingOfLentils;
		updateTotalAmountOfWater();
	}

	public int getServingOfLentils(){
		return servingOfLentils;
	}
	/**
	 *  setServingOfPasta(int setServingOfPasta)
	 * 
	 * This method sets the servingOfPasta to the number passed in
	 * and updates the total. 
	 * 
	 * 
	 * @param servingOfPasta
	 */
	public void setServingOfPasta(int setServingOfPasta)
	{
		servingOfPasta=setServingOfPasta;
		updateTotalAmountOfWater();
	}

	public int getServingOfPasta(){
		return servingOfPasta;
	}

	/**
	 *  setServingOfCorn(int setServingOfCorn)
	 * 
	 * This method sets the servingOfCorn to the number passed in
	 * and updates the total. 
	 * 
	 * 
	 * @param setServingOfCorn
	 */
	public void setServingOfCorn(int setServingOfCorn)
	{
		servingOfCorn=setServingOfCorn;
		updateTotalAmountOfWater();
	}

	public int getServingOfCorn(){
		return servingOfCorn;
	}
	/**
	 *  setTakesShowers()
	 * 
	 * This method sets takesShowers to true and 
	 * takesBaths to false;
	 * 
	 * 
	 * @param setServingOfCorn
	 */
	public void setTakesShowers()
	{
		takesShowers=true;
		takesBaths=false;
		updateTotalAmountOfWater();
	}

	/**
	 *  setTakesBaths()
	 * 
	 * This method sets takesShowers to false and 
	 * takesBaths to true;
	 * 
	 * 
	 * @param setServingOfCorn
	 */
	public void setTakesBaths()
	{
		takesShowers=false;
		takesBaths=true;
		updateTotalAmountOfWater();
	}

	/**
	 *  setNumberOfWashes(int setNumberOfWashes)
	 * 
	 * This method sets numberOfWashes to the number
	 * passed in and updates the total.
	 * 
	 * @param setNumberOfWashes
	 */
	public void setNumberOfWashes(int setNumberOfWashes)
	{
		numberOfWashes=setNumberOfWashes;
		updateTotalAmountOfWater();
	}

	public int getNumberOfWashes(){
		return numberOfWashes;
	}

	/**
	 * setUsesWashingMachine()
	 * 
	 * This method sets usesWashingMachine to true and
	 * handWashesClothes to false.
	 * 
	 * @param setNumberOfWashes
	 */
	public void setUsesWashingMachine()
	{
		usesWashingMachine=true;
		handWashesClothes=false;
		updateTotalAmountOfWater();
	}

	/**
	 * setHandWashesClothes()
	 * 
	 * This method sets usesWashingMachine to false and
	 * handWashesClothes to true.
	 * 
	 * @param setNumberOfWashes
	 */
	public void setHandWashesClothes()
	{
		usesWashingMachine=false;
		handWashesClothes=true;
		updateTotalAmountOfWater();
	}

	/**
	 * setNumberOfLoadsOfClothes(int setNumberOfLoadsOfClothes)
	 * 
	 * This method numberOfLoadsOfClothes to the number passed in 
	 * 
	 * @param setNumberOfLoadsOfClothes
	 */
	public void setNumberOfLoadsOfClothes(int setNumberOfLoadsOfClothes)
	{
		numberOfLoadsOfClothes=setNumberOfLoadsOfClothes;
		updateTotalAmountOfWater();
	}

	/**
	 * getNumberOfLoadsOfClothes()
	 * 
	 * @return the numberOfLoadsOfClothes
	 */
	public int getNumberOfLoadsOfClothes(){
		return numberOfLoadsOfClothes;
	}


	/**
	 * setUsesSprinklers()
	 * 
	 * This method sets usesSprinklers to true and handWaters to false;
	 */
	public void setUsesSprinklers()
	{
		usesSprinklers=true;
		handWaters=false;
		updateTotalAmountOfWater();
	}

	/**
	 * setHandWaters()
	 * 
	 * This method sets usesSprinklers to false and handWaters to true;
	 */
	public void setHandWaters()
	{
		usesSprinklers=false;
		handWaters=true;
		updateTotalAmountOfWater();
	}

	/**
	 * setNumberOfTimesWaterPlants(int setNumberOfTimesWaterPlants)
	 *  
	 *  This method sets the number passed in numberOfTimesWaterPlants.
	 *  
	 * @param setNumberOfTimesWaterPlants
	 */
	public void setNumberOfTimesWaterPlants(int setNumberOfTimesWaterPlants)
	{
		numberOfTimesWaterPlants=setNumberOfTimesWaterPlants;
		updateTotalAmountOfWater();
	}

	/**
	 * getNumberOfTimesWaterPlants()
	 * 
	 * 
	 * @return the numberOfTimesWaterPlants
	 */
	public int getNumberOfTimesWaterPlants(){
		return numberOfTimesWaterPlants;
	}

	/**
	 * updateTotalAmountOfWater()
	 * 
	 * This method updates the total amount of water in the food print
	 * based on the private data variables and a calculation.
	 * This method is called everytime that anything is changed in the Foootprint
	 * in order to ensure that the total is always up to date.
	 */
	public void updateTotalAmountOfWater()
	{
		
		//write an equation that takes
		//all the information that is 
		//in private data memebers
		//and calculates the total
		//so we can call this after new data
		//is entered so it would be like we are
		//keeping a running total
		//total=(amount of beef)*(how much water in beef) etc etc etc	
		totalLitersAmountOfWater=0;
		if(usesRecyclableWaterBottle)
		{
	
		totalLitersAmountOfWater+= (literPerRecycableWaterBottle*numberOfWaterBottles);
		System.out.println("totalLitersAmountOfWater"+totalLitersAmountOfWater);
		System.out.println("literPerRecycableWaterBottle"+literPerRecycableWaterBottle);
		System.out.println("numberOfWaterBottles"+numberOfWaterBottles);
		}
		if(usesPlasticWaterBottle)
		{
		totalLitersAmountOfWater+= (literPerPlaticWaterBottle*numberOfWaterBottles);
		
		System.out.println("totalLitersAmountOfWater"+totalLitersAmountOfWater);
		System.out.println("literPerPlaticWaterBottle"+literPerPlaticWaterBottle);
		System.out.println("numberOfWaterBottles"+numberOfWaterBottles);}
		
		if(usesDishWasher)
		{
			totalLitersAmountOfWater+=literPerDishWater*numberOfTimesDoesDishes;
		}

		if(doesDishedByHand)
		{
			totalLitersAmountOfWater+=literPerDishesByHand*numberOfTimesDoesDishes;
		}
		calcualteWaterForFood();

		if(takesShowers)
		{
			totalLitersAmountOfWater+=literPerShowerPerMinute*numberOfWashes;
		}

		if(takesBaths)
		{
			totalLitersAmountOfWater+=litersPerBath*numberOfWashes;
		}

		if(usesWashingMachine)
		{
			totalLitersAmountOfWater+=litersPerLoadsOfClothersWashingMachine*numberOfLoadsOfClothes;
		}

		if(handWashesClothes)
		{
			totalLitersAmountOfWater+=litersPerLoadsOfClothesHandWashing*numberOfLoadsOfClothes;
		}	

		if(usesSprinklers)
		{
			totalLitersAmountOfWater+=literPerSprinklerPerTime*numberOfTimesWaterPlants;
		}

		if(handWaters)
		{
			totalLitersAmountOfWater+=literPerHandWaterTime*numberOfTimesWaterPlants;
		}

		waterBottle.setWaterBottle(totalLitersAmountOfWater);
		System.out.println("print out the total"+totalLitersAmountOfWater);
	}

	/**
	 * calcualteWaterForFood()
	 * 
	 * This method increases the total amount of water used
	 * by the amount used for water.
	 */
	private void calcualteWaterForFood() {
		totalLitersAmountOfWater+=servingOfBeef*literPerServingOfBeef;
		totalLitersAmountOfWater+= servingOfChicken*literPerServingOfChicken;
		totalLitersAmountOfWater+=servingOfLamb*literPerServingOfLamb;
		totalLitersAmountOfWater+=servingOfVeges*literPerServingOfVeggies;
		totalLitersAmountOfWater+=servingOfLentils*literPerServingOfLentils;
		totalLitersAmountOfWater+=servingOfPasta*literPerServingOfPasta;
		totalLitersAmountOfWater+=servingOfEggs*literPerServingOfEggs;
		totalLitersAmountOfWater+=servingOfCorn*literPerServingOfCorn;
	}

	/**
	 * getWaterBottle()
	 * 
	 * @return the water bottle
	 */
	public Bottle getWaterBottle()
	{
		return waterBottle;
	}

	/**
	 * getTotalAmountOfWater()
	 * 
	 * @return the total amount of water
	 * used in the water bottle 
	 */
	public double getTotalAmountOfWater()
	{
		return totalLitersAmountOfWater;
	}


	/**
	 * getBottle()
	 * @return the water bottle
	 */
	public Bottle getBottle(){

		return waterBottle;

	}

	/**
	 * setUsesRecyclableWaterBottleUnclicked()
	 * 
	 * This method sets usesRecyclableWaterBottle to false.
	 */
	public void setUsesRecyclableWaterBottleUnclicked(){
		usesRecyclableWaterBottle = false;
	}

	/**
	 * setUsesPlasticWaterBottleUnclicked()
	 * 
	 * This method sets usesPlasticWaterBottle to false.
	 */
	public void setUsesPlasticWaterBottleUnclicked(){
		usesPlasticWaterBottle = false;
	}


	/**
	 *  setUsesDishWasherUnclicked()
	 *  
	 * This method sets usesDishWasher to false.
	 */
	public void setUsesDishWasherUnclicked(){
		usesDishWasher=false;
	}

	/**
	 * setDoesDishesByHandUnclicked()
	 * 
	 * This method sets doesDishedByHand to false.
	 */
	public void setDoesDishesByHandUnclicked(){
		doesDishedByHand=false;
	}

	/**
	 *setShowersUnclicked()
	 * 
	 * This method sets takesShowers to false.
	 */
	public void setShowersUnclicked(){
		takesShowers= false;
	}

	/**
	 * setBathsUnclicked()
	 * 
	 * This method sets takesBaths to false.
	 */
	public void setBathsUnclicked(){
		takesBaths = false;
	}

	/**
	 * setUsesWashingMachineUnclicked()
	 * 
	 * This method sets usesWashingMachine to false.
	 */
	public void setUsesWashingMachineUnclicked(){
		usesWashingMachine=false;
	}

	/**
	 * setHandWashesClothesUnclicked()
	 * 
	 * This method sets handWashesClothes to false.
	 */
	public void setHandWashesClothesUnclicked(){
		handWashesClothes=false;
	}

	/**
	 * setUsesSprinklersUnclicked()
	 * 
	 * This method sets usesSprinklers to false.
	 */
	public void setUsesSprinklersUnclicked(){
		usesSprinklers = false;
	}

	/**
	 * setHandWatersUnclicked()
	 * 
	 * This method sets handWaters to false.
	 */
	public void setHandWatersUnclicked(){
		handWaters=false;
	}

	/**
	 * refreshTotal()
	 * 
	 * This method sets usesRecyclableWaterBottle to false.
	 */
	public void refreshTotal(){
		updateTotalAmountOfWater();
	}

	/**
	 * Tips()
	 * 
	 * This method will be called on the last screen where the user
	 * gets their total amount of water and then prints a bunch of tips 
	 * that are specific to their water footprint.
	 * 
	 * @return a string a tips that are specifically
	 * based on the footprint and what the user has entered.
	 * 
	 */
	public String Tips()
	{
		String tipsToReturn="";
		tipsToReturn = setTips(tipsToReturn);
		return tipsToReturn;
	}

	/**
	 * setTips(String tipsToReturn)
	 * 
	 * This method returns the tips that are specific
	 * to the information entered in the footprint.
	 * 
	 * @param tipsToReturn 
	 * @return
	 */
	private String setTips(String tipsToReturn) {

		if(usesPlasticWaterBottle)
			tipsToReturn+="You should try using Recycleable Water Bottles. \n" ;
		if(doesDishedByHand)
			tipsToReturn+="You should consider using a dishwasher to wash you dishes.\n" +
					"It actually uses less water" +"Make sure you turn of the water when not using it. \n"
					+"Make sure no sinks or water sources have leaks. \n" +"Scrap excess food off of dishes instead of rinsing them before putting them in dish washer \n"
					+ "\nOr at least try to consolidate your dishwashing\n" +"If washing dishes by hand, don't let the water run. Fill a basin with water instead.";
		if(takesBaths)
			tipsToReturn+="You should take showers instead of baths. They use less water. \n"
					+ "Or at least try to make your showers quick \n" 		
					+"Don't fill bathtubs to the tops with water to reduce splashing\n";
		if (servingOfLamb+servingOfChicken+servingOfBeef>=5)
			tipsToReturn += "You should try decreasing the amount of Meat you eat. \n"
					+"Vegetables use less water to produce. They are better for the "
					+ "environment and for you. \n";
		if(numberOfWashes>7 && takesShowers)
			tipsToReturn+="You should shower less times per week. It will conserver water\n";
		else if(numberOfWashes>7)
			tipsToReturn+="You should shower less times per week. It will conserver water\n";
		if(usesWashingMachine || usesDishWasher)
			tipsToReturn+="You should be sure that you are using water efficient appliances.\n" 		
					+"Washing dark colored clothes in cold water helps to save water \n";
		if(usesSprinklers){
			tipsToReturn += "Water dry spots on your lawn by hand instead of using a sprinkler system. \n" 	
					+"Only water your lawn when it is absolutely necessary. \n" 		
					+"Collect rain water and use it to water lawns and garden\n"
					+"Don't water your lawn on windy days\n"
					+"Lawns can go a lot longer without water than you thing.\n";
		}
		tipsToReturn += "Use water calculators like this one to track your water each month!\n";
		return tipsToReturn;
	}


	public boolean getDoesDishesByHand(){
		return doesDishedByHand;
	}
	
	public boolean getHandWashesClothes(){
		return handWashesClothes;
	}
	
	public boolean getHandWaters(){
		return handWaters;
	}
	
	public boolean getUsesDishWasher(){
		return usesDishWasher;
	}
	
	public boolean getUsesPlasticWaterBottle(){
		return usesPlasticWaterBottle;
	}
	
	public boolean getUsesRecyclableWaterBottle(){
		return usesRecyclableWaterBottle;
	}
	
	public boolean getUsesSprinklers(){
		return usesSprinklers;
	}
	
	public boolean getUsesWashingMachine(){
		return usesWashingMachine;
	}
	
	public boolean getTakesBaths(){
		return takesBaths;
	}
	
	public boolean getTakesShowers(){
		return takesShowers;
	}

}
