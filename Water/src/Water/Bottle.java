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
	
	//this is an arraylist of all the water bottle from 1-21
	private ArrayList <String> waterBottles=new ArrayList<String>();
	
	/**
	 * Bottle()
	 * 
	 * This constructor just calls a method to set the values of the ArrayList
	 */
	public Bottle()
	{
		addWater();
	}
	
	/**
	 * addWater()
	 * 
	 * This method adds the correct string to every index of the ArrayList
	 */
	public void addWater()
	{		
		//this should fill the array with all the different images
		for(int i=0; i<=21; i++)
		{
			waterBottles.add("water"+String.valueOf(i+1) +".jpg");
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
		currentBottle=(int) Math.floor(((double)waterLevel)/1000);
		
	}
	
	/**
	 * getImage()
	 * 
	 * @return this method returns an ImageIcon for the current 
	 * water bottle that should be printed.
	 */
	public ImageIcon getImage()
	{
		//this method returns the image of the current water bottle
		System.out.println(waterBottles.get(currentBottle));
		ImageIcon waterBottle = new ImageIcon(waterBottles.get(currentBottle));
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
	

}
