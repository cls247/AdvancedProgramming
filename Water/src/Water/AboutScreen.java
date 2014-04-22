package Water;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AboutScreen extends JPanel {

	private Image bkgd;
    private static final String CARD_JBUTTON =  "Card JButton";
    private String aboutText = "Over-consumption "
    		+ "of water is an ongoing problem and causes a \n huge strain on our environment and "
    		+ "resources.\n You can use this program to calculate your personal water footprint, \n"
    		+ "learn how to decrease your impact, and "
    		+ "track your progress over time.\n"
    		+"Over-consumption of water is a common problem among Americans, \n "
    		+ "and indeed all world citizens, that is creating a strain on the \n"
    		+ "environment. There are many different habits of the average American\n"
    		+ "that contribute to this dangerous trend, and many of them are rather\n"
    		+ "unknown and not immediately obvious, which contributes to the general\n"
    		+"ignorance about this problem. Education and raising awareness about this\n"
    		+ "issue are important in order to begin to combat it and change the current trends.\n"
    		+ "This program educates users about different sources of water consumption, from\n"
    		+"obvious ones non-reusable water bottles to more discrete ones like meat and grain\n"
    		+"consumption. The user is guided through a series of screens that prompt them to \n"
    		+"fill in the amount of water they consume by way of these different means. \n"
    		+"Their responses are stored and their total water consumption is calculated. \n"
    		+"At the end, the user is told how their personal consumption compares with the \n"
    		+"recommended consumption amount and they are presented with a personalized list of \n"
    		+"recommendations and tips to reduce their water footprint.";
    
	public AboutScreen()
	{
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
	}
public void paintComponent(Graphics g){

		
		g.drawImage(bkgd, 0,0, null);
		Dimension d = this.getPreferredSize(); 
		int fontSize = 15; 
		g.setFont(new Font("Helvetica Neue", Font.PLAIN, fontSize)); 
		
		int x = 100;
		int y = 50;
		
//		for (String line: aboutText.split("\n")){
//			
//			g.drawString(line, x += g.getFontMetrics().getHeight(), 200);
//			
//		}
//		
		for (String line : aboutText.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());


		
//		g.drawString(aboutText, 10, 200); 
//		
//		}

	}
}
