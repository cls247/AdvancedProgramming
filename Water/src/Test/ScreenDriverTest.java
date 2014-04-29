package Test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import Water.ScreenDriver;

public class ScreenDriverTest {

	@Test
	public void testConstructor() {

		ScreenDriver screenDriverTest = new ScreenDriver();
		assertNotNull(screenDriverTest.getWelcomeScreen());
		assertNotNull(screenDriverTest.getTeacherScreen());
		assertNotNull(screenDriverTest.getAboutScreen());
		assertNotNull(screenDriverTest.getAllTipScreen());

	}

}
