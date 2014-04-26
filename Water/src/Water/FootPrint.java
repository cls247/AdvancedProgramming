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

	//this is where a database would come in handy
	//there are still a bunch more private data variables that 
	//we have to add and then we have to add setters
	//for each of those
	private boolean usesRecyclableWaterBottle=true;
	private boolean usesPlasticWaterBottle=false;
	private final double literPerWaterBottle=.6;
	private int numberOfWaterBottles=0;
	
	private boolean usesSprinklers=true;
	private final int literPerSprinklerPerTime=90;
	private boolean handWaters=false;
	private final int literPerHandWaterTime=50;
	private int numberOfTimesWaterPlants;
	
	private boolean usesDishWasher=true;
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
	
	private boolean takesShowers=true;
	private final double literPerShowerPerMinute=35;
	private boolean takesBaths=false;
	private final double litersPerBath=50;
	private int numberOfWashes=0;
	
	private boolean usesWashingMachine=true;
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
	public void setUsesRecyclableWaterBottle()
	{
		usesRecyclableWaterBottle=true;
		usesPlasticWaterBottle=false;
		updateTotalAmountOfWater();
		
	}
	public void setUsesPlasticWaterBottle()
	{
		usesPlasticWaterBottle=true;
		usesRecyclableWaterBottle=false;
		updateTotalAmountOfWater();
	}
	public void setNumberOfWaterBottles(int numberOfWaterBottles1)
	{
		numberOfWaterBottles=numberOfWaterBottles1;
		updateTotalAmountOfWater();
	}	
	public void setUsesDishWasher()
	{
		usesDishWasher=true;
		doesDishedByHand=false;
		updateTotalAmountOfWater();
	}
	public void setDoesDishedByHand()
	{
		usesDishWasher=false;
		doesDishedByHand=true;
		updateTotalAmountOfWater();
	}
	public void setNumberOfTimesDoesDishes(int setNumberOfTimesDoesDishes)
	{
		numberOfTimesDoesDishes=setNumberOfTimesDoesDishes;
		updateTotalAmountOfWater();
	}
	
	public void setServingOfBeef(int setServingOfBeef)
	{
		servingOfBeef+=setServingOfBeef;
		updateTotalAmountOfWater();
	}
	public void setServingOfChicken(int setServingOfChicken )
	{
		servingOfChicken+=setServingOfChicken;
		updateTotalAmountOfWater();
	}
	public void setServingOfLamb(int setServingOfLamb)
	{
		servingOfLamb+=setServingOfLamb;
		updateTotalAmountOfWater();
	}
	public void setServingOfEggs(int setServingOfEggs)
	{
		servingOfEggs+=setServingOfEggs;
		updateTotalAmountOfWater();
	}
	public void setServingOfVeggies(int setServingOfVeggies)
	{
		servingOfVeges+=setServingOfVeggies;
		updateTotalAmountOfWater();
	}
	public void setServingOfLentils(int setServingOfLentils)
	{
		servingOfLentils+=setServingOfLentils;
		updateTotalAmountOfWater();
	}
	public void setServingOfPasta(int setServingOfPasta)
	{
		servingOfPasta+=setServingOfPasta;
		updateTotalAmountOfWater();
	}
	public void setServingOfCorn(int setServingOfCorn)
	{
		servingOfCorn+=setServingOfCorn;
		updateTotalAmountOfWater();
	}
	public void setTakesShowers()
	{
		takesShowers=true;
		takesBaths=false;
		updateTotalAmountOfWater();
	}
	public void setTakesBaths()
	{
		takesShowers=false;
		takesBaths=true;
		updateTotalAmountOfWater();
	}
	public void setNumberOfWashes(int setNumberOfWashes)
	{
		numberOfWashes=setNumberOfWashes;
		updateTotalAmountOfWater();
	}
	
	public void setUsesWashingMachine()
	{
		usesWashingMachine=true;
		handWashesClothes=false;
		updateTotalAmountOfWater();
	}
	public void setHandWashesClothes()
	{
		usesWashingMachine=false;
		handWashesClothes=true;
		updateTotalAmountOfWater();
	}
	public void setNumberOfLoadsOfClothes(int setNumberOfLoadsOfClothes)
	{
		numberOfLoadsOfClothes=setNumberOfLoadsOfClothes;
		updateTotalAmountOfWater();
	}
	public void setUsesSprinklers()
	{
		usesSprinklers=true;
		handWaters=false;
		updateTotalAmountOfWater();
	}
	public void setHandWaters()
	{
		usesSprinklers=false;
		handWaters=true;
		updateTotalAmountOfWater();
	}

	public void setNumberOfTimesWaterPlants(int setNumberOfTimesWaterPlants)
	{
		numberOfTimesWaterPlants=setNumberOfTimesWaterPlants;
		updateTotalAmountOfWater();
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
		
		System.out.println("liter er water boottle"+literPerWaterBottle);
		System.out.println("number of water bottle"+numberOfWaterBottles);
		System.out.println("totalLitersofWater"+totalLitersAmountOfWater);
		totalLitersAmountOfWater= (literPerWaterBottle*numberOfWaterBottles);
		System.out.println("totalLitersofWater"+totalLitersAmountOfWater);
		if(usesDishWasher)
		{
			totalLitersAmountOfWater+=literPerDishWater*numberOfTimesDoesDishes;
		}
		if(doesDishedByHand)
		{
			totalLitersAmountOfWater+=literPerDishesByHand*numberOfTimesDoesDishes;
		}
		totalLitersAmountOfWater+=servingOfBeef*literPerServingOfBeef;
		totalLitersAmountOfWater+= servingOfChicken*literPerServingOfChicken;
		totalLitersAmountOfWater+=servingOfLamb*literPerServingOfLamb;
		totalLitersAmountOfWater+=servingOfVeges*literPerServingOfVeggies;
		totalLitersAmountOfWater+=servingOfLentils*literPerServingOfLentils;
		totalLitersAmountOfWater+=servingOfPasta*literPerServingOfPasta;
		
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
		System.out.println("totalLitersofWater"+totalLitersAmountOfWater);
		waterBottle.setWaterBottle(totalLitersAmountOfWater);
		
	}
	public Bottle getWaterBottle()
	{
		return waterBottle;
	}
	
	public double getTotalAmountOfWater()
	{
		System.out.println("*********Getting Water*********" + totalLitersAmountOfWater);
		return totalLitersAmountOfWater;
	}
	
	public Bottle getBottle(){
		
		return waterBottle;
		
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
		if(usesPlasticWaterBottle)
			tipsToReturn+="You should try using Recycleable Water Bottles. \n";
		if(doesDishedByHand)
			tipsToReturn+="You should consider using a dishwasher to wash you dishes.\n" +
					"It actually uses less water";
		if(takesBaths)
			tipsToReturn+="You shoudl take showers instead of baths. They use less water. \n";
		if (servingOfLamb+servingOfChicken+servingOfBeef>=5)
			return "You should try decreasing the amount of Meat you eat. \n"
					+"Vegetables use less water to produce. They are better for the "
					+ "environment and for you. \n";
		if(numberOfWashes>7 && takesShowers)
			tipsToReturn+="You should shower less times per week. It will conserver water\n";
		else if(numberOfWashes>7)
			tipsToReturn+="You should shower less times per week. It will conserver water\n";
		if(usesWashingMachine || usesDishWasher)
			tipsToReturn+="You should be sure that you are using water efficient appliances.";
		return tipsToReturn;
		
	}

	
}
