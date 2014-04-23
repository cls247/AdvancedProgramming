package Water;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.TransferHandler;

/**
 * This should be the template for the page that has 
 * dragging features. This will be used for the 
 * grains, meats and fruits and vegetables.
 * 
 * @author Sand
 *
 */

public class ScreenWithDraw extends JPanel implements Runnable, Global {

	private ImageIcon plate=new ImageIcon("Water/plate.jpg");
	private Image platePicture=plate.getImage();
	private Thread dragToPlate=new Thread();
	private final int DELAY = 20;
	private ArrayList<String> picturesToDrag=new ArrayList<String>();
	//i was thinking about having a string that was 
	//meat, grains or fruits that said which it should be ???? not sure yet
	private String type;
	private Image bkgd;
	final JPanel jp = new JPanel();
	JPanel jp2 = new JPanel();
	private int countTheCows=0;
	private JTextArea countCows=new JTextArea("00");

	
	public ScreenWithDraw(String foodType){
		type = foodType;
		init();
	}
	
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
//		try{
//
//
//			bkgd = ImageIO.read(new File("background.jpg"));
//			Dimension size = new Dimension(bkgd.getWidth(null), bkgd.getHeight(null));
//			setPreferredSize(size);
//			setMinimumSize(size);
//			setMaximumSize(size);
//			setSize(size);
//			setLayout(null);
//			
//		}catch(IOException error){
//
//
//		}
		{
			addNotify();

			jp.setBackground(Color.white);
		
			jp2.setBackground(Color.white);
			jp2.setLayout(new BoxLayout(jp2, BoxLayout.Y_AXIS));
			jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));

			jp.setPreferredSize(new Dimension(350,600));
			jp2.setPreferredSize(new Dimension(350,600));

			// add images to be clicked on
			final ImageIcon chickenIcon = new ImageIcon("smallChicken.jpg");
			final ImageIcon lambIcon = new ImageIcon("lamb.jpeg");
			final ImageIcon beefIcon = new ImageIcon("cow.jpg");

			final JButton chickenButton = new JButton();
			final JButton lambButton = new JButton();
			final JButton cowButton = new JButton();

			final JButton newChickenButton = new JButton();
			final JButton newLambButton = new JButton();
			final JButton newCowButton = new JButton();
			
			//when am image is clicked, update the appropriate variables
			//and change the icons accordingly
			
			cowButton.setIcon(beefIcon);
			lambButton.setIcon(lambIcon);
			chickenButton.setIcon(chickenIcon);
			newCowButton.setIcon(beefIcon);
			newLambButton.setIcon(lambIcon);
			newChickenButton.setIcon(chickenIcon);
			
			jp2.add(chickenButton);
			jp2.add(lambButton);
			jp2.add(cowButton);
			
			cowButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					jp.add(newCowButton);				
					jp2.add(cowButton);
					countTheCows++;
					remove(countCows);
					countCows=new JTextArea(String.valueOf(countTheCows));
					jp.add(countCows);

					validate();
					currentUser.getFootPrint().setServingOfBeef(1);
					
					repaint();

				}
			});

			chickenButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					
					
					jp.add(newChickenButton);
					jp2.add(chickenButton);
					validate();
					currentUser.getFootPrint().setServingOfChicken(1);
					
					repaint();
				}
			});

			lambButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					
					
					jp.add(newLambButton);
					jp2.add(lambButton);
					validate();
					currentUser.getFootPrint().setServingOfLamb(1);
					
					repaint();
				}
			});
    }
	class DragMouseAdapter extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            JComponent c = (JComponent) e.getSource();
            TransferHandler handler = c.getTransferHandler();
            handler.exportAsDrag(c, e, TransferHandler.COPY);
        }
    }

	add(jp2, BorderLayout.WEST);
	add(jp, BorderLayout.EAST);
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
				g.drawImage(bkgd, 0,0, null);
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
