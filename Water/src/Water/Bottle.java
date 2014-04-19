package Water;

import java.util.ArrayList;

public class Bottle {
	
	private int waterLevel=0;
	
	//this is a private data variable
	//that holds the index of the current
	//water bottle that the user is up to
	//ask Casandra if this is confusing
	private int currentBottle=0;
	
	private ArrayList <String> waterBottles=new ArrayList<String>();
	
	
	public void addWater()
	{		
		for(int i=0; i<=21; i++)
		{
			waterBottles.add("water"+i+".jpg");
		}
	}
	
	
	public void setWaterBottle(double total)
	{
		//sets the water level equal to the total
		
		//this method takes in the total amount of 
		//water and it sets the water bottle index (currentBottle)
		//to the correct index according to the amount of water
		
	}

}
