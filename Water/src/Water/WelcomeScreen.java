package Water;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

class WelcomeScreen extends JPanel
{
	private static final String CARD_JBUTTON =  "Card JButton";
    private ActionListener action;

    public WelcomeScreen() 
    {
        init();
    }

    private void init() 
    {    
    	/*
    	final JPanel contentPane = new JPanel();
        contentPane.setLayout(new CardLayout(200, 200));

        //make all the card and add them to the contentPane above
        final AboutScreen aboutWin = new AboutScreen();
        contentPane.add(aboutWin, CARD_JBUTTON);
        final TipScreen tipWin=new TipScreen();
        contentPane.add(tipWin, CARD_JBUTTON);
        final TeacherPage teachWin=new TeacherPage();
        contentPane.add(teachWin, CARD_JBUTTON);
        
    	JPanel buttonPanel = new JPanel(); 
        final JButton aboutButton=new JButton("ABOUT");
        final JButton tipButton=new JButton("TIPS");
        final JButton teacherButton=new JButton("TEACHER");
        teacherButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "teachWin");
            }
        });
        
        tipButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "tipWin");
            }
        });
        aboutButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "aboutWin");
            }
        });
        
        buttonPanel.add(aboutButton);
        add(buttonPanel, BorderLayout.PAGE_END);
        */
    }
}