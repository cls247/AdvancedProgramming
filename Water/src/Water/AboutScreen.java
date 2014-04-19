package Water;

import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JPanel;

public class AboutScreen extends JPanel {

	public AboutScreen()
	{
		init();
	}
	public void init()
	{
		//Just write something and then put it here
		TextField about=new TextField();
		add(about);
		setLayout(new GridLayout(2, 2));
	}
}
