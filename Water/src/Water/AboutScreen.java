package Water;

import java.awt.Button;
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
 * This is the screeen that contains a description'
 * about the program and what it should be used for and
 * how it should be used. 
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
	private String aboutText = "Over-consumption "
			+ "of water is an ongoing problem and causes a \n huge strain on our environment and "
			+ "resources.\n You can use this program to calculate your personal water footprint, \n"
			+ "learn how to decrease your impact, and "
			+ "track your progress over time.\n"
			+"Over-consumption of water is a common problem among Americans, \n "
			+ "and indeed all world citizens, that is creating a strain on the \n"
			+ "environment. There are many different habits of the average American\n"
			+ "that contribute to this dangerous trend, and many of them are rather\n"
			+ "unknown and not immediately obvious, which contributes to the general\n"
			+"ignorance about this problem. Education and raising awareness about this\n"
			+ "issue are important in order to begin to combat it and change the current trends.\n"
			+ "This program educates users about different sources of water consumption, from\n"
			+"obvious ones non-reusable water bottles to more discrete ones like meat and grain\n"
			+"consumption. The user is guided through a series of screens that prompt them to \n"
			+"fill in the amount of water they consume by way of these different means. \n"
			+"Their responses are stored and their total water consumption is calculated. \n"
			+"At the end, the user is told how their personal consumption compares with the \n"
			+"recommended consumption amount and they are presented with a personalized list of \n"
			+"recommendations and tips to reduce their water footprint.";


	/**
	 * AboutScreen()
	 * 
	 * This method called init() to set default details of the screen
	 */
	public AboutScreen()
	{
		init();
	}

	/**
	 * init()
	 * 
	 * This method sets up the screen for the about page
	 * and sets the background image as the background image.
	 */
	@Override
	public void init()
	{

	 drawBackground();
	}

	/**
	 * paintComponent(Graphics g)
	 * 
	 * This method prints the background image. It also prints
	 * out the text for the about page as a drawString() in order
	 * to ensure that the text goes on top of the image.
	 * 
	 * @ param g is the Graphic Screen that the image is to be printed to
	 */
	public void paintComponent(Graphics g){

		g.drawImage(bkgd, 0,0, null);
		Dimension d = this.getPreferredSize(); 
		int fontSize = 15; 
		g.setFont(new Font("Helvetica Neue", Font.PLAIN, fontSize)); 

		int x = 100;
		int y = 50;

		for (String line : aboutText.split("\n"))
			g.drawString(line, x, y += g.getFontMetrics().getHeight());

	}
	
	/**
	 * passOnUser()
	 * This method returns the user to the control class.
	 */
	@Override
	public User passOnUser() {
		return currentUser;
	}

	/**
	 *  receiveUser(User setCurrentUser)
	 * This method takes in a User and sets the current
	 * user to the user that is passed in.
	 */
	@Override
	public void receiveUser(User setCurrentUser) {
		currentUser=setCurrentUser;

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
			System.out.println("Error in drawBackground: image file failed to load!");
		}
		
	}

}
