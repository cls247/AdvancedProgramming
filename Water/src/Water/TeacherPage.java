package Water;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
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
public class TeacherPage extends JPanel implements Screen {

	private static final String CARD_JBUTTON = "Card JButton";
	private ActionListener action;
	private Image bkgd;
	private String aboutText = " Teachers, you can use this program to educate your students"
			+ "\n about the dangers of over consuming water and some common"
			+ "\n habits that use up the most water. Many people, especially"
			+ "\n kids, are unaware of how their use of water can affect the"
			+ "\n environment. Even worse, many are unaware about how the things"
			+ "\n they do and the things that they eat affect their water footprint,"
			+ "\n and by how much. By educating kids in the classroom about water"
			+ "\n consumption, they can learn new habits to take home with them that "
			+ "\n can help change the way they and their families consume water. By "
			+ "\n teaching kids good habits early on, we can help shape the way the"
			+ "\n next treats the environment. Teachers have an amazing ability to "
			+ "\n influence the students they interact with, and as such you, as a teacher,"
			+ "\n can use this program to teach, lead, and inspire a new generation.";

	public TeacherPage() {
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
		
		// draw the text for the page being sure to keep the
		// text in front of the image
		Dimension d = this.getPreferredSize();
		int fontSize = 25;

		g.setColor(new Color(33, 133, 111));
		g.setFont(new Font("Helvetica Neue", Font.BOLD, fontSize));
		g.drawString("Info for teachers:", 150, 40);

		fontSize = 15;
		g.setColor(new Color(2, 100, 250));
		g.setFont(new Font("Lucida Bright", Font.BOLD, fontSize));

		int x = 110;
		int y = 50;

		for (String line : aboutText.split("\n"))
			g.drawString(line, x, y += g.getFontMetrics().getHeight());

	}

	@Override
	public User passOnUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void receiveUser(User currentUser) {
		// TODO Auto-generated method stub

	}

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
