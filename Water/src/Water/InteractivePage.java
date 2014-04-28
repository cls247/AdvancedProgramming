package Water;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class has a bunch of sliders for each or the data that should be 
 * entered into a footprint. It ten updates a running total of the amount
 * of water that would be used based on the input from the sliders.
 * We will add a water bottle that will increase the water level based on 
 * the total amount of water that the user would use if they followed the input
 * from the sliders. 
 * 
 * @author Sand
 *
 */

public class InteractivePage extends JPanel implements Screen{
	

	//there should be a temporary food print in order to 
	//keep updating the footprint according to the bars that change
	
	private JPanel topPanel = new JPanel();
	private JPanel sliderPanel = new JPanel();

	
	//user received from the previous page and the water footprint associated with it
	private FootPrint currentFootPrint = new FootPrint();
	private User currentUser = new User();
	
	//add text areas for each slider to display the total
	//for that slider
	private JLabel textTotal1=new JLabel();
	private JLabel textTotal2=new JLabel();
	private JLabel textTotal3=new JLabel();
	private JLabel textTotal4=new JLabel();
	private JLabel textTotal5=new JLabel();
	private JLabel textTotal6=new JLabel();
	private JLabel textTotal7=new JLabel();
	private JLabel textTotal8=new JLabel();
	private JLabel textTotal9=new JLabel();
	private JLabel textTotal10=new JLabel();
	private JLabel textTotal11=new JLabel();
	private JLabel textTotal12=new JLabel();
	private JLabel textTotal13=new JLabel();
	
	JLabel[] textTotalArray = {
		textTotal1, textTotal2, textTotal3,
		textTotal4, textTotal5, textTotal6, 
		textTotal7, textTotal8, textTotal9,
		textTotal10, textTotal11, textTotal12,
		textTotal13
	};
	
	//text areas for tracking total water consumption and its status
	private JTextField textWater = new JTextField("00");
	private JLabel consumptionStatus = new JLabel("");

	//labels for each slider
	private JLabel label1 = new JLabel("Water Bottles Used");
	private JLabel label2 = new JLabel("Loads of Clothing");
	private JLabel label3 = new JLabel("Sets of Dishes Washed");
	private JLabel label4 = new JLabel("Number of Baths/Showers");
	private JLabel label5 = new JLabel("Plant Waterings");
	private JLabel label6 = new JLabel("Servings of Beef");
	private JLabel label7 = new JLabel("Servings of Chicken");
	private JLabel label8 = new JLabel("Servings of Lamb");
	private JLabel label9 = new JLabel("Servings of Eggs");
	private JLabel label10 = new JLabel("Servings of Lentils");
	private JLabel label11 = new JLabel("Servings of Pasta");
	private JLabel label12 = new JLabel("Servings of Corn");
	private JLabel label13 = new JLabel("Servings of Green Veggies");
	
	JLabel[] labelArray = {
		label1, label2, label3,
		label4, label5, label6, 
		label7, label8, label9,
		label10, label11, label12,
		label13
	};
	
	//sliders
	final JSlider slider1 = new JSlider();
	final JSlider slider2 = new JSlider();
	final JSlider slider3 = new JSlider();
	final JSlider slider4 = new JSlider();
	final JSlider slider5 = new JSlider();
	final JSlider slider6 = new JSlider();
	final JSlider slider7 = new JSlider();
	final JSlider slider8 = new JSlider();
	final JSlider slider9 = new JSlider();
	final JSlider slider10 = new JSlider();
	final JSlider slider11 = new JSlider();
	final JSlider slider12 = new JSlider();
	final JSlider slider13 = new JSlider();
	
	JSlider[] sliderArray = {
		slider1, slider2, slider3,
		slider4, slider5, slider6,
		slider7, slider8, slider9,
		slider10, slider11, slider12,
		slider13
	};

	//functions for updating the footprint depending on the slider
	String[] setterFunctionArray = {
			"setNumberOfWaterBottles", "setNumberOfLoadsOfClothes", "setNumberOfTimesDoesDishes",
			"setNumberOfWashes", "setNumberOfTimesWaterPlants", "setServingOfBeef",
			"setServingOfChicken", "setServingOfLamb", "setServingOfEggs",
			"setServingOfLentils", "setServingOfPasta", "setServingOfCorn",
			"setServingOfVeggies"
	};
	
