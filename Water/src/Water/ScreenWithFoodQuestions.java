package Water;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * This is a temporary class that gets the same information as the ScreenWithDraw.
 * This was going to be used if we did not get the drag working.
 * 
 * @author Sand
 *
 */
public class ScreenWithFoodQuestions extends JPanel implements Screen{

	/**
	 * Questions that are input
	 */
	private String firstQuestion;
	private String secondQuestion;
	private Image bkgd;
	private User currentUser;
	
	public ScreenWithFoodQuestions(String firstQuestion1)
	{
		firstQuestion=firstQuestion1;
		init();
	}
	
	@Override
	public void init()
	{
		drawBackground();
		//we need to save all this data, I didn't do that
		//here we would add the background image
		setLayout(new GridLayout(2, 2));
		
		//ask first third question
		JLabel firstQuestionLabel = new JLabel(firstQuestion+"?", JLabel.CENTER);
		add(firstQuestionLabel);
		
		//answer the third question	
		JSpinner numberSpinner;
	    SpinnerNumberModel numberSpinnerModel;
	    Double current = new Double(1.00);
	    Double min = new Double(0.00);
	    Double max = new Double(100.00);
	    Double step = new Double(1.00);
	    numberSpinnerModel = new SpinnerNumberModel(current, min, max, step);
	    numberSpinner = new JSpinner(numberSpinnerModel);
	    numberSpinner.setSize(100, 1000);
	   /* JPanel panel = new JPanel();
	    panel.setSize(new Dimension(100, 100));
        panel.add(numberSpinner);*/
        add(numberSpinner);
	}

		public void paintComponent(Graphics g){

		//draw the background image
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
