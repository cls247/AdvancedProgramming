package Water;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Bottle {
	
	private double waterLevel=0;
	
	//this is a private data variable
	//that holds the index of the current
	//water bottle that the user is up to
	//ask Casandra if this is confusing
	
	private int currentBottle=0;
	
	//this is an arraylist of all the water bottle from 1-21
	private ArrayList <String> waterBottles=new ArrayList<String>();
	
	public Bottle()
	{
		addWater();
	}
	
	public void addWater()
	{		
		//this should fill the array with all the different images
		for(int i=0; i<=21; i++)
		{
			waterBottles.add("water"+String.valueOf(i+1) +".jpg");
		}
	}
	
	
	public void setWaterBottle(double total)
	{
		//sets the water level equal to the total
 		
		//this method takes in the total amount of 
		//water and it sets the water bottle index (currentBottle)
		//to the correct index according to the amount of water
		currentBottle=(int) Math.floor(((double)waterLevel)/1000);
		
	}
	public ImageIcon getImage()
	{
		//this method returns the image of the current water bottle
		System.out.println(waterBottles.get(currentBottle));
		ImageIcon waterBottle = new ImageIcon(waterBottles.get(currentBottle));
		return waterBottle; 
	}
	
	public double getWaterLevel()
	{
		
		return waterLevel;
		
	}
	
	public int getCurrentBottle(){
		
		return currentBottle;
		
	}
	

}