	 Class[] argTypes = new Class[] {int.class};
	 
	String[] getterFunctionArray = {
			"getNumberOfWaterBottles", "getNumberOfLoadsOfClothes", "getNumberOfTimesDoesDishes",
			"getNumberOfWashes", "getNumberOfTimesWaterPlants", "getServingOfBeef",
			"getServingOfChicken", "getServingOfLamb", "getServingOfEggs",
			"getServingOfLentils", "getServingOfPasta", "getServingOfCorn",
			"getServingOfVeggies"
	};
	
	//this is the background image
	private Image bkgd;
	
	/**
	 * starts the interactive page	
	 */
	public InteractivePage()
	{
		init();		
	}		
	
	/**
	 * initializes and adds the panels to the page
	 */
	public void init()
	{
		//set the background image
		drawBackground();
		
		//set the layout of the screen
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	
		//initialize the top panel
		Dimension topPanelSize = new Dimension(500,150);
		topPanel.setPreferredSize(topPanelSize);
		topPanel.setMinimumSize(topPanelSize);
		topPanel.setMaximumSize(topPanelSize);
		topPanel.setSize(topPanelSize);
		topPanel.setLayout(new GridLayout(4,1));
		topPanel.setBackground(Color.WHITE);
		
		//initialize the slider panel
		Dimension jpSize = new Dimension(500,500);
		sliderPanel.setPreferredSize(jpSize);
		sliderPanel.setMinimumSize(jpSize);
		sliderPanel.setMaximumSize(jpSize);
		sliderPanel.setSize(jpSize);
		sliderPanel.setLayout(new GridLayout(15,3));			

		//add the labels for displaying the total amount of water used
		topPanel.add(new JLabel("<html><p text-align:center>TOTAL WATER CONSUMPTION</p></hmtl>"));
		topPanel.add(textWater);
		textWater.setSize(50, 50);
		topPanel.add(consumptionStatus);
		topPanel.add(new JLabel());
		getConsumptionStatus();
		
		//add the sliders to the page
		addSliders();
	}
	
	/**
	 * If the user did not make a selection on one of the previous screens, the program assumes that
	 * they use the least wasteful option
	 */
	public void checkBooleans(){
		System.out.println("checking booleans");
		if (!currentFootPrint.getUsesDishWasher() && !currentFootPrint.getDoesDishesByHand()){
			currentFootPrint.setUsesDishWasher();
		}
		
		if (!currentFootPrint.getHandWashesClothes() && !currentFootPrint.getUsesWashingMachine()){
			currentFootPrint.setHandWashesClothes();
		}
		
		if (!currentFootPrint.getTakesShowers() && !currentFootPrint.getTakesBaths()){
			currentFootPrint.setTakesBaths();
		}
		
		if (!currentFootPrint.getUsesSprinklers() && !currentFootPrint.getHandWaters()){
			currentFootPrint.setHandWaters();
		}
		
		if (!currentFootPrint.getUsesPlasticWaterBottle() && !currentFootPrint.getUsesRecyclableWaterBottle()){
			currentFootPrint.setUsesRecyclableWaterBottle();
		}
	}

	/**
	 * adds rows of sliders to the slider panel
	 */
	public void addSliders(){
		//This is a bunch of sliders that the user can manipulate.
		//When the slider is called, it update the TextAreas and it updates
		//the footprint based on what was input from the user. 
		
		//first row of sliders
		createSliderRow(1, 3);
		//second row of sliders
		createSliderRow(4, 6);
		//third row of sliders
		createSliderRow(7, 9);
		//fourth row of sliders
		createSliderRow(10, 12);
		//fifth row of sliders
		createSliderRow(13, 13);
		
		//scroll pane to make the sliders scrollable
		JScrollPane sliderScrollPane = new JScrollPane(sliderPanel);
		sliderScrollPane.setViewportView(sliderPanel);
		sliderScrollPane.setVisible(true);
		sliderScrollPane.setFocusable(true);
		sliderScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		Dimension scrollSize = new Dimension(100,200);
		sliderScrollPane.setPreferredSize(scrollSize);
		sliderScrollPane.setBackground(Color.WHITE);
		
		//add the top and slider scroll panes to the page
		this.add(topPanel);
		this.add(sliderScrollPane);
	}
	
