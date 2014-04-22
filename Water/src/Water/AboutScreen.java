package Water;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutScreen extends JPanel {

    private static final String CARD_JBUTTON =  "Card JButton";
    private String aboutText = "Welcome to the Water Footprint Calculator! \n Over-consumption "
    		+ "of water is an ongoing problem and causes a \n huge strain on our environment and "
    		+ "resources.\n You can use this program to calculate your <br> personal water footprint, "
    		+ "learn how to decrease your impact, and \n"
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
		
		//Just write something and then put it here
		JLabel about=new JLabel(aboutText);
		add(about);
		setLayout(new GridLayout(2, 2));		
	}
}
