package Water;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * A page that teachers can go to it and read about the program and decide how
 * to use it in a classroom.
 * 
 * @author Sand
 * 
 */

public class TeacherScreen extends JPanel implements Screen {

	private Image bkgd;

	public TeacherScreen() {
		init();
	}

	@Override
	public void init() {

		setLayout(new GridLayout(2, 2));

		// Just write something and then put it here
		drawBackground();

	}

	public void paintComponent(Graphics g) {
		// draw the background image
		g.drawImage(bkgd, 0, 0, null);

	}

	@Override
	public User passOnUser() {
		return null;
	}

	@Override
	public void receiveUser(User currentUser) {
	}

	@Override
	public void drawBackground() {
		try {

			// process the image file
			bkgd = ImageIO.read(new File("teacherbkgd.jpg"));

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
