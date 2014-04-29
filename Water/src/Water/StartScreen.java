package Water;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * this is the first screen that is shown when the calculator is first loaded
 * that will display the welcome image and the buttons to get started
 * 
 */

class StartScreen extends JPanel implements Screen {
	// the current user
	private User currentUser;

	// the image for the background picture
	private Image bkgd;

	/**
	 * StartScreen()
	 * 
	 * this just calls the init() function to initialize the GUI
	 */
	public StartScreen() {
		init();
	}

	/**
	 * paintComponent(Graphics g)
	 * 
	 * This just paints the background image
	 */
	public void paintComponent(Graphics g) {

		// draw the image
		g.drawImage(bkgd, 0, 0, null);

	}

	/**
	 * passOnUser()
	 * 
	 * this method passes the user out of the screen
	 */
	@Override
	public User passOnUser() {
		return currentUser;
	}

	/**
	 * receiveUser(User setCurrentUser)
	 * 
	 * method sets the current User of the screen
	 */
	@Override
	public void receiveUser(User setCurrentUser) {
		currentUser = setCurrentUser;
	}

	/**
	 * init()
	 * 
	 * this just calls the drawBackground function
	 */
	@Override
	public void init() {
		drawBackground();

	}

	/**
	 * drawBackground()
	 * 
	 * This method created an image from an image file to set the background of
	 * the frame so that it can be repainted every time. The other size
	 * dimensions are set based on the size of the image so covered the entire
	 * frame
	 * 
	 * @exception error
	 *                - if the file is not found, throws an IOException
	 */
	@Override
	public void drawBackground() {
		try {

			// process the image file
			bkgd = ImageIO.read(new File("welcomebackground.jpg"));

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