	/**
	 * creates a row of sliders with associated labels
	 * @param min the beginning index of the row
	 * @param max the ending index of the row
	 */
	public void createSliderRow(int min, int max){
		
		//add labels for displaying the slider name
		for (int i = min - 1; i < max; i++){
			sliderPanel.add(labelArray[i]);
			
			//add any blanks necessary for formatting purposes
			addBlanks(min);
		}
		
		for (int i = min - 1; i < max; i++){
			//get the current slider and its associated text display
			final JSlider currentSlider = sliderArray[i];
			final JLabel currentText = textTotalArray[i];
			
			//add the slider to the slider panel
			sliderPanel.add(currentSlider);
			
			//add change listeners with the appropriate update function depending on the slider
			final int function = i;
			currentSlider.addChangeListener(new ChangeListener(){

				@Override
				public void stateChanged(ChangeEvent e) {
					// change the number of water bottles in the footprint
					//then update the various values on the screen
					try {
						//check that all booleans from previous screens have been checked
						checkBooleans();
						
						currentFootPrint.getClass().getDeclaredMethod(setterFunctionArray[function], argTypes).invoke(currentFootPrint, currentSlider.getValue());
					} catch (IllegalArgumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SecurityException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InvocationTargetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NoSuchMethodException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//update the various displays on the page
					currentText.setText(String.valueOf(currentSlider.getValue()));
					textWater.setText(String.valueOf(currentFootPrint.getTotalAmountOfWater()));
					getConsumptionStatus();
				}
				
			});
			//set some slider prefferences
			currentSlider.setMajorTickSpacing(10); 
			currentSlider.setPaintLabels(true); 
			currentSlider.setPaintTicks(true);
			
			//add any blank panels necessary for formatting
			addBlanks(min);
		}
		
		//add panels for displaying the slider values
		for (int i = min - 1; i < max; i++){
			sliderPanel.add(textTotalArray[i]);
			
			//add any blanks necessary for formatting
			addBlanks(min);
		}
	}
	
	/**
	 * tests to see if blank panels are necessary to keep formatting consistent
	 * @param index the current jslider being added
	 */
	public void addBlanks(int index){
		//if there is an extra row with one slider, add two blank panels
		if (sliderArray.length % 3 == 1 && index == sliderArray.length){
			sliderPanel.add(new JPanel());
			sliderPanel.add(new JPanel());
		}
		
		//if there is an extra row with two sliders, add one blank panel
		if (sliderArray.length % 3 == 2 && index == sliderArray.length){
			sliderPanel.add(new JPanel());
		}
	}
	
	/**
	 * updates the values displayed on the sliders and the labels beneath them
	 */
	public void updateSliders(){
			//updates the sliders whenever a new user profile is passed in 
		
		/*for (int i = 0; i <13; i++){	
			System.out.println("Array Length: " + sliderArray.length);
			System.out.println("i: " + i);
			
			JSlider currentSlider = sliderArray[i];
			JLabel currentText = textTotalArray[i];
			
			try {
				currentSlider.setValue((Integer) currentFootPrint.getClass().getMethod(getterFunctionArray[i], null).invoke(currentFootPrint));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				currentText.setText((String) currentFootPrint.getClass().getMethod(getterFunctionArray[i], null).invoke(currentFootPrint));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
			slider1.setValue(currentFootPrint.getNumberOfWaterBottles());
			textTotal1.setText(String.valueOf(currentFootPrint.getNumberOfWaterBottles()));
			
			slider2.setValue(currentFootPrint.getNumberOfLoadsOfClothes());
			textTotal2.setText(String.valueOf(currentFootPrint.getNumberOfLoadsOfClothes()));
			
			slider3.setValue(currentFootPrint.getNumberOfTimesDoesDishes());
			textTotal3.setText(String.valueOf(currentFootPrint.getNumberOfTimesDoesDishes()));
			
			slider4.setValue(currentFootPrint.getNumberOfWashes());
			textTotal4.setText(String.valueOf(currentFootPrint.getNumberOfWashes()));
			
			slider5.setValue(currentFootPrint.getNumberOfTimesWaterPlants());
			textTotal5.setText(String.valueOf(currentFootPrint.getNumberOfTimesWaterPlants()));
			
			slider6.setValue(currentFootPrint.getServingOfBeef());
			textTotal6.setText(String.valueOf(currentFootPrint.getServingOfBeef()));
				
			slider7.setValue(currentFootPrint.getServingOfChicken());
			textTotal7.setText(String.valueOf(currentFootPrint.getServingOfChicken()));
					
			slider8.setValue(currentFootPrint.getServingOfLamb());
			textTotal8.setText(String.valueOf(currentFootPrint.getServingOfLamb()));
	
			slider9.setValue(currentFootPrint.getServingOfEggs());
			textTotal9.setText(String.valueOf(currentFootPrint.getServingOfEggs()));

			slider10.setValue(currentFootPrint.getServingOfLentils());
			textTotal10.setText(String.valueOf(currentFootPrint.getServingOfLentils()));
			
			slider11.setValue(currentFootPrint.getServingOfPasta());
			textTotal11.setText(String.valueOf(currentFootPrint.getServingOfPasta()));
				
			slider12.setValue(currentFootPrint.getServingOfCorn());
			textTotal12.setText(String.valueOf(currentFootPrint.getServingOfCorn()));
					
			slider13.setValue(currentFootPrint.getServingsOfVeggies());
			textTotal13.setText(String.valueOf(currentFootPrint.getServingsOfVeggies()));
	}
	
	/**
	 * adds the background image to the screen
	 */
	public void paintComponent(Graphics g){
		
		g.drawImage(bkgd, 0,0, null);
	}
	
	/**
	 * changes the consumptionStatus label depending on the level of water being used
	 */
	public void getConsumptionStatus(){
		//get the toal amount of water being used
		double consumptionLevel = Double.parseDouble(textWater.getText());
		
		//if the total amount of water being used is below 1,500 liters/week, 
		//tell the user that they are using a healthy amount of water
		if (consumptionLevel < 1500) {
			consumptionStatus.setForeground(Color.GREEN);
			consumptionStatus.setText("<html><p>You are consuming a healthy amount of water</p></html>");
		} 
		//if the total amount of water being used is above 1,500 liters/week, 
		//tell the user that they are using a healthy amount of water
		else {
			consumptionStatus.setForeground(Color.RED);
			consumptionStatus.setText("You are consuming too much water");
		}
	}
	/**
	 * returns the current user to be passed on to the next page
	 */
	@Override
	public User passOnUser() {
		return currentUser;
	}
	
	/**
	 * receives the user from the previous page and updates values on the page
	 */
	@Override
	public void receiveUser(User setCurrentUser) {
		currentUser=setCurrentUser;
		
		//update the footprint associated with the user and the total amount of water displayed
		currentFootPrint=currentUser.getFootPrint();
		textWater.setText(String.valueOf(currentFootPrint.getTotalAmountOfWater()));

		//update the sliders based on the new user
		updateSliders();
	}

	@Override
	public void drawBackground() {
		try {

			// process the image file
			bkgd = ImageIO.read(new File("background.jpg"));

			// set the size of the frame based on the size of the image so that
			// the entire background is covered
			Dimension size = new Dimension(bkgd.getWidth(null),
					bkgd.getHeight(null));

			// set all of the dimensions using the size
			setPreferredSize(size);
			setMinimumSize(size);
			setMaximumSize(size);
			setSize(size);
			setLayout(null);

			// if there is an error with the file, throw and IOException
		} catch (IOException error) {
			System.out.println("Error in drawBackground: image file failed to load!");
		}
		
	}
}