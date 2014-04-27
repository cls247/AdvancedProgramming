package Water;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

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
	
	public void addSliders(){
		
		//******
		//This is a bunch of sliders that the user can manipulate.
		//When the slider is called, it update the TextAreas and it updates
		//the footprint based on what was input from the user. 
		//labels for the first row
		
		//labels for the first row
		sliderPanel.add(label1);
		sliderPanel.add(label2);
		sliderPanel.add(label3);
		
		//sliders for the first row		
		
		//add the sldier to the slider panel
		sliderPanel.add(slider1, "Water Bottles");
		
		//create a new change listener
		slider1.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// change the number of water bottles in the footprint
				//then update the various values on the screen
				currentFootPrint.setNumberOfWaterBottles(slider1.getValue());
				textTotal1.setText(String.valueOf(slider1.getValue()));
				textWater.setText(String.valueOf(currentFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		//set some preferences on the slider
		slider1.setMajorTickSpacing(10); 
		slider1.setPaintLabels(true); 
		slider1.setPaintTicks(true); 
		
		slider2.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider2.getValue());
				currentFootPrint.setNumberOfLoadsOfClothes(slider2.getValue());
				textTotal2.setText(String.valueOf(slider2.getValue()));
				textWater.setText(String.valueOf(currentFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider2.setMajorTickSpacing(10); 
		slider2.setPaintLabels(true); 
		slider2.setPaintTicks(true); 
		sliderPanel.add(slider2, "Meat Servings");
		
		
		slider3.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				 
				currentFootPrint.setNumberOfTimesDoesDishes(slider3.getValue());
				textTotal3.setText(String.valueOf(slider3.getValue()));
				textWater.setText(String.valueOf(currentFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider3.setMajorTickSpacing(10); 
		slider3.setPaintLabels(true); 
		slider3.setPaintTicks(true); 
		sliderPanel.add(slider3, "Grain Servings");
		
		//displays values of the sliders in the first row
		sliderPanel.add(textTotal1);
		sliderPanel.add(textTotal2);
		sliderPanel.add(textTotal3);
		
		//labels for the second row
		sliderPanel.add(label4);
		sliderPanel.add(label5);
		sliderPanel.add(label6);
		
		
		//sliders for the second row
		slider4.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				 
				currentFootPrint.setNumberOfWashes(slider4.getValue());
				textTotal4.setText(String.valueOf(slider4.getValue()));
				textWater.setText(String.valueOf(currentFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider4.setMajorTickSpacing(10); 
		slider4.setPaintLabels(true); 
		slider4.setPaintTicks(true); 
		sliderPanel.add(slider4, "Fruits and Vegetables Servings");
		
		slider5.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				currentFootPrint.setNumberOfTimesWaterPlants(slider5.getValue());
				textTotal5.setText(String.valueOf(slider5.getValue()));				
				textWater.setText(String.valueOf(currentFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider5.setMajorTickSpacing(10); 
		slider5.setPaintLabels(true); 
		slider5.setPaintTicks(true); 
		sliderPanel.add(slider5, "Fruits and Vegetables Servings");
		
		slider6.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				 
				currentFootPrint.setServingOfBeef(slider6.getValue());
				textTotal6.setText(String.valueOf(slider6.getValue()));
				textWater.setText(String.valueOf(currentFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider6.setMajorTickSpacing(10); 
		slider6.setPaintLabels(true); 
		slider6.setPaintTicks(true); 
		sliderPanel.add(slider6, "Fruits and Vegetables Servings");
		
		//displays values of the sliders in the second row
		sliderPanel.add(textTotal4);
		sliderPanel.add(textTotal5);
		sliderPanel.add(textTotal6);
		
		//labels for the third row
		sliderPanel.add(label7);
		sliderPanel.add(label8);
		sliderPanel.add(label9);
		
		//sliders for the third row
		slider7.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				 
				currentFootPrint.setServingOfChicken(slider7.getValue());
				textTotal7.setText(String.valueOf(slider7.getValue()));
				textWater.setText(String.valueOf(currentFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider7.setMajorTickSpacing(10); 
		slider7.setPaintLabels(true); 
		slider7.setPaintTicks(true); 
		sliderPanel.add(slider7, "Fruits and Vegetables Servings");
		
		slider8.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				 
				currentFootPrint.setServingOfLamb(slider8.getValue());
				textTotal8.setText(String.valueOf(slider8.getValue()));
				textWater.setText(String.valueOf(currentFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider8.setMajorTickSpacing(10); 
		slider8.setPaintLabels(true); 
		slider8.setPaintTicks(true); 
		sliderPanel.add(slider8, "Fruits and Vegetables Servings");
		
		slider9.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				 
				currentFootPrint.setServingOfEggs(slider9.getValue());
				textTotal9.setText(String.valueOf(slider9.getValue()));
				textWater.setText(String.valueOf(currentFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider9.setMajorTickSpacing(10); 
		slider9.setPaintLabels(true); 
		slider9.setPaintTicks(true); 
		sliderPanel.add(slider9, "Fruits and Vegetables Servings");	
		
		//displays values of the sliders in the third row
		sliderPanel.add(textTotal7);
		sliderPanel.add(textTotal8);
		sliderPanel.add(textTotal9);
		
		//labels for the fourth row
		sliderPanel.add(label10);
		sliderPanel.add(label11);
		sliderPanel.add(label12);
		
		//sliders for the fourth row
		slider10.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				 
				currentFootPrint.setServingOfLentils(slider10.getValue());
				textTotal10.setText(String.valueOf(slider10.getValue()));
				textWater.setText(String.valueOf(currentFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider10.setMajorTickSpacing(10); 
		slider10.setPaintLabels(true); 
		slider10.setPaintTicks(true); 
		sliderPanel.add(slider10, "Fruits and Vegetables Servings");	
		
		slider11.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				 
				currentFootPrint.setServingOfPasta(slider11.getValue());
				textTotal11.setText(String.valueOf(slider11.getValue()));
				textWater.setText(String.valueOf(currentFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider11.setMajorTickSpacing(10); 
		slider11.setPaintLabels(true); 
		slider11.setPaintTicks(true); 
		sliderPanel.add(slider11, "Fruits and Vegetables Servings");	
		
		slider12.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				 
				currentFootPrint.setServingOfCorn(slider12.getValue());
				textTotal12.setText(String.valueOf(slider12.getValue()));
				textWater.setText(String.valueOf(currentFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider12.setMajorTickSpacing(10); 
		slider12.setPaintLabels(true); 
		slider12.setPaintTicks(true); 
		sliderPanel.add(slider12, "Fruits and Vegetables Servings");	
		
		//displays values of the sliders in the fourth row
		sliderPanel.add(textTotal10);
		sliderPanel.add(textTotal11);
		sliderPanel.add(textTotal12);
		
		//labels for the fifth row
		sliderPanel.add(label13);
		sliderPanel.add(new JLabel());
		sliderPanel.add(new JLabel());
		
		//sliders for the fifth row
		slider13.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				 
				currentFootPrint.setServingOfVeggies(slider13.getValue());
				textTotal13.setText(String.valueOf(slider13.getValue()));
				textWater.setText(String.valueOf(currentFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider13.setMajorTickSpacing(10); 
		slider13.setPaintLabels(true); 
		slider13.setPaintTicks(true); 
		sliderPanel.add(slider13, "Fruits and Vegetables Servings");	
		
		//blank filler labels
		sliderPanel.add(new JLabel());
		sliderPanel.add(new JLabel());
		
		//displays values of the sliders in the fifth row
		sliderPanel.add(textTotal13);

				
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
	 * updates the values displayed on the sliders and the labels beneath them
	 */
	public void updateSliders(){
		
				//updates the sliders whenever a new user profile is passed in 
		
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