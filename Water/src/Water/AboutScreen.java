package Water;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AboutScreen extends JPanel {

    private static final String CARD_JBUTTON =  "Card JButton";
	
	public AboutScreen()
	{
		init();
	}
	public void init()
	{
		/*
		
		//Just write something and then put it here
		TextField about=new TextField();
		add(about);
		setLayout(new GridLayout(2, 2));		
		
		
        final JPanel contentPane = new JPanel();
        contentPane.setLayout(new CardLayout(200, 200));

        //make all the card and add them to the contentPane above
        final WelcomeScreen win1 = new WelcomeScreen();
        contentPane.add(win1, CARD_JBUTTON);
        
    	JPanel buttonPanel = new JPanel(); 
        final JButton backButton=new JButton("BACK");
        backButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "win1");
            }
        });
        
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.PAGE_END);
        */
	}
}
