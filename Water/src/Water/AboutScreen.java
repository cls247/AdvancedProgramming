package Water;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * 
 * This is the screeen that contains a description' about the program and what
 * it should be used for and how it should be used.
 * 
 * @author Sand
 * 
 */
public class AboutScreen extends JPanel implements Screen {

	/**
	 * This is the background image of the screen.
	 */
	private Image bkgd;
	private Button switchScreens;
	private User currentUser;

	/**
	 * This is a string that contains the text for the about page.
	 */
	private String aboutText = "Over-consumption of water is an ongoing problem that causes a huge strain on\n"
			+ "our environment and resources. You can use this program to calculate your\n"
			+ "personal water footprint and learn how to decrease your impact. The\n"
			+ "over-consumption of water is a common problem among Americans, and\n"
			+ "indeed all world citizens, that is actively negatively impacting the\n"
			+ "environment and the world water supply. There are many different habits of the\n"
			+ "average American that contribute to this dangerous trend, and many of them are\n"
			+ "largely unknown and not immediately obvious, which contributes to the general\n"
			+ "ignorance about this problem. Education and raising awareness about this issue\n"
			+ "are important in order to begin to combat it and change the current trends.\n"
			+ "This program educates users about different sources of water consumption, from\n"
			+ "obvious ones, like using reusable water bottles instead of plastic bottles, to\n"
			+ "more discrete ones like meat and grain consumption. The user is guided through\n"
			+ "a series of screens that prompt them to fill in the amount of water they consume\n"
			+ "by way of these different means. Their responses are stored and their total water\n"
			+ "consumption is calculated. At the end, the user is told how their personal\n"
			+ "consumption compares with the recommended consumption amount and they are\n"
			+ "presented with a personalized list of recommendations and tips to reduce\n"
			+ "their water footprint.";

	/**
	 * AboutScreen()
	 * 
	 * This method called init() to set default details of the screen
	 */
	public AboutScreen() {
		init();
	}

	/**
	 * init()
	 * 
	 * This method sets up the screen for the about page and sets the background
	 * image as the background image.
	 */
	@Override
	public void init() {

		drawBackground();
	}

	/**
	 * paintComponent(Graphics g)
	 * 
	 * This method prints the background image. It also prints out the text for
	 * the about page as a drawString() in order to ensure that the text goes on
	 * top of the image.
	 * 
	 * @ param g is the Graphic Screen that the image is to be printed to
	 */
	public void paintComponent(Graphics g) {

		g.drawImage(bkgd, 0, 0, null);
		Dimension d = this.getPreferredSize();
		
		int fontSize = 25;
		g.setColor(new Color(33, 133, 111));
		g.setFont(new Font("Helvetica Neue", Font.BOLD, fontSize));
		g.drawString("About Help2Out:", 150, 40);

		fontSize = 15;
		g.setColor(new Color(2, 100, 250));
		g.setFont(new Font("Lucida Bright", Font.BOLD, fontSize));

		int x = 110;
		int y = 50;
		for (String line : aboutText.split("\n"))
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
	 * This method draws the background image for the screen.
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
