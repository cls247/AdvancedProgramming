package Water;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * This is the screen where the user can read a conglomeration of a bunch of
 * different tips for saving water. The tips are divided into categories based
 * on their category.
 * 
 * @author Sand
 * 
 */
public class AllTipScreen extends JPanel implements Screen {

	/**
	 * This is the string that will be populated with all the tips to be printed
	 */
	private String tipsString = "";

	/**
	 * This is the image that will be the background
	 */
	private Image bkgd;
	/**
	 * This is the user that will be updated throughout the scereen.
	 */
	private User currentUser;

	/**
	 * AllTipScreen()
	 * 
	 * This constructor calls init() to set up the screen
	 */
	public AllTipScreen() {
		init();
	}

	/**
	 * init()
	 * 
	 * This method sets the background image of the screen and populates the
	 * string with all the tips to be printed.
	 */
	@Override
	public void init() {
		drawBackground();
		populateTips();
		JLabel tips = new JLabel(tipsString);
		add(tips);

	}

	/**
	 * populateTips()
	 * 
	 * This method simply populates the string with all the different tips that
	 * are to be printed.
	 */
	private void populateTips() {
		tipsString += "\u2022 Consider using recycable water bottles instead of plastic bottles. \n"
				+ "\u2022 Make sure you turn off all faucets when they're not being used. \n"
				+ "\u2022 Check your pipes and sinks for possible leaks. \n"
				+ "\u2022 Don't forget to check all of your outside faucets for leaks as well!\n"
				+ "\u2022 Using a dishwasher saves more water than washing dishes by hand.\n"
				+ "\u2022 Fill a basin with water instead of letting the water run when washing dishes.\n"
				+ "\u2022 Scrap excess food off dishes before putting them in the dishwasher. \n"
				+ "\u2022 Start a compost pile instead of washing food down the sink. \n"
				+ "\u2022 When you wash fruit, collect the runoff water to later water household plants. \n"
				+ "\u2022 Make sure you're using water efficient appliances! \n"
				+ "\u2022 Washing dark colored clothes in cold water helps to save water. \n"
				+ "\u2022 Moderate length showers save more water than baths. \n"
				+ "\u2022 If taking a bath, don't fill the bathtub to the top in order to reduce splashing.\n"
				+ "\u2022 Water dry spots on your lawn by hand instead of using a sprinkler system. \n"
				+ "\u2022 If you're going to water your lawn, only do it when it's absolutely necessary. \n"
				+ "\u2022 Don't water your lawn on windy days- the water will blow away!\n"
				+ "\u2022 Reuse used ice cubes by placing them into plants. \n"
				+ "\u2022 Collect rain water and use it to water your lawn and/or garden.\n"
				+ "\u2022 Wash your pets outside on the lawn in order to get extra use from your water. \n"
				+ "\u2022 Lawns can actually go a lot longer without being watered than you think!\n"
				+ "\u2022 Use water calculators like this one to track your water footprint!\n";

	}

	/**
	 * paintComponent(Graphics g)
	 * 
	 * This method draws an image as the background and prints the text for the
	 * tips with proper formatting (spacing between lines).
	 * 
	 * @param g
	 *            this is the Graphics screen that the images will be passed to
	 */
	public void paintComponent(Graphics g) {

		g.drawImage(bkgd, 0, 0, null);
		Dimension d = this.getPreferredSize();

		int fontSize = 25;
		g.setColor(new Color(33, 133, 111));
		g.setFont(new Font("Helvetica Neue", Font.BOLD, fontSize));
		g.drawString("General tips for conserving water:", 150, 40);

		fontSize = 15;
		g.setColor(new Color(2, 100, 250));
		g.setFont(new Font("Lucida Bright", Font.BOLD, fontSize));

		int x = 110;
		int y = 50;

		// for loop that enters line breaks to the text
		for (String line : tipsString.split("\n"))
			g.drawString(line, x, y += g.getFontMetrics().getHeight());

	}

	/**
	 * passOnUser() This method returns the user to the control class.
	 */
	@Override
	public User passOnUser() {
		return currentUser;
	}

	/**
	 * receiveUser(User setCurrentUser) This method takes in a User and sets the
	 * current user to the user that is passed in.
	 */
	@Override
	public void receiveUser(User setCurrentUser) {
		currentUser = setCurrentUser;

	}

	/**
	 * drawBackground()
	 * 
	 * This method draws the background of the screen.
	 */
	@Override
	public void drawBackground() {
		try {

			// process the image file
			bkgd = ImageIO.read(new File("background.jpg"));

			// set the size of the frame based on the size of the image so that
			// the entire background is covered
			Dimension size = new Dimension(bkgd.getWidth(null),
					bkgd.getHeight(null));

			// set all of the dimensions using the size
			setPreferredSize(size);
			setMinimumSize(size);
			setMaximumSize(size);
			setSize(size);
			setLayout(null);

			// if there is an error with the file, throw and IOException
		} catch (IOException error) {
			System.out
					.println("Error in drawBackground: image file failed to load!");
		}

	}

}
