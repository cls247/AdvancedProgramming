package Water;

public class FootPrint {

	//this is where a database would come in handy
	//there are stilll a bunch more private data variables that 
	//we have to add and then we have to add setters
	//for each of those
	private boolean usesRecyclableWaterBottle=false;
	private boolean usesPlasticWaterBottle=false;
	private int numberOfWaterBottles=0;
	
	private boolean usesDishWasher=false;
	private boolean doesDishedByHand=false;
	private int numberOfTimesDoesDishes=0;
	
	private int servingOfBeef=0;
	private int servingOfChicken=0;
	private int servingOfTurkey=0;
	
	private boolean takesShowers=false;
	private boolean takesBaths=false;
	private int numberOfWashes=0;
	
	private boolean usesWashingMachine=false;
	private boolean handWashesClothes=false;
	private int numberOfLoadsOfClothes=0;
	
	private int totalAmountOfWater=0;
	private Bottle waterBottle;
	
	public FootPrint()
	{
		waterBottle=new Bottle();
	}
	public void setUsesRecyclableWaterBottle(boolean usesRecyclableWaterBottle1)
	{
		usesRecyclableWaterBottle=usesRecyclableWaterBottle1;
	}
	public void setUsesPlasticWaterBottle(boolean usesPlasticWaterBottle1)
	{
		usesPlasticWaterBottle=usesPlasticWaterBottle1;
	}
	public void setNumberOfWaterBottles(int numberOfWaterBottles1)
	{
		numberOfWaterBottles=numberOfWaterBottles1;
	}	
	public void setUsesDishWasher(boolean usesDishWasher1)
	{
		usesDishWasher=usesDishWasher1;
	}
	public void setDoesDishedByHand(boolean doesDishedByHand1)
	{
		doesDishedByHand=doesDishedByHand1;
	}
	public void setNumberOfTimesDoesDishes(int setNumberOfTimesDoesDishes)
	{
		numberOfTimesDoesDishes=setNumberOfTimesDoesDishes;
	}
	
	public void setServingOfBeef(int setServingOfBeef)
	{
		servingOfBeef=setServingOfBeef;
	}
	public void setServingOfChicken(int setServingOfChicken )
	{
		servingOfChicken=setServingOfChicken;
	}
	public void setServingOfTurkey(int setServingOfTurkey)
	{
		servingOfTurkey=setServingOfTurkey;
	}
	
	public void setTakesShowers(boolean setTakesShowers)
	{
		takesShowers=setTakesShowers;
	}
	public void setTakesBaths(boolean setTakesBaths)
	{
		takesBaths=setTakesBaths;
	}
	public void setNumberOfWashes(int setNumberOfWashes)
	{
		numberOfWashes=setNumberOfWashes;
	}
	
	public void setUsesWashingMachine(boolean setUsesWashingMachine)
	{
		usesWashingMachine=setUsesWashingMachine;
	}
	public void setHandWashesClothes(boolean setHandWashesClothes)
	{
		handWashesClothes=setHandWashesClothes;
	}
	public void setNumberOfLoadsOfClothes(int setNumberOfLoadsOfClothes)
	{
		numberOfLoadsOfClothes=setNumberOfLoadsOfClothes;
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
	}
	
}
