package Water;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * This should be the template for the page that has 
 * dragging features. This will be used for the 
 * grains, meats and fruits and vegetables.
 * 
 * @author Sand
 *
 */

public class ScreenWithDraw extends JPanel implements Runnable {

	private ImageIcon plate=new ImageIcon("Water/plate.jpg");
	private Image platePicture=plate.getImage();
	private Thread dragToPlate=new Thread();
	private final int DELAY = 20;
	private ArrayList<String> picturesToDrag=new ArrayList<String>();
	//i was thinking about having a string that was 
	//meat, grains or fruits that said which it should be ???? not sure yet
	private String type;
	
	/**
	 * This will take in an array of pictures that will be dragged
	 * @param pics
	 */
	public ScreenWithDraw(ArrayList<String> pics)
	{
		picturesToDrag=pics;
		init();
	}
	public void init()
	{
		
	}
	/**
	 * addNotify()
	 * 
	 * This method creates a new Thread for the game to run on.
	 * 
	 */
	@Override
	public void addNotify() {
		super.addNotify();
		dragToPlate = new Thread(this);
		dragToPlate.start();
	} 
	@Override
	public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//draw the picture of the plate
			Graphics2D graphicsObject2d = (Graphics2D) g;
			graphicsObject2d.drawImage(platePicture, 200, 200, this);

	}	
	
	@Override
	public void run() {

		
		//************
		//below here is just the stuff to create a thread and have it move smoothly
		long beforeTime, timeDiff, timeSleep;
		beforeTime = System.currentTimeMillis();


		while (true) {

			repaint();

			//proper time delay to make the elements
			//loop like that are properly animated
			timeDiff = System.currentTimeMillis() - beforeTime;
			timeSleep = DELAY - timeDiff;

			if (timeSleep < 0) {
				timeSleep = 2;
			}

			try {
				Thread.sleep(timeSleep);
			} catch (InterruptedException e) {
				System.out.println("Interrupted: " + e.getMessage());
			}

			beforeTime = System.currentTimeMillis();
		}
	}
	
}
