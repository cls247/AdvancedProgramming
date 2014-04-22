package Water;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.TextField;
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

	private Thread graphs;
	private MouseListener m;
	private final int DELAY = 20;
	private boolean clicked=false;
	private int meatX=20, meatY=60, meatHeight=100, meatWidth=100;
	//there should be a temporary food print in order to 
	//keep updating the footprint according to the bars that change
	FootPrint temporaryFootPrint=new FootPrint();
	Rectangle meatBar=new Rectangle(meatX, meatY, meatWidth, meatHeight);
	private int mouseX, mouseY;
	private Point mousePoint;
	double sliderForFootPrint;
	int sliderForWaterBottles=0;
	int sliderForNumberOfTimesDoesDishes=0;
	int sliderForServingOfBeef=0;
	int sliderForServingOfChicken=0;
	int sliderForServingOfCorn=0;
	int sliderForNumberOfWashes=0;
	int sliderForNumberOfLoadsOfClothes=0;
	TextField total=new TextField();
	
	double amountWaterUsed = 0;
	
	double currentWaterLevel = temporaryFootPrint.getBottle().getWaterLevel();
	
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
	
	public void whatIfAnalysis(){
		
		//new values to be used in calculation
		sliderForFootPrint = 0; //this should somehow get the value off the slider
		temporaryFootPrint.getBottle().setWaterBottle(sliderForFootPrint);
		
		sliderForWaterBottles = 0; //this should get the value off the slider
		temporaryFootPrint.setNumberOfWaterBottles(sliderForWaterBottles);
		
		sliderForNumberOfTimesDoesDishes=0; //this should get the value off the slider
		temporaryFootPrint.setNumberOfTimesDoesDishes(sliderForNumberOfTimesDoesDishes);
		
		sliderForServingOfBeef=0; //this should get the value off the slider
		temporaryFootPrint.setServingOfBeef(sliderForServingOfBeef);
		
		sliderForServingOfChicken=0; //this should get the value off the slider
		temporaryFootPrint.setServingOfChicken(sliderForServingOfChicken);
		
		sliderForServingOfCorn=0; //this should get the value off the slider
		temporaryFootPrint.setServingOfCorn(sliderForServingOfCorn);
		
		sliderForNumberOfWashes=0; //this should get the value off the slider
		temporaryFootPrint.setNumberOfWashes(sliderForNumberOfWashes);
		
		sliderForNumberOfLoadsOfClothes=0; //this should get the value off the slider
		temporaryFootPrint.setNumberOfLoadsOfClothes(sliderForNumberOfLoadsOfClothes);
		
		temporaryFootPrint.updateTotalAmountOfWater();
		
		amountWaterUsed = temporaryFootPrint.getTotalAmountOfWater();
		
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
			Graphics2D graphicsObject2d = (Graphics2D) g;
			graphicsObject2d.draw(meatBar);

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
					if(meatBar.contains(new Point(mouseX,mouseY)));
					{
						System.out.println("this contains");
						total.setText(String.valueOf(amountWaterUsed));
						//here we need to make the bar rise with the mouse
						meatBar=new Rectangle(meatX, --meatY, meatWidth, ++meatHeight);
						//also here check to see if the bar grew enough to get to the next integer
					
						//run the what if analysis if anything has been changed-i'm not quite sure where
						//this should go
						whatIfAnalysis();
					}
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
		clicked=true;
		mouseX=e.getX();
		System.out.println(mouseX);
		System.out.println(mouseY);
		mouseY=e.getY();
		mousePoint=new Point(mouseX, mouseY);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		clicked=false;
	}
}


