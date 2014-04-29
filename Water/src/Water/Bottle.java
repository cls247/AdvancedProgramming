package Water;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * This is the water bottle class and it will be helpful when we 
 * want to print a water bottle with a certain water level on each 
 * of the screens.
 * 
 * @author Sand
 *
 */

public class Bottle {
	/**
	 * This holds the current amount of water that the user
	 * user is currently using.
	 */
	private double waterLevel=0;
	
	//this is a private data variable
	//that holds the index of the current
	//water bottle that the user is up to
	//ask Casandra if this is confusing
	
	private int currentBottle=0;
	
	//this private data variable holds the 
	//index of the current overflow water
	//bottle
	private int currentOverflow = 0;
	
	//this is an arraylist of all the water bottle from 1-21
	private ArrayList <String> waterBottles=new ArrayList<String>();
	//this is an arraylist of all the water bottles with overflow from 1-21
	private ArrayList <String> overflowBottles=new ArrayList<String>();
	
	/**
	 * Bottle()
	 * 
	 * This constructor just calls a method to set the values of the ArrayList
	 */
	public Bottle()
	{
		addWater();
		addOverflow();
	}
	
	/**
	 * addWater()
	 * 
	 * This method adds the correct string to every index of the ArrayList
	 */
	public void addWater()
	{		
		//this should fill the array with all the different images
		for(int i=0; i< 21; i++)
		{
			waterBottles.add("water"+String.valueOf(i+1) +".jpg");
		}
	}
	
	/**
	 * addWater()
	 * 
	 * This method adds the correct string to every index of the ArrayList
	 */
	public void addOverflow(){
		
		for(int i=0; i< 22; i++){
			
			overflowBottles.add("overflow"+String.valueOf(i+1)+".jpg");
			
		}
		
	}
	
	/**
	 * setWaterBottle(double total)
	 * This method takes total and sets the correct
	 * current index of the water bottle by a formula.
	 * 
	 * @param total the total that is to be taken in from the user
	 */
	public void setWaterBottle(double total)
	{
		//sets the water level equal to the total
 		
		//this method takes in the total amount of 
		//water and it sets the water bottle index (currentBottle)
		//to the correct index according to the amount of water
		waterLevel=total;
		currentBottle=(int) Math.floor(((double)waterLevel)/1000);
		
		if(currentBottle >= 21){
			
			currentBottle = 21;
			
		}
		else if(currentBottle<0)
		{
			currentBottle=0;
		}
		
	}
	
	/**
	 * getImage()
	 * 
	 * @return this method returns an ImageIcon for the current 
	 * water bottle that should be printed.
	 */
	public ImageIcon getImage()
	{
		
		ImageIcon waterBottle;
		if(currentBottle < 21){
			//this method returns the image of the current water bottle
			waterBottle = new ImageIcon(waterBottles.get(currentBottle));
		}else{
			
			waterBottle = new ImageIcon(overflowBottles.get(currentOverflow % 22));
			currentOverflow++;
			
		}
		return waterBottle; 
	}
	
	/**
	 * getWaterLevel()
	 * @return returns the water level of the current water bottle
	 */
	public double getWaterLevel()
	{
		
		return waterLevel;
		
	}
	
	/**
	 * getCurrentBottle()
	 * @return returns the index of the current water bottle based
	 * on the water level
	 */
	public int getCurrentBottle(){
		
		return currentBottle;
		
	}
	/**
	 * isNotFull()
	 * @return if the currentBottle is less than or equal to 21
	 */
	public boolean isNotFull(){
		return (currentBottle <= 21);
	}
	
	/**
	 * getImageBottle()
	 * 
	 */
	public String getImageBottle(int index)
	{
		return waterBottles.get(index);
	}
	
	/**
	 * getOverFlowImage()
	 * 
	 */
	public String getOverFlowImage(int index)
	{
		return overflowBottles.get(index);
	}
	
	/**
	 * getWaterBottleArray()
	 */
	public ArrayList<String> getWaterBottleArray()
	{
		return waterBottles;
	}
	/**
	 * getOverFlowArray()
	 */
	public ArrayList<String> getOverFlowArray()
	{
		return overflowBottles;
	}
	
	/**
	 * getCurentOverflow()
	 */
	public int getCurrentOverflow(){
		return currentOverflow;
	}
}
