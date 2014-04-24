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
	
	public ScreenWithFoodQuestions(String firstQuestion1)
	{
		firstQuestion=firstQuestion1;
		init();
	}
	
	@Override
	public void init()
	{
		try{

			//set the background image
			bkgd = ImageIO.read(new File("background.jpg"));
			Dimension size = new Dimension(bkgd.getWidth(null), bkgd.getHeight(null));
			setPreferredSize(size);
			setMinimumSize(size);
			setMaximumSize(size);
			setSize(size);
			setLayout(null);
			
		}catch(IOException error){


		}
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

}
