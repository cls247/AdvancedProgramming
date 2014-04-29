package Test;

import static org.junit.Assert.*;

import javax.swing.JTextField;

import org.junit.Test;

import Water.InteractivePage;

public class updateConsumptionStatusTest {

	@Test
	public void test() {
		
		//create a new interactive page
		InteractivePage testPage = new InteractivePage();
		
		//test the updateConsumptionStatus() on a value less than 1500
		testPage.setTextWater("100");
		testPage.updateConsumptionStatus();
		String goodConsumptionStatus = testPage.getConsumptionStatus().getText();
		
		assertTrue(goodConsumptionStatus.equals("<html><p>You are consuming a healthy amount of water</p></html>"));
		
		//test the updateConsumptionStatus() on a value greather than 1500
		testPage.setTextWater("2000");
		testPage.updateConsumptionStatus();
		String badConsumptionStatus = testPage.getConsumptionStatus().getText();
		
		assertTrue(badConsumptionStatus.equals("You are consuming too much water"));
	}

}
