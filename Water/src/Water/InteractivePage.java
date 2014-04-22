package Water;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.logging.Handler;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//so this is like supposed to on a thread, but I'm not positive how to do that
//I think that I got it pretty close
//*************I totally forgot about the slider class so we can totally use that here
public class InteractivePage extends JPanel {
	

	private int meatX=20, meatY=60, meatHeight=100, meatWidth=100;
	//there should be a temporary food print in order to 
	//keep updating the footprint according to the bars that change
	FootPrint temporaryFootPrint=new FootPrint();
	Rectangle meatBar=new Rectangle(meatX, meatY, meatWidth, meatHeight);
	double sliderForFootPrint;
	int sliderForWaterBottles=0;
	int sliderForNumberOfTimesDoesDishes=0;
	int sliderForServingOfBeef=0;
	int sliderForServingOfChicken=0;
	int sliderForServingOfCorn=0;
	int sliderForNumberOfWashes=0;
	int sliderForNumberOfLoadsOfClothes=0;
	JTextField textTotal1=new JTextField("00");
	JTextField textTotal2=new JTextField("00");
	JTextField textTotal3=new JTextField("00");
	JTextField textTotal4=new JTextField("00");
	JTextField textTotal5=new JTextField("00");
	JTextField textTotal6=new JTextField("00");
	JTextField textTotal7=new JTextField("00");
	JTextField textTotal8=new JTextField("00");
	JTextField textTotal9=new JTextField("00");
	JTextField textWater = new JTextField("00");
	
	private Image bkgd;
	//TextField totalText=new TextField("00");
	
	double amountWaterUsed = 0;
	
	double currentWaterLevel = temporaryFootPrint.getBottle().getWaterLevel();
	
	public InteractivePage()
	{
		init();		
	}	
	
	public void init()
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
		
		setLayout(new FlowLayout(FlowLayout.CENTER));	
		
		add(textWater);
		
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
			}
			
		});
		slider.setMajorTickSpacing(10); 
		slider.setPaintLabels(true); 
		slider.setPaintTicks(true); 
		this.add(slider, "Water Bottles");
		add(textTotal1);
		
		
		final JSlider slider2 = new JSlider();
		slider2.setValue(0);
		slider2.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider2.getValue());
				temporaryFootPrint.setNumberOfWaterBottles(slider2.getValue());
				textTotal2.setText(String.valueOf(slider2.getValue()));
				textWater.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));
			}
			
		});
		slider2.setMajorTickSpacing(10); 
		slider2.setPaintLabels(true); 
		slider2.setPaintTicks(true); 
		this.add(slider2, "Meat Servings");
		add(textTotal2);
		
		final JSlider slider3 = new JSlider();
		slider3.setValue(0);
		slider3.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider.getValue());
				temporaryFootPrint.setNumberOfWaterBottles(slider3.getValue());
				textTotal3.setText(String.valueOf(slider3.getValue()));
				textWater.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));
			}
			
		});
		slider3.setMajorTickSpacing(10); 
		slider3.setPaintLabels(true); 
		slider3.setPaintTicks(true); 
		this.add(slider3, "Grain Servings");
		add(textTotal3);
		
		final JSlider slider4 = new JSlider();
		slider4.setValue(0);
		slider4.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider.getValue());
				temporaryFootPrint.setNumberOfWaterBottles(slider4.getValue());
				textTotal4.setText(String.valueOf(slider4.getValue()));
				textWater.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));
			}
			
		});
		slider4.setMajorTickSpacing(10); 
		slider4.setPaintLabels(true); 
		slider4.setPaintTicks(true); 
		this.add(slider4, "Fruits and Vegetables Servings");
		add(textTotal4);
		
		final JSlider slider5 = new JSlider();
		slider5.setValue(0);
		slider5.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider.getValue());
				temporaryFootPrint.setNumberOfWaterBottles(slider5.getValue());
				textTotal5.setText(String.valueOf(slider5.getValue()));				
				textWater.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));
			}
			
		});
		slider5.setMajorTickSpacing(10); 
		slider5.setPaintLabels(true); 
		slider5.setPaintTicks(true); 
		this.add(slider5, "Fruits and Vegetables Servings");
		add(textTotal5);
		
		final JSlider slider6 = new JSlider();
		slider6.setValue(0);
		slider6.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider.getValue());
				temporaryFootPrint.setNumberOfWaterBottles(slider6.getValue());
				textTotal6.setText(String.valueOf(slider6.getValue()));
				textWater.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));
			}
			
		});
		slider6.setMajorTickSpacing(10); 
		slider6.setPaintLabels(true); 
		slider6.setPaintTicks(true); 
		this.add(slider6, "Fruits and Vegetables Servings");
		add(textTotal6);
		
		final JSlider slider7 = new JSlider();
		slider7.setValue(0);
		slider7.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider.getValue());
				temporaryFootPrint.setNumberOfWaterBottles(slider7.getValue());
				textTotal7.setText(String.valueOf(slider7.getValue()));
				textWater.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));
			}
			
		});
		slider7.setMajorTickSpacing(10); 
		slider7.setPaintLabels(true); 
		slider7.setPaintTicks(true); 
		this.add(slider7, "Fruits and Vegetables Servings");
		add(textTotal7);
		
		final JSlider slider8 = new JSlider();
		slider8.setValue(0);
		slider8.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider.getValue());
				temporaryFootPrint.setNumberOfWaterBottles(slider8.getValue());
				textTotal8.setText(String.valueOf(slider8.getValue()));
				textWater.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));
			}
			
		});
		slider8.setMajorTickSpacing(10); 
		slider8.setPaintLabels(true); 
		slider8.setPaintTicks(true); 
		this.add(slider8, "Fruits and Vegetables Servings");
		add(textTotal8);
		
		final JSlider slider9 = new JSlider();
		slider9.setValue(0);
		slider9.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//this will hold the value of the slider
				System.out.println(slider.getValue());
				temporaryFootPrint.setNumberOfWaterBottles(slider9.getValue());
				textTotal9.setText(String.valueOf(slider9.getValue()));
				textWater.setText(String.valueOf(temporaryFootPrint.getTotalAmountOfWater()));
			}
			
		});
		slider9.setMajorTickSpacing(10); 
		slider9.setPaintLabels(true); 
		slider9.setPaintTicks(true); 
		this.add(slider9, "Fruits and Vegetables Servings");
		add(textTotal9);
		
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
}	