package Water;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This is the final screen that the user will
 * see after they input all their information.
 * It should print out the total amount of water that is input
 * and specific tips for the user based on what they input.
 * 
 * @author Sand
 *
 */
public class TipScreen extends JPanel implements Global, Screen, Runnable{
	
	private double waterUsed;
	private JTextArea tip=new JTextArea();
	private Image bkgd;
	private User currentUser=new User();
	private final int DELAY = 20;
	private Thread thread;
	
	public TipScreen()
	{
		init();
		setLayout(null);
		updateTotal();
		tip.setBounds(150, 150, 400, 400);
		add(tip);
		
	}
	public void updateTotal()
	{
		waterUsed=currentUser.getFootPrint().getTotalAmountOfWater();
		calculateFootPrint();
		
	}
	
	@Override
	public void init()
	{
		try{


			bkgd = ImageIO.read(new File("background.jpg"));
			Dimension size = new Dimension(bkgd.getWidth(null), bkgd.getHeight(null));
			setPreferredSize(size);
			setMinimumSize(size);
			setMaximumSize(size);
			setSize(size);
			//setLayout(null);
			
		}catch(IOException error){


		}
		
		setLayout(new FlowLayout());
		thread = new Thread(this);
		thread.start();
	}
	
	public void calculateFootPrint(){
		
		//this is just a temporary tip display
		if((waterUsed >=0) && (waterUsed <=10000)){
			
			tip.setText("You used "+ String.valueOf(waterUsed) +" liters of water. \nYou used a regular amount of water."+
			"In addition, \n"+ currentUser.getFootPrint().Tips());
			tip.setWrapStyleWord(true);
			
		}else{
			
			tip.setText("You used an abnormal amount of water."+
			"In addition, \n" +currentUser.getFootPrint().Tips());
			tip.setWrapStyleWord(true);
			
		}
		
		
	}
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		g.drawImage(bkgd, 0,0, null);
//		System.out.println("painting");
		updateTotal();
//		remove(tip);
		System.out.println(waterUsed);
//		tip.setText("You used "+ waterUsed +" liters of water. You used a regular amount of water."+
//				"Also" );
//		add(tip);

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
		currentUser=setCurrentUser;
		
	}

}
