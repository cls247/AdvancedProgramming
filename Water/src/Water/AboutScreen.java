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
	private User currentUser;

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
			bkgd = ImageIO.read(new File("aboutbkgd.jpg"));

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
