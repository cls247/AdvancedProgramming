package Water;

import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JPanel;
import javax.swing.JTextArea;

//I'm assuming this is the one for the final recommendation tip screen
public class TipScreen extends JPanel implements Global{
	
	FootPrint aFootPrint = currentUser.getFootPrint();
	double waterUsed;
	TextArea tip=new TextArea();
	Tips waterTip;
	
	public TipScreen()
	{
		init();
	
		waterUsed = currentUser.getFootPrint().getTotalAmountOfWater();
		
		calculateFootPrint();
		
		add(tip);
		
	}
	public void init()
	{
		setLayout(new GridLayout(2, 2));
	}
	
	public void calculateFootPrint(){
		
		//this is just a temporary tip display
		if((waterUsed >=0) && (waterUsed <=100)){
			
			tip=new TextArea("You used "+ String.valueOf(waterUsed) +" liters of water. You used a regular amount of water."+
			"In addition, " );/*+ waterTip.getTip(aFootPrint.getBottle().getCurrentBottle())+
			currentUser.getFootPrint().Tips());*/
			
		}else{
			
			tip=new TextArea("You used an abnormal amount of water."+
			"In addition, ");/* + waterTip.getTip(aFootPrint.getBottle().getCurrentBottle())+
			currentUser.getFootPrint().Tips());*/
			
		}
		
		
	}

}
