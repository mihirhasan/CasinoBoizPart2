package test;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import java.util.ArrayList;


public class slotWindow extends JFrame implements ActionListener
{
    private static final String PROMPT = ">> ";

    private JButton Spin, back;

    private JTextArea msgArea;

    private SlotMachine slot;


    /**
     * Constructs a new blackjack window
     * 
     * @param blackjack
     *            blackjack class controls functionality
     */
    public slotWindow( SlotMachine slotmachine )
    {
        super( "SlotMachine" );

        slot = slotmachine;

        addWindowListener( new WindowAdapter()
        {
            public void windowClosing( WindowEvent e )
            {
            }
        } );

        JPanel panel = new JPanel();
        GridBagLayout gbLayout = new GridBagLayout();
        panel.setLayout( gbLayout );
        panel.setBorder( new EmptyBorder( 10, 10, 10, 10 ) );

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.gridwidth = 1;

        JLabel filler = new JLabel( " " );
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbLayout.setConstraints( filler, gbc );
        panel.add( filler );

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 1;

        filler = new JLabel( " " );
        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbLayout.setConstraints( filler, gbc );
        panel.add( filler );

        ButtonGroup gr = new ButtonGroup();
        Spin = new JButton( "Spin" );

        Spin.addActionListener( this );

        gr.add( Spin );

        gbc.gridy = 4;
        gbc.gridx = 1;
        gbc.gridwidth = 1;

        gbLayout.setConstraints( Spin, gbc );
        panel.add( Spin );
        Spin.setActionCommand( "Spin" );
        gbc.gridy = 5;

        gbc.gridy = 11;
        gbc.gridx = 1;
        gbc.gridwidth = 2;

        back = new JButton("Back");
        back.addActionListener( this );
        gbLayout.addLayoutComponent( back, gbc );
        panel.add( back );
        back.setActionCommand( "Back" );
        gbc.gridy = 12;
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbLayout.setConstraints( back, gbc );
        
        msgArea = new JTextArea( 10, 30 );
        msgArea.setLineWrap( true );
        msgArea.setWrapStyleWord( true );
        msgArea.setEditable( false );
        msgArea.setBorder( new EmptyBorder( 5, 10, 5, 10 ) );
        JScrollPane areaScrollPane = new JScrollPane( msgArea );
        areaScrollPane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        areaScrollPane.setBorder( new EmptyBorder( 5, 0, 5, 0 ) );

        Box b = Box.createHorizontalBox();
        b.add( panel );
        b.add( areaScrollPane );
        Container c = getContentPane();
        c.add( b );

        int x = (int)( Math.random() * 500 );
        int y = (int)( Math.random() * 300 );
        setBounds( x, y, 500, 280 );

        showMessage( "This is a slot machine game. You start with 1000 coins, "
            + "and it costs 10 coins to spin." + "Press the spin button to get started! Press 'Back' to return to the home screen" );
        setVisible( true );

    }


    /**
     * Displays a message in this window's text area.
     * 
     * @param msg
     *            the message to be displayed.
     */
    public void showMessage( String msg )
    {
        msgArea.append( msg + "\n\n" );
    }


    // no line
    public void showMessage2( String msg )
    {
        msgArea.append( msg );
    }


    /**
     * Processes GUI events in this window.
     * 
     * @param e
     *            an event.
     */
    public void actionPerformed( ActionEvent e )
    {
         if ( e.getActionCommand().equals( "Spin" ) )
                {
             if(slot.getTotal() > 9)
             {
                    slot.spin();
                   showMessage( slot.getResult()[0] + " || " + slot.getResult()[1] + " || " + slot.getResult()[2] );
                    if ( slot.getPay() > 0 )
                    {
                        showMessage( "Congratulations! You made " + slot.getPay() + " coins!" );
                        showMessage( "Current Balance:" + slot.getTotal() + "" );

                        
                    }
                    else
                    {
                       showMessage( "Sorry, you Lose" );
                       showMessage( "Current Balance:" + slot.getTotal() + "" );

                    }
                    showMessage("Press spin to play again!");
        
                }
       
        
             else
             {
                 showMessage("Sorry, you are out of money. You can press 'Spin' to restart the game");
                 slot.reset();
                 
             }
                }
         
         else if ( e.getActionCommand().equals( "Back" ) )
         {
             casinoWindow casino = new casinoWindow();
             casino.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
             casino.setBounds( 0, 0, 500, 350 );
             casino.setVisible( true );
             dispose();
         }
    }

}
