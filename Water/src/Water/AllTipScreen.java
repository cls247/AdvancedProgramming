package Water;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 
 * This is the screen where the user can read a conclomeration
 * of a bunch of different tips for saving water.
 * The tips are divided into categories based on their category.
 * @author Sand
 *
 */
public class AllTipScreen extends JPanel {

	/**
	 * This is the string that will be populated with all the tips to be printed
	 */
	private String tipsString="";
	
	/**
	 * This is the image that will be the background
	 */
	private Image bkgd;
	
	/**
	 * AllTipScreen()
	 * 
	 * This constructor calls init() to set up the screen
	 */
	public AllTipScreen()
	{
		init();
	}
	
	/**
	 * init()
	 * 
	 * This method sets the background image of the screen and 
	 * populates the string with all the tips to be printed. 
	 */
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
		populateTips();
		JLabel tips=new JLabel(tipsString);
		add(tips);
		
		
	}
	/**
	 * populateTips()
	 * 
	 * This method simply populates the string with all the 
	 * different tips that are to be printed. 
	 */
	private void populateTips()
	{
		tipsString+="Water Consumption\n"
		+"Consider using recycable water bottles and refilling them. \n"
		+"Water Conservation Around the House\n"
		+"Make sure you turn of the water when not using it. \n"
		+"Make sure no sinks or water sources have leaks. \n"
		+"Water Consumption while cleaning\n"
		+"Washing dishes with a dishwasher saves more water than washing dishes by hand.\n"
		+"Scrap excess food off of dishes instead of rinsing them before putting them in dish washer \n"
		+"Collect water from washing fruit to water household plants\n"
		+"Make sure you use water efficient appliances.\n"
		+"Make sure you check outside faucets for leaks\n"
		+"Washing dark colored clothes in cold water helps to save water \n"
		+"Start a compose pile instead of putting food down the sink \n"
		+"If washing dishes by hand, don't let the water run. Fill a basin with water instead."
		+"Hygiene\n"
		+"Moderate length showers save more water than baths \n"
		+"Don't fill bathtubs to the tops with water to reduce splashing\n"
		+"Lawn\n"
		+"Water dry spots on your lawn by hand instead of using a sprinkler system. \n"
		+"Only water your lawn when it is absolutely necessary. \n" 
		+"Don't water your lawn on windy days\n"
		+"Put used ice cubes into plants to reuse water \n"
		+"Collect rain water and use it to water lawns and garden\n"
		+"Wash you pets outside on the lawn to get extra use from your water \n"
		+"Put a minumum amount of fertilizer down because fertilizer increases water consumption. \n "
		+"Lawns can go a lot longer without water than you thing.\n"
		+"Use water calculators like this one to track your water each month!\n";
		
				
	}
	
	/**
	 * paintComponent(Graphics g)
	 * 
	 * This method draws an image as the background and prints the text for the 
	 * tips with proper formatting (spacing between lines).
	 * 
	 * @param g this is the Graphics screen that the images will be passed to 
	 */
	public void paintComponent(Graphics g){

		
		g.drawImage(bkgd, 0,0, null);
		Dimension d = this.getPreferredSize(); 
		int fontSize = 12; 
		g.setFont(new Font("Helvetica Neue", Font.PLAIN, fontSize)); 
		
		
		int x = 150;
		int y = 50;
		
//		for (String line: aboutText.split("\n")){
//			
//			g.drawString(line, x += g.getFontMetrics().getHeight(), 200);
//			
//		}
//		
		for (String line : tipsString.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
		
//		g.drawString(tipsString, 10, 20); 

		}
}
