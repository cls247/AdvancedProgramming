package Water;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
			bkgd = ImageIO.read(new File("tipsbkgd.jpg"));

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
