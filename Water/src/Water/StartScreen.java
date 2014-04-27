package Water;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

//this is the first screen that is shown when the calculator is first loaded
class StartScreen extends JPanel implements Screen
{
	private User currentUser;
	private Image bkgd;

	public StartScreen()
	{
		init();
	}

	public void paintComponent(Graphics g){

		//draw the image
		g.drawImage(bkgd, 0,0, null);

	}

	@Override
	public User passOnUser() {
		return currentUser;
	}
	@Override
	public void receiveUser(User setCurrentUser) {
		currentUser=setCurrentUser;
	}
	@Override
	public void init() {
		drawBackground();
		
	}

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
			System.out.println("Error in drawBackground: image file failed to load!");
		}
		
	}

}



