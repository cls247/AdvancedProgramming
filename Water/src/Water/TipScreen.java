package Water;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//I'm assuming this is the one for the final recommendation tip screen
public class TipScreen extends JPanel implements Global{
	
	FootPrint aFootPrint = currentUser.getFootPrint();
	double waterUsed;
	JTextField tip=new JTextField();
	Tips waterTip;
	private Image bkgd;
	
	public TipScreen()
	{
		init();
	
		updateTotal();
		
		add(tip);
		
	}
	public void updateTotal()
	{
		waterUsed=aFootPrint.getTotalAmountOfWater();
		calculateFootPrint();
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
		setLayout(new GridLayout(2, 2));
	}
	
	public void calculateFootPrint(){
		
		//this is just a temporary tip display
		if((waterUsed >=0) && (waterUsed <=100)){
			
			tip=new JTextField("You used "+ String.valueOf(waterUsed) +" liters of water. You used a regular amount of water."+
			"In addition, " );/*+ waterTip.getTip(aFootPrint.getBottle().getCurrentBottle())+
			currentUser.getFootPrint().Tips());*/
			
		}else{
			
			tip=new JTextField("You used an abnormal amount of water."+
			"In addition, ");/* + waterTip.getTip(aFootPrint.getBottle().getCurrentBottle())+
			currentUser.getFootPrint().Tips());*/
			
		}
		
		
	}
	public void paintComponent(Graphics g){
	
		System.out.println("painting");
		updateTotal();
		remove(tip);
		tip=new JTextField("You used "+ String.valueOf(waterUsed) +" liters of water. You used a regular amount of water."+
				"In addition, " );
		add(tip);
		g.drawImage(bkgd, 0,0, null);

		}

}
