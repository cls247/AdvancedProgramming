package Water;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

//I'm assuming this is the one for the final recommendation tip screen
public class TipScreen extends JPanel{
	
	FootPrint aFootPrint = new FootPrint();
	int waterUsed;
	JTextArea tip;
	Tips waterTip;
	
	public TipScreen()
	{
		init();
		
		//how are we passing the footprint?
		waterUsed = aFootPrint.getTotalAmountOfWater();
		
		calculateFootPrint();
		
		//add the tip to the screen
		add(tip);
		
	}
	public void init()
	{
		setLayout(new GridLayout(2, 2));
	}
	
	public void calculateFootPrint(){
		
		//this is just a temporary tip display
		if((waterUsed >=0) && (waterUsed <=100)){
			
			tip.setText("You used a regular amount of water.");
			tip.append("In addition, " + waterTip.getTip(aFootPrint.getBottle().getCurrentBottle()));
			
		}else{
			
			tip.setText("You used an abnormal amount of water.");
			tip.append("In addition, " + waterTip.getTip(aFootPrint.getBottle().getCurrentBottle()));
			
		}
		
	}

}
