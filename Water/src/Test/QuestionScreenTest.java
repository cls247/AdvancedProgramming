package Test;

import static org.junit.Assert.assertEquals;

import javax.swing.JCheckBox;
import javax.swing.JSpinner;

import org.junit.BeforeClass;
import org.junit.Test;

import Water.QuestionScreen;
import Water.User;

/**
 * This method test the Question Screen's method.
 * 
 * @author Chris
 * 
 */
public class QuestionScreenTest {

	// make data variables to hold the three questions
	private static String firstQuestion = "1st Question";
	private static String secondQuestion = "2nd Question";
	private static String thirdQuestion = "3rd Question";

	private static String type = "bottle";
	static QuestionScreen qScreen;

	// create CheckBoxes to answer the questions
	static JCheckBox testButton2;
	static JCheckBox testButton1;
	static JSpinner testSpinner;

	// this is the User to test
	static User testUser;

	/**
	 * setUpBeforeClass()
	 * 
	 * This method sets up all the data before any other class is called.
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		testUser = new User();
		qScreen = new QuestionScreen(firstQuestion, secondQuestion,
				thirdQuestion, type);
		testButton2 = qScreen.getButton2();
		testButton1 = qScreen.getButton1();
		testSpinner = qScreen.getSpinner();
		qScreen.getButton1().setSelected(true);

	}

	/**
	 * QuestionScreenTest()
	 * 
	 * This method checked the constructor for the QuestionScreen.
	 */
	@Test
	public void QuestionScreenTest() {

		QuestionScreen testQScreen = new QuestionScreen(firstQuestion,
				secondQuestion, thirdQuestion, type);
		String actualFirstQuestion = testQScreen.getFirstQuestion();
		String expectedFirstQuestion = "1st Question";

		assertEquals(expectedFirstQuestion, actualFirstQuestion);
	}

	/**
	 * createSecondLabelAndButtonTest()
	 * 
	 * This method creates the second label and button and tests to make sure
	 * that those things are created properly.
	 */
	@Test
	public void createSecondLabelAndButtonTest() {

		testButton2.doClick();
		User testUser = qScreen.passOnUser();
		boolean actualUsesPlasticWaterBottle = testUser.getFootPrint()
				.getUsesPlasticWaterBottle();
		boolean expectedUsesPlasticWaterBottle = true;

		assertEquals(expectedUsesPlasticWaterBottle,
				actualUsesPlasticWaterBottle);
	}

	/**
	 * createFirstLabelAndButtonTest()
	 * 
	 * This method creates the first label and button and tests to make sure
	 * that those things are created properly.
	 */
	@Test
	public void createFirstLabelAndButtonTest() {

		testButton1.doClick();
		User testUser = qScreen.passOnUser();
		boolean actualUsesRecyclableWaterBottle = testUser.getFootPrint()
				.getUsesRecyclableWaterBottle();
		boolean expectedUsesRecyclableWaterBottle = true;

		assertEquals(expectedUsesRecyclableWaterBottle,
				actualUsesRecyclableWaterBottle);

	}

	/**
	 * addMoreQuestionsTest()
	 * 
	 * This method tests that the additional question is added to the screen
	 * once one of the first questions is answered.
	 * 
	 */
	@Test
	public void addMoreQuestionsTest() {

		boolean actualSpinnerVisible = false;
		qScreen.repaint();
		actualSpinnerVisible = qScreen.getButton1().isVisible();
		boolean expectedSpinnerVisible = true;

		assertEquals(expectedSpinnerVisible, actualSpinnerVisible);

	}

	/**
	 * checkForCheckedBoxesTest()
	 * 
	 * This method tests to see if the toggle buttons are selected and
	 * deselected properly.
	 * 
	 */
	@Test
	public void checkForCheckedBoxesTest() {

		if (qScreen.getButton1().isSelected())
			qScreen.getButton1().setSelected(false);
		qScreen.repaint();
		boolean actualUsesRecyclables = testUser.getFootPrint()
				.getUsesRecyclableWaterBottle();
		boolean expectedUsesRecyclables = false;

		assertEquals(expectedUsesRecyclables, actualUsesRecyclables);

	}

}
