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
	//there are stilll a bunch more private data variables that 
	//we have to add and then we have to add setters
	//for each of those
	private boolean usesRecyclableWaterBottle=false;
	private boolean usesPlasticWaterBottle=false;
	private final double literPerWaterBottle=.6;
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
	private final int literPerServingOfVeges=20;
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
	
	public FootPrint()
	{
		waterBottle=new Bottle();
	}
	public void setUsesRecyclableWaterBottle(boolean usesRecyclableWaterBottle1)
	{
		usesRecyclableWaterBottle=usesRecyclableWaterBottle1;
		updateTotalAmountOfWater();
	}
	public void setUsesPlasticWaterBottle(boolean usesPlasticWaterBottle1)
	{
		usesPlasticWaterBottle=usesPlasticWaterBottle1;
		updateTotalAmountOfWater();
	}
	public void setNumberOfWaterBottles(int numberOfWaterBottles1)
	{
		numberOfWaterBottles=numberOfWaterBottles1;
		updateTotalAmountOfWater();
	}	
	public void setUsesDishWasher(boolean usesDishWasher1)
	{
		usesDishWasher=usesDishWasher1;
		updateTotalAmountOfWater();
	}
	public void setDoesDishedByHand(boolean doesDishedByHand1)
	{
		doesDishedByHand=doesDishedByHand1;
		updateTotalAmountOfWater();
	}
	public void setNumberOfTimesDoesDishes(int setNumberOfTimesDoesDishes)
	{
		numberOfTimesDoesDishes=setNumberOfTimesDoesDishes;
		updateTotalAmountOfWater();
	}
	
	public void setServingOfBeef(int setServingOfBeef)
	{
		servingOfBeef=setServingOfBeef;
		updateTotalAmountOfWater();
	}
	public void setServingOfChicken(int setServingOfChicken )
	{
		servingOfChicken=setServingOfChicken;
		updateTotalAmountOfWater();
	}
	public void setServingOfLamb(int setServingOfLamb)
	{
		servingOfLamb=setServingOfLamb;
		updateTotalAmountOfWater();
	}
	public void setServingOfEggs(int setServingOfEggs)
	{
		servingOfEggs=setServingOfEggs;
		updateTotalAmountOfWater();
	}
	public void setServingOfVeges(int setServingOfVeges)
	{
		servingOfVeges=setServingOfVeges;
		updateTotalAmountOfWater();
	}
	public void setServingOfLentils(int setServingOfLentils)
	{
		servingOfLentils=setServingOfLentils;
		updateTotalAmountOfWater();
	}
	public void setServingOfPasta(int setServingOfPasta)
	{
		servingOfPasta=setServingOfPasta;
		updateTotalAmountOfWater();
	}
	public void setServingOfCorn(int setServingOfCorn)
	{
		servingOfCorn=setServingOfCorn;
		updateTotalAmountOfWater();
	}
	public void setTakesShowers(boolean setTakesShowers)
	{
		takesShowers=setTakesShowers;
		updateTotalAmountOfWater();
	}
	public void setTakesBaths(boolean setTakesBaths)
	{
		takesBaths=setTakesBaths;
		updateTotalAmountOfWater();
	}
	public void setNumberOfWashes(int setNumberOfWashes)
	{
		numberOfWashes=setNumberOfWashes;
		updateTotalAmountOfWater();
	}
	
	public void setUsesWashingMachine(boolean setUsesWashingMachine)
	{
		usesWashingMachine=setUsesWashingMachine;
		updateTotalAmountOfWater();
	}
	public void setHandWashesClothes(boolean setHandWashesClothes)
	{
		handWashesClothes=setHandWashesClothes;
		updateTotalAmountOfWater();
	}
	public void setNumberOfLoadsOfClothes(int setNumberOfLoadsOfClothes)
	{
		numberOfLoadsOfClothes=setNumberOfLoadsOfClothes;
		updateTotalAmountOfWater();
	}
	public void setUsesSprinklers(boolean setUsesSprinklers)
	{
		usesSprinklers=setUsesSprinklers;
		updateTotalAmountOfWater();
	}
	public void setHandWaters(boolean setHandWaters)
	{
		handWaters=setHandWaters;
		updateTotalAmountOfWater();
	}

	public void setNumberOfTimesWaterPlants(int setNumberOfTimesWaterPlants)
	{
		numberOfTimesWaterPlants=setNumberOfTimesWaterPlants;
		updateTotalAmountOfWater();
	}
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
		totalLitersAmountOfWater+=servingOfVeges*literPerServingOfVeges;
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
		System.out.println("totalLitersofWater"+totalLitersAmountOfWater);
		
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
