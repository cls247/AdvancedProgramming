package Water;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * Despite the name, this is not a class. It is actually the driver of all the classes.
 * The name will change eventually.
 * This class sets up all the tabs for the project and allows the user to flip
 * through all of the tabs. It creates an instance of a class for every screen
 * that is to be shown. 
 *
 *
 */
public class ScreenDriver extends JApplet
{
	//create all the screens that are going to be tabs
	//from the first page
	
	private CardDriver welcomeScreen;
	private TeacherPage teacherScreen;
	private AboutScreen aboutScreen;
	private AllTipScreen tips;
	
	public void addComponentToPane(Container pane){
		
		JTabbedPane tabs = new JTabbedPane();
		
		//create all of the first couple of screens
		welcomeScreen = new CardDriver();
		teacherScreen = new TeacherPage();
		aboutScreen=new AboutScreen();
		tips=new AllTipScreen();
		
		//add all the screens to the card layout
		pane.add(welcomeScreen);
		pane.add(teacherScreen);
		pane.add(aboutScreen);
		pane.add(tips);
		
		//make tabs for all of the screen so that we can flip between them.
		tabs.addTab("Home", welcomeScreen);
		tabs.addTab("Teacher", teacherScreen);
		tabs.addTab("About", aboutScreen);
		tabs.addTab("Tips", tips);

		pane.add(tabs, BorderLayout.CENTER);
		
	}
	
	/**
	 * createAndShowGUI()
	 * 
	 * This method sets up the JFrame in order to show the GUI to the user.
	 * 
	 */
	private void createAndShowGUI()
	{
		
		setSize(new Dimension(830, 660));
		
		JPanel pane = new JPanel();
		JTabbedPane tabs = new JTabbedPane();
		
		//create all of the first couple of screens
		welcomeScreen = new CardDriver();
		teacherScreen = new TeacherPage();
		aboutScreen=new AboutScreen();
		tips=new AllTipScreen();
		
		//add all the screens to the card layout
		pane.add(welcomeScreen);
		pane.add(teacherScreen);
		pane.add(aboutScreen);
		pane.add(tips);
		
		//make tabs for all of the screen so that we can flip between them.
		tabs.addTab("Home", welcomeScreen);
		tabs.addTab("Teacher", teacherScreen);
		tabs.addTab("About", aboutScreen);
		tabs.addTab("Tips", tips);

		pane.add(tabs, BorderLayout.CENTER);
		
		setContentPane(pane);

	}

	/**
	 * main(String[] args)
	 * 
	 * This method just runs and shows the GUI
	 * @param args
	 */
	
	public void init(){
		
		createAndShowGUI();
		
	}


} 
