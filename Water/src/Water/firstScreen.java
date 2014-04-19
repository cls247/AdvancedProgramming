package Water;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class firstScreen
{
    private static final String CARD_JBUTTON =  "Card JButton";
    private static final String CARD_JTEXTFIELD = "Card JTextField";    
    private static final String CARD_JRADIOBUTTON = "Card JRadioButton";

    private static void createAndShowGUI()
    {
    	//here you make the frame
        JFrame frame = new JFrame("Water");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        //this is that thing that holds all the card
        final JPanel contentPane = new JPanel();
        contentPane.setLayout(new CardLayout(200, 200));

        //make all the card and add them to the contentPane above
        WelcomeScreen win1 = new WelcomeScreen();
        contentPane.add(win1, CARD_JBUTTON);
        InteractivePage temp=new InteractivePage();
        contentPane.add(temp, CARD_JBUTTON);
        
        ScreenWithTwoQuestions chooseWaterBottle = new ScreenWithTwoQuestions("Do you use recyclable bottles?", 
        		"Do you use plastic water bottles?", 
        		"How many water bottles do you use a week?");
        contentPane.add(chooseWaterBottle, CARD_JRADIOBUTTON);
        ScreenWithTwoQuestions waterPlants = new ScreenWithTwoQuestions("Do you use sprinkles?", 
        		"Do you water your lawn by hand?", 
        		"How many times a week do you water the lawn?");
        contentPane.add(chooseWaterBottle, CARD_JRADIOBUTTON);
        
        //this is the buttons to go forward and backward
        JPanel buttonPanel = new JPanel(); 
        final JButton previousButton = new JButton("PREVIOUS");
        previousButton.setBackground(Color.BLACK);
        previousButton.setForeground(Color.WHITE);
        final JButton nextButton = new JButton("NEXT");
        nextButton.setBackground(Color.RED);
        nextButton.setForeground(Color.WHITE);
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);

        //this flips to the previous card
        previousButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.previous(contentPane);
            }
        });
        
        //this flips to the next card
        nextButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.next(contentPane);   
            }
        });

        frame.add(contentPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.PAGE_END);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
} 