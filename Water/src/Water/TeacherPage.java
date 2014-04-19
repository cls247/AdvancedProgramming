package Water;

import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JPanel;

/**
 * A page that teachers can go to it and 
 * read about the program and decide how to 
 * use it in a classroom.
 * @author Sand
 *
 */
public class TeacherPage extends JPanel{

	public TeacherPage()
	{
		init();
	}
	
	public void init()
	{
		setLayout(new GridLayout(2, 2));
		
		//Just write something and then put it here
		TextField about=new TextField();
		add(about);
	}
}
