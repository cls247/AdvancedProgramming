package Water;


/** Casandra Schwartz

 * @version 1.0

 * 
 * A class that tests the functions of the water bottle.
 * 
 */


import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import javax.swing.ImageIcon;

import org.junit.Test;


public class BottleTest {

	/**********CLASS METHODS******/
		
	/**
	 * testAddWater()
	 * 
	 * Test the addWater() method
	 * 
	 */
	@ Test
	public void testAddWater()
	{
		Bottle testBottle=new Bottle();
		testBottle.addWater();
		for(int i=0; i<21; i++)
		{
			String shouldBe=String.valueOf(i+1)+".jpg";
			assertEquals(testBottle.getImageBottle(i), "water" + shouldBe);
		}
	}
	
	
	/**
	 * testAddOverFlow()
	 * 
	 * Test the addWater() method
	 * 
	 */
	@ Test
	public void testAddOverFlow()
	{
		Bottle testBottle=new Bottle();
		testBottle.addOverflow();
		for(int i=0; i<22; i++)
		{
			String shouldBe=String.valueOf(i+1)+".jpg";
			assertEquals(testBottle.getOverFlowImage(i), "overflow" + shouldBe);
		}
	}
	
	
	
	/**
	 * testSetWaterBottle(double total)
	 * 
	 * 
	 */
	public void testSetWaterBottle(double total)
	{
		Bottle testBottle=new Bottle();
		testBottle.setWaterBottle(2000);
		assertEquals(testBottle.getWaterLevel(), 2000, 0);
		assertEquals(testBottle.getCurrentBottle(),0,0 );
		ImageIcon testImage=new ImageIcon("water1.jpg");
		assertEquals(testBottle.getImage(),testImage);
		
	}
	
	
	/**
	 * testIsNotFull()
	 * @return if the currentBottle is less than or equal to 21
	 */
	public void testIsNotFull(){
		Bottle testBottle=new Bottle();
		testBottle.setWaterBottle(4000);
		assertEquals(true, testBottle.isNotFull());
		testBottle.setWaterBottle(210000);
		assertEquals(false, testBottle.isNotFull());
	}



}
