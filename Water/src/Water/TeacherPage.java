package Water;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * A page that teachers can go to it and 
 * read about the program and decide how to 
 * use it in a classroom.
 * @author Sand
 *
 */
public class TeacherPage extends JPanel{

	
	private static final String CARD_JBUTTON =  "Card JButton";
    private ActionListener action; 
    Image bkgd;
    private String aboutText="This is where we would write how a teacher would use this calculator.";
	
	public TeacherPage()
	{
		init();
	}
	
	public void init()
	{
		
		setLayout(new GridLayout(2, 2));
		
		//Just write something and then put it here
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
			int fontSize = 20; 
			g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize)); 
			g.drawString(aboutText, 10, 20); 
	    	
	    }
}
