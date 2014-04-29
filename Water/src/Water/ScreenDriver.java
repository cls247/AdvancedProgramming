// 
// Project 4 
// Name: Victoria Chai, Sophia Kleyman, Nicholas DeLessio, Christopher Zawora, Casandra Schwartz
// E-mail: vjc22@georgetown.edu, sk1336@georgetown.edu, ncd26@georgetown.edu, caz25@georgetown.edu, cls247@georgetown.edu 
// Instructor: Singh 
// COSC 150 
// 
// In accordance with the class policies and Georgetown's Honor Code, 
// I certify that, with the exceptions of the lecture notes and those 
// items noted below, I have neither given nor received any assistance 
// on this project. 
// 
// Description: "Over-consumption of water is an ongoing problem that causes a huge strain on our 
// environment and resources. This program calculates your personal water footprint and learn how
// to decrease your impact. The over-consumption of water is a common problem among Americans, and
// indeed all world citizens, that is actively negatively impacting the environment and the world water
// supply. There are many different habits of the average American that contribute to this dangerous trend,
// and many of them are rather unknown and not immediately obvious, which contributes to the general
//ignorance about this problem. Education and raising awareness about this issue are important in order
// to begin to combat it and change the current trends. This program educates users about different
// sources of water consumption, from obvious ones, like using reusable water bottles instead of plastic bottles, to
// more discrete ones like meat and grain consumption. The user is guided through a series of screens that prompt
// them to fill in the amount of water they consume by way of these different means. Their responses are stored
// and their total water consumption is calculated. At the end, the user is told how their personal
// consumption compares with the recommended consumption amount and they are presented with a personalized
// list of recommendations and tips to reduce their water footprint. 
//

package Water;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * Despite the name, this is not a class. It is actually the driver of all the
 * classes. The name will change eventually. This class sets up all the tabs for
 * the project and allows the user to flip through all of the tabs. It creates
 * an instance of a class for every screen that is to be shown.
 * 
 * 
 */
public class ScreenDriver extends JApplet {
	// create all the screens that are going to be tabs
	// from the first page

	private CardDriver welcomeScreen;
	private TeacherPage teacherScreen;
	private AboutScreen aboutScreen;
	private AllTipScreen tips;

	public void addComponentToPane(Container pane) {

		JTabbedPane tabs = new JTabbedPane();

		// create all of the first couple of screens
		welcomeScreen = new CardDriver();
		teacherScreen = new TeacherPage();
		aboutScreen = new AboutScreen();
		tips = new AllTipScreen();

		// add all the screens to the card layout
		pane.add(welcomeScreen);
		pane.add(teacherScreen);
		pane.add(aboutScreen);
		pane.add(tips);

		// make tabs for all of the screen so that we can flip between them.
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
	private void createAndShowGUI() {

		setSize(new Dimension(830, 660));

		JPanel pane = new JPanel();
		JTabbedPane tabs = new JTabbedPane();

		// create all of the first couple of screens
		welcomeScreen = new CardDriver();
		teacherScreen = new TeacherPage();
		aboutScreen = new AboutScreen();
		tips = new AllTipScreen();

		// add all the screens to the card layout
		pane.add(welcomeScreen);
		pane.add(teacherScreen);
		pane.add(aboutScreen);
		pane.add(tips);

		// make tabs for all of the screen so that we can flip between them.
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
	 * 
	 * @param args
	 */

	public void init() {

		createAndShowGUI();

	}

	public CardDriver getWelcomeScreen() {

		return welcomeScreen;

	}

	public TeacherPage getTeacherScreen() {

		return teacherScreen;

	}

	public AboutScreen getAboutScreen() {

		return aboutScreen;

	}

	public AllTipScreen getAllTipScreen() {

		return tips;

	}
}
