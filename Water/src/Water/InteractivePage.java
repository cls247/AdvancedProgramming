package Water;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.logging.Handler;

import javax.swing.JPanel;

//so this is like supposed to on a thread, but I'm not positive how to do that
//I think that I got it pretty close
//*************I totally forgot about the slider class so we can totally use that here
public class InteractivePage extends JPanel implements Runnable, MouseListener{

	private Rectangle bar = new Rectangle(50, 100, 200, 100);
	private Thread graphs;
	private MouseListener m;
	private final int DELAY = 20;
	private boolean clicked=false;
	private int x=20, y=20, height=100, width=100;
	//there should be a temporary food print in order to 
	//keep updating the footprint according to the bars that change
	FootPrint temporaryFootPrint=new FootPrint();
	
	public InteractivePage()
	{
		init();
	}	
	
	public void init()
	{
		//add a mouse listener to the rectangle
		addMouseListener(this);
		setLayout(new GridLayout(2, 2));	
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
		graphs = new Thread(this);
		graphs.start();
	} 
	
	@Override
	public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//paint the rectangle
			g.drawRect(x,y,height, width);

	}
	
	
	@Override
	public void run() {

		//************
		//below here is just the stuff to create a thread and have it move smoothly
		
		long beforeTime, timeDiff, timeSleep;
		beforeTime = System.currentTimeMillis();


		while (true) {

			if(clicked)
			{
					//here we need to make the bar rise with the mouse
					x--;
					y--;
					//also here check to see if the bar grew enough to get to the next integer
			}
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse was clicked");
		clicked=true;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse pressed");
		clicked=true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse released");
		clicked=false;
	}
}


