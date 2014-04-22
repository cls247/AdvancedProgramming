package Water;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

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
	private Image bkgd;
	
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
		try{


			bkgd = ImageIO.read(new File("background.jpg"));
			Dimension size = new Dimension(bkgd.getWidth(null), bkgd.getHeight(null));
			setPreferredSize(size);
			setMinimumSize(size);
			setMaximumSize(size);
			setSize(size);
			setLayout(null);
			
		}catch(IOException error){


		}
		addNotify();
				
       JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 15));
       
       ImageIcon meatIcon = new ImageIcon("cow.png");
       JButton meatButton = new JButton(meatIcon);

		panel.add(meatButton);
		
		add(panel);
       /* ImageIcon icon1 = new ImageIcon("smallplate.png");
        ImageIcon icon2 = new ImageIcon("smallplate.png");
        ImageIcon icon3 = new ImageIcon("water3.jpg");

        DropTarget button = new DropTarget();
   //     button.setFocusable(false);
        
       // panel.setDropTarget(button);

        JLabel label1  = new JLabel(icon1, JLabel.CENTER);
        JLabel label2  = new JLabel(icon3, JLabel.CENTER);
        label2.setSize(100, 100);

        MouseListener listener = new DragMouseAdapter();
        label1.addMouseListener(listener);
        label2.addMouseListener(listener);

        label1.setTransferHandler(new TransferHandler("icon"));
       // button.setTransferHandler(new TransferHandler("icon"));
        label2.setTransferHandler(new TransferHandler("icon"));

        panel.add(label1);
        panel.add(button);
        panel.add(label2);
        add(panel);*/

    }
	class DragMouseAdapter extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            JComponent c = (JComponent) e.getSource();
            TransferHandler handler = c.getTransferHandler();
            handler.exportAsDrag(c, e, TransferHandler.COPY);
        }
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
