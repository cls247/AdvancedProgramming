package Water;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This is just the Welcome screen that is the first screen
 * that is shown. It welcomes the user and has buttons to 
 * Maneuver throughout the program. 
 * @author Sand
 *
 */
class StartScreen extends JPanel
{
	private String welcomeText = "Welcome to Help2Out, a water footprint calculator!";

	Image bkgd;


	public StartScreen()
	{
		init();
	}
	private void init() 
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
		int fontSize = 20; 
		g.setFont(new Font("Helvetica Neue", Font.PLAIN, fontSize)); 
		g.drawString(welcomeText, 10, 200); 
		}

	}



