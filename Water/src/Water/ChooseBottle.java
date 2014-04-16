package Water;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChooseBottle extends JPanel {

	private ActionListener state;

	public ChooseBottle()
	{
		//somehting somehting something
		//somekjbadsjkfbkjsadf
		init();
	}

	public void init()
	{
		setLayout(new GridLayout(2, 2));
		JLabel recyclableWater = new JLabel("Do you use Recycleable water bottles?", JLabel.CENTER);
		final JCheckBox recyclableWaterBox = new JCheckBox();
		JLabel waterBottle = new JLabel("Do you use regular water bottles?", JLabel.CENTER);
		final JCheckBox waterBottleBox = new JCheckBox();

		state = new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if (recyclableWaterBox == (JCheckBox) ae.getSource())
				{
					waterBottleBox.setSelected(false);
					JOptionPane.showMessageDialog(null, "Good Job!"
							, "Water Bottle: ", JOptionPane.INFORMATION_MESSAGE);                            
				}
				else if (waterBottleBox == (JCheckBox) ae.getSource())
				{
					recyclableWaterBox.setSelected(false);
					JOptionPane.showMessageDialog(null, "Not such a good job!"
							, "Water Bottle: ", JOptionPane.INFORMATION_MESSAGE);                        
				}
			}
		};

		recyclableWaterBox.addActionListener(state);
		waterBottleBox.addActionListener(state);
		add(recyclableWater);
		add(recyclableWaterBox);
		add(waterBottle);
		add(waterBottleBox);

  
	}
}