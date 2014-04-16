package Water;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class WelcomeScreen extends JPanel
{
	private ActionListener action;
	private Image im;

	public WelcomeScreen() 
	{
		init();
	}

	private void init() 
	{        
		ImageIcon welcomeImage=new ImageIcon("/Users/Sand/Documents/workspace/BallGame2/instructions.png");
		im=welcomeImage.getImage();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(im, 0, 0, null);           
	}
	

}