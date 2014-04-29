package Test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import Water.ScreenDriver;

/**
 * This class tests the methods of the Screen Driver
 * 
 *
 */
public class ScreenDriverTest {

	/**
	 * testConstructor()
	 * 
	 * test the constructor for the ScreenDriver class
	 */
	@Test
	public void testConstructor() {

		// create a new screenDriver
		ScreenDriver screenDriverTest = new ScreenDriver();

		// test that all the elements exist/have been created properly
		assertNotNull(screenDriverTest.getWelcomeScreen());
		assertNotNull(screenDriverTest.getTeacherScreen());
		assertNotNull(screenDriverTest.getAboutScreen());
		assertNotNull(screenDriverTest.getAllTipScreen());

	}

}
