package Water;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

class WelcomeScreen extends JPanel
{
	private String welcomeText = "Welcome to Help2Out, a water footprint calculator!";

	private static final String CARD_JBUTTON =  "Card JButton";
	private ActionListener action;

	Image bkgd;

	private void init() 
	{    
		try{
			JLabel aboutText=new JLabel(welcomeText);
			add(aboutText);

			bkgd = ImageIO.read(new File("background.jpg"));
			Dimension size = new Dimension(bkgd.getWidth(null), bkgd.getHeight(null));
			setPreferredSize(size);
			setMinimumSize(size);
			setMaximumSize(size);
			setSize(size);
			setLayout(null);

		}catch(IOException error){


		}

		//	JTabbedPane tabs = new JTabbedPane();
		//	
		//	AboutScreen welcomeScreen = new AboutScreen();
		//	
		//	add(welcomeScreen);
		//	
		//	tabs.addTab("about", welcomeScreen);
		//
		//	add(tabs, BorderLayout.CENTER);
		//    
		//
		//    

	}

	public void paintComponent(Graphics g){

		g.drawImage(bkgd, 0,0, null);

	}
}













