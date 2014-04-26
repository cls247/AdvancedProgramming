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
	private FootPrint temporaryFootPrint=new FootPrint();
	
	
	private JPanel topPanel = new JPanel();
	private JPanel jp = new JPanel();
	private User currentUser=new User();
	//add text areas for each slider to display the total
	//for that slider
	private JTextField textTotal1=new JTextField("00");
	private JTextField textTotal2=new JTextField("00");
	private JTextField textTotal3=new JTextField("00");
	private JTextField textTotal4=new JTextField("00");
	private JTextField textTotal5=new JTextField("00");
	private JTextField textTotal6=new JTextField("00");
	private JTextField textTotal7=new JTextField("00");
	private JTextField textTotal8=new JTextField("00");
	private JTextField textTotal9=new JTextField("00");
	private JTextField textTotal10=new JTextField("00");
	private JTextField textTotal11=new JTextField("00");
	private JTextField textTotal12=new JTextField("00");
	private JTextField textTotal13=new JTextField("00");
	
	//text areas for tracking total water consumption and its status
	private JTextField textWater = new JTextField("00");
	private JLabel consumptionStatus = new JLabel("");
	//consumptionStatus.setWrapText(true);
	private Dimension consumptionStatusSize = new Dimension(100,75);
	//consumptionStatus.setMinimumSize(new Dimension(100,75));
	
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
	
	/**
	 * This is the background image
	 */
	private Image bkgd;
	//TextField totalText=new TextField("00");
	
	public InteractivePage()
	{
		init();		
	}	
	public InteractivePage(FootPrint temporaryFootprint)
	{
		//set the default values of all the sliders
		init();		
	}	
	
	public void init()
	{
		try{

			//set the background image
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			bkgd = ImageIO.read(new File("background.jpg"));
			Dimension jpSize = new Dimension(500,500);
			jp.setPreferredSize(jpSize);
			jp.setMinimumSize(jpSize);
			jp.setMaximumSize(jpSize);
			jp.setSize(jpSize);
			jp.setLayout(new GridLayout(15,3));			
			
			Dimension topPanelSize = new Dimension(500,150);
			topPanel.setPreferredSize(topPanelSize);
			topPanel.setMinimumSize(topPanelSize);
			topPanel.setMaximumSize(topPanelSize);
			topPanel.setSize(topPanelSize);
			topPanel.setLayout(new GridLayout(2,2));
			topPanel.setBackground(Color.WHITE);
		}catch(IOException error){


		}

		//displays the total amount of water used
		topPanel.add(textWater);
		topPanel.add(new JLabel());
		
		topPanel.add(consumptionStatus);
		topPanel.add(new JLabel());
		getConsumptionStatus();
		
		//labels for the first row
		jp.add(label1);
		jp.add(label2);
		jp.add(label3);
		
		//sliders for the first row
		
		final JSlider slider = new JSlider();
		slider.setValue(0);
		slider.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider.getValue());
				temporaryFootPrint.setNumberOfWaterBottles(slider.getValue());
				textTotal1.setText(String.valueOf(slider.getValue()));
				textWater.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		
		//******
		//This is a bunch of sliders that the user can manipulate.
		//When the slider is called, it update the TextAreas and it updates
		//the footprint based on wha twas input from the user. 
		
		slider.setMajorTickSpacing(10); 
		slider.setPaintLabels(true); 
		slider.setPaintTicks(true); 
		jp.add(slider, "Water Bottles");		
		
		final JSlider slider2 = new JSlider();
		slider2.setValue(0);
		slider2.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider2.getValue());
				temporaryFootPrint.setNumberOfLoadsOfClothes(slider2.getValue());
				textTotal2.setText(String.valueOf(slider2.getValue()));
				textWater.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider2.setMajorTickSpacing(10); 
		slider2.setPaintLabels(true); 
		slider2.setPaintTicks(true); 
		jp.add(slider2, "Meat Servings");
		
		final JSlider slider3 = new JSlider();
		slider3.setValue(0);
		slider3.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider.getValue());
				temporaryFootPrint.setNumberOfTimesDoesDishes(slider3.getValue());
				textTotal3.setText(String.valueOf(slider3.getValue()));
				textWater.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider3.setMajorTickSpacing(10); 
		slider3.setPaintLabels(true); 
		slider3.setPaintTicks(true); 
		jp.add(slider3, "Grain Servings");

		//displays values of the sliders in the first row
		jp.add(textTotal1);
		jp.add(textTotal2);
		jp.add(textTotal3);
		
		//labels for the second row
		jp.add(label4);
		jp.add(label5);
		jp.add(label6);
		
		final JSlider slider4 = new JSlider();
		slider4.setValue(0);
		slider4.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider.getValue());
				temporaryFootPrint.setNumberOfWashes(slider4.getValue());
				textTotal4.setText(String.valueOf(slider4.getValue()));
				textWater.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider4.setMajorTickSpacing(10); 
		slider4.setPaintLabels(true); 
		slider4.setPaintTicks(true); 
		jp.add(slider4, "Fruits and Vegetables Servings");
		
		final JSlider slider5 = new JSlider();
		slider5.setValue(0);
		slider5.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider.getValue());
				temporaryFootPrint.setNumberOfTimesWaterPlants(slider5.getValue());
				textTotal5.setText(String.valueOf(slider5.getValue()));				
				textWater.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider5.setMajorTickSpacing(10); 
		slider5.setPaintLabels(true); 
		slider5.setPaintTicks(true); 
		jp.add(slider5, "Fruits and Vegetables Servings");
		
		final JSlider slider6 = new JSlider();
		slider6.setValue(0);
		slider6.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider.getValue());
				temporaryFootPrint.setServingOfBeef(slider6.getValue());
				textTotal6.setText(String.valueOf(slider6.getValue()));
				textWater.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider6.setMajorTickSpacing(10); 
		slider6.setPaintLabels(true); 
		slider6.setPaintTicks(true); 
		jp.add(slider6, "Fruits and Vegetables Servings");
		
		//displays values of the sliders in the second row
		jp.add(textTotal4);
		jp.add(textTotal5);
		jp.add(textTotal6);
		
		//labels for the third row
		jp.add(label7);
		jp.add(label8);
		jp.add(label9);
		
		final JSlider slider7 = new JSlider();
		slider7.setValue(0);
		slider7.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider.getValue());
				temporaryFootPrint.setServingOfChicken(slider7.getValue());
				textTotal7.setText(String.valueOf(slider7.getValue()));
				textWater.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider7.setMajorTickSpacing(10); 
		slider7.setPaintLabels(true); 
		slider7.setPaintTicks(true); 
		jp.add(slider7, "Fruits and Vegetables Servings");
		
		final JSlider slider8 = new JSlider();
		slider8.setValue(0);
		slider8.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider.getValue());
				temporaryFootPrint.setServingOfLamb(slider8.getValue());
				textTotal8.setText(String.valueOf(slider8.getValue()));
				textWater.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider8.setMajorTickSpacing(10); 
		slider8.setPaintLabels(true); 
		slider8.setPaintTicks(true); 
		jp.add(slider8, "Fruits and Vegetables Servings");	
		
		final JSlider slider9 = new JSlider();
		slider9.setValue(0);
		slider9.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider.getValue());
				temporaryFootPrint.setServingOfEggs(slider9.getValue());
				textTotal9.setText(String.valueOf(slider9.getValue()));
				textWater.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider9.setMajorTickSpacing(10); 
		slider9.setPaintLabels(true); 
		slider9.setPaintTicks(true); 
		jp.add(slider9, "Fruits and Vegetables Servings");	
		

		//displays values of the sliders in the third row
		jp.add(textTotal7);
		jp.add(textTotal8);
		jp.add(textTotal9);
		
		//labels for the fourth row
		jp.add(label10);
		jp.add(label11);
		jp.add(label12);
		
		final JSlider slider10 = new JSlider();
		slider10.setValue(0);
		slider10.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider.getValue());
				temporaryFootPrint.setServingOfLentils(slider10.getValue());
				textTotal10.setText(String.valueOf(slider10.getValue()));
				textWater.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider10.setMajorTickSpacing(10); 
		slider10.setPaintLabels(true); 
		slider10.setPaintTicks(true); 
		jp.add(slider10, "Fruits and Vegetables Servings");	
		
		final JSlider slider11 = new JSlider();
		slider11.setValue(0);
		slider11.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider.getValue());
				temporaryFootPrint.setServingOfPasta(slider11.getValue());
				textTotal11.setText(String.valueOf(slider11.getValue()));
				textWater.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider11.setMajorTickSpacing(10); 
		slider11.setPaintLabels(true); 
		slider11.setPaintTicks(true); 
		jp.add(slider11, "Fruits and Vegetables Servings");	
		
		final JSlider slider12 = new JSlider();
		slider12.setValue(0);
		slider12.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider.getValue());
				temporaryFootPrint.setServingOfCorn(slider12.getValue());
				textTotal12.setText(String.valueOf(slider12.getValue()));
				textWater.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider12.setMajorTickSpacing(10); 
		slider12.setPaintLabels(true); 
		slider12.setPaintTicks(true); 
		jp.add(slider12, "Fruits and Vegetables Servings");	
		
		//displays values of the sliders in the fourth row
		jp.add(textTotal10);
		jp.add(textTotal11);
		jp.add(textTotal12);
		
		//labels for the fifth row
		jp.add(label13);
		jp.add(new JLabel());
		jp.add(new JLabel());
				
		final JSlider slider13 = new JSlider();
		slider13.setValue(0);
		slider13.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider.getValue());
				temporaryFootPrint.setServingOfCorn(slider13.getValue());
				textTotal13.setText(String.valueOf(slider13.getValue()));
				textWater.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));
				getConsumptionStatus();
			}
			
		});
		slider13.setMajorTickSpacing(10); 
		slider13.setPaintLabels(true); 
		slider13.setPaintTicks(true); 
		jp.add(slider13, "Fruits and Vegetables Servings");	
		
		//blank filler labels
		jp.add(new JLabel());
		jp.add(new JLabel());
		
		//displays values of the sliders in the fifth row
		jp.add(textTotal13);

				
		JScrollPane sliderScrollPane = new JScrollPane(jp);
		sliderScrollPane.setViewportView(jp);
		sliderScrollPane.setVisible(true);
		sliderScrollPane.setFocusable(true);
		sliderScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		Dimension scrollSize = new Dimension(100,400);
		sliderScrollPane.setPreferredSize(scrollSize);
		sliderScrollPane.setBackground(Color.WHITE);
		
		this.add(topPanel);
		this.add(sliderScrollPane);
	
		/*final JSlider sliderWaterBottle=new JSlider();	
		sliderWaterBottle.setValue(0);
		sliderWaterBottle.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				temporaryFootPrint.setNumberOfWaterBottles(sliderWaterBottle.getValue());
				//totalText.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));				

			}
			
		});
		sliderWaterBottle.setMajorTickSpacing(10); 
		sliderWaterBottle.setPaintLabels(true); 
		sliderWaterBottle.setPaintTicks(true); 
		sliderWaterBottle.setBounds(100, 0, 0, 10);
		setLayout(new BorderLayout());
		this.add(sliderWaterBottle);
		
		final JSlider chickenSlider=new JSlider();	
		chickenSlider.setValue(50);
		chickenSlider.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				temporaryFootPrint.setServingOfChicken(chickenSlider.getValue());
				//totalText.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));				

			}
			
		});
		chickenSlider.setMajorTickSpacing(10); 
		chickenSlider.setPaintLabels(true); 
		chickenSlider.setPaintTicks(true); 
		chickenSlider.setBounds(100, 250, 0, 10);
		setLayout(new BorderLayout());
		this.add(chickenSlider);*/
	}
	
	public void whatIfAnalysis(){
		/*
		//new values to be used in calculation
		sliderForFootPrint = 0; //this should somehow get the value off the slider
		temporaryFootPrint.getBottle().setWaterBottle(sliderForFootPrint);
		
		sliderForWaterBottles = 0; //this should get the value off the slider
		temporaryFootPrint.setNumberOfWaterBottles(sliderForWaterBottles);
		
		sliderForNumberOfTimesDoesDishes=0; //this should get the value off the slider
		temporaryFootPrint.setNumberOfTimesDoesDishes(sliderForNumberOfTimesDoesDishes);
		
		sliderForServingOfBeef=0; //this should get the value off the slider
		temporaryFootPrint.setServingOfBeef(sliderForServingOfBeef);
		
		sliderForServingOfChicken=0; //this should get the value off the slider
		temporaryFootPrint.setServingOfChicken(sliderForServingOfChicken);
		
		sliderForServingOfCorn=0; //this should get the value off the slider
		temporaryFootPrint.setServingOfCorn(sliderForServingOfCorn);
		
		sliderForNumberOfWashes=0; //this should get the value off the slider
		temporaryFootPrint.setNumberOfWashes(sliderForNumberOfWashes);
		
		sliderForNumberOfLoadsOfClothes=0; //this should get the value off the slider
		temporaryFootPrint.setNumberOfLoadsOfClothes(sliderForNumberOfLoadsOfClothes);
		
		temporaryFootPrint.updateTotalAmountOfWater();
		
		amountWaterUsed = temporaryFootPrint.getTotalAmountOfWater();
	*/	
	}
	
	public void paintComponent(Graphics g){

		
		g.drawImage(bkgd, 0,0, null);

		}
	
	public void getConsumptionStatus(){
		double consumptionLevel = Double.parseDouble(textWater.getText());

		if (consumptionLevel < 1500) {
			consumptionStatus.setForeground(Color.GREEN);
			consumptionStatus.setText("<html><p>You are consuming a healthy amount of water</p></html>");
		} 
		else {
			consumptionStatus.setForeground(Color.RED);
			consumptionStatus.setText("You are consuming too much water");
		}
	}
	/**
	 * passOnUser()
	 * This method returns the user to the control class.
	 */
	@Override
	public User passOnUser() {
		return currentUser;
	}
	
	/**
	 *  receiveUser(User setCurrentUser)
	 * This method takes in a User and sets the current
	 * user to the user that is passed in.
	 */
	@Override
	public void receiveUser(User setCurrentUser) {
		currentUser=setCurrentUser;
		
	}

}