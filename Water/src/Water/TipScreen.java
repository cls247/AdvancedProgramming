package Water;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * This is the final screen that the user will
 * see after they input all their information.
 * It should print out the total amount of water that is input
 * and specific tips for the user based on what they input.
 * 
 * @author Sand
 *
 */
public class TipScreen extends JPanel implements Screen, Runnable{
	
	private double waterUsed;
	private JTextArea tip=new JTextArea();
	// image for the background
	private Image bkgd;
	//the user that is being updated
	private User currentUser=new User();
	//set delay for the thread
	private final int DELAY = 20;
	private Thread thread;
	private JPanel contentPanel;
	private JScrollPane sliderScrollPane;
	
    /**
	 * TipScreen()
	 *
	 * This sets the default details of teh screen
	 */
	public TipScreen()
	{
		init();
		setLayout(null);
		updateTotal();
		
		tip.setBounds(0, 150, 800, 200);
		tip.setWrapStyleWord(true);
		
	}
    
    /**
	 * updateTotal()
	 * This method gets the current water total.
	 */
	public void updateTotal()
	{
		waterUsed=currentUser.getFootPrint().getTotalAmountOfWater();
		
        setTipsString();
        //calculateFootPrint();
		
	}
	
	@Override
	public void init()
	{
		createContentPanels();
		startThread();
        
        /* setLayout(new FlowLayout());
         drawBackground();
         thread = new Thread(this);
         thread.start();
         */
	}
	private void startThread() {
		thread = new Thread(this);
		thread.start();
	}
	private void createContentPanels() {
		try{


			bkgd = ImageIO.read(new File("background.jpg"));
			Dimension backgroundSize = new Dimension(bkgd.getWidth(null), bkgd.getHeight(null));
			setPreferredSize(backgroundSize);
			setMinimumSize(backgroundSize);
			setMaximumSize(backgroundSize);
			setSize(backgroundSize);
			contentPanel = new JPanel();
			contentPanel.setVisible(true);
			contentPanel.setBounds(0, 150, 800, 200);
			contentPanel.setBackground(Color.white);
			
			sliderScrollPane = new JScrollPane(contentPanel);
			sliderScrollPane.setBackground(Color.white);
			sliderScrollPane.setVisible(true);
			sliderScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			sliderScrollPane.setBounds(0, 150, 800, 200);
			contentPanel.add(tip);
			add(sliderScrollPane);
	
			
		}catch(IOException error){


		}
		
		setLayout(new FlowLayout());
	}
	
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		g.drawImage(bkgd, 0,0, null);
		updateTotal();
		System.out.println(waterUsed);

		}
	@Override
	public void run() {
		long beforeTime, timeDiff, timeSleep;
		beforeTime = System.currentTimeMillis();


		while (true) {
			repaint();
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
	public User passOnUser() {
		
		return currentUser;
	}
	@Override
	public void receiveUser(User setCurrentUser) {
		setTipsString();
		currentUser=setCurrentUser;
		
	}
	
	public void setTipsString(){
		
		if((waterUsed >=0) && (waterUsed <=10000)){
			
			tip.setText("You used "+ String.valueOf(waterUsed) +" liters of water. \nYou used a regular amount of water."+
			"\nIn addition: \n"+ currentUser.getFootPrint().Tips());
			tip.setWrapStyleWord(true);
			
		}else{
			
			tip.setText("You used an abnormal amount of water."+
			"\nIn addition: \n" +currentUser.getFootPrint().Tips());
			tip.setWrapStyleWord(true);
		
	}
	
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
