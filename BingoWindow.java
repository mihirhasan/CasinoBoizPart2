package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


/**
 * Provides GUI for a trader.
 */
public class BingoWindow extends JFrame implements ActionListener
{

    private Bingo bingo;

    private JTextArea msgArea;

    private JLabel[][] labels = new JLabel[5][5];

    private JButton betBtn, nextBtn, backBtn;

    private int check = 0;

    private int money = 100;


    /**
     * Constructs a new trading window for a trader.
     * 
     * @param roulette
     *            a roulette game that is played in the
     */
    public BingoWindow( Bingo bingo )
    {
        super( "Bingo" );

        this.bingo = bingo;
        this.bingo.drawBoard();

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

        for ( int i = 0; i < 5; i++ )
        {
            for ( int c = 0; c < 5; c++ )
            {
                labels[i][c] = new JLabel( " " + this.bingo.myBoard()[i][c] );
            }
        }

        for ( int row = 0; row < 5; row++ )
        {
            for ( int col = 0; col < 5; col++ )
            {
                gbc.gridy = col + 1;
                gbc.gridx = row;
                gbc.gridwidth = 1;
                gbLayout.setConstraints( labels[row][col], gbc );
                // panel.add( labels[row][col] );
            }
        }

        betBtn = new JButton( "Start Game" );
        betBtn.addActionListener( this );
        betBtn.setActionCommand( "start" );
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbLayout.setConstraints( betBtn, gbc );
        panel.add( betBtn );

        nextBtn = new JButton( "Next Number" );
        nextBtn.addActionListener( this );
        nextBtn.setActionCommand( "next" );
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbLayout.setConstraints( nextBtn, gbc );
        panel.add( nextBtn );
        nextBtn.setEnabled( false );

        backBtn = new JButton( "Back" );
        backBtn.addActionListener( this );
        backBtn.setActionCommand( "back" );
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbLayout.setConstraints( backBtn, gbc );
        panel.add( backBtn );

        msgArea = new JTextArea( 100, 300 );
        msgArea.setLineWrap( true );
        msgArea.setWrapStyleWord( true );
        msgArea.setEditable( false );
        msgArea.setBorder( new EmptyBorder( 5, 10, 5, 10 ) );
        msgArea.setText( "The game has begun. You start with 100 dollars, and it costs 10 dollars to play a game of bingo."
            + "Press the next button to select a number. "
            + "If the number drawn is the same as on your "
            + "bingo card the number will change to 0." );
        JScrollPane areaScrollPane = new JScrollPane( msgArea );
        areaScrollPane.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        areaScrollPane.setBorder( new EmptyBorder( 5, 0, 5, 0 ) );

        Box b = Box.createHorizontalBox();
        b.add( panel );
        b.add( areaScrollPane );
        Container c = getContentPane();
        c.add( b );

        int x = (int)( Math.random() * 500 );
        int y = (int)( Math.random() * 500 );
        setBounds( x, y, 500, 500 );
        setVisible( true );
    }


    public void showMessage( String msg )
    {
        msgArea.append( msg );
    }


    @Override
    public void actionPerformed( ActionEvent e )
    {
        betBtn.setText( "Start Game" );
        if ( money > 0 )
        {
            if ( e.getActionCommand().equals( "start" ) )
            {
                nextBtn.setEnabled( true );
                check = 0;
                bingo.drawBoard();
                msgArea.setText( "" );
                for ( int col = 0; col < 5; col++ )
                {
                    for ( int row = 0; row < 5; row++ )
                    {
                        msgArea.append( bingo.myBoard()[row][col] + "\t" );
                    }
                    msgArea.append( "\n" );
                }
                money -= 10;
                
                betBtn.setEnabled( false );
            }
            else if ( e.getActionCommand().equals( "next" ) && check < 50 )
            {
                int num = bingo.increment();
                msgArea.setText( "" );
                for ( int col = 0; col < 5; col++ )
                {
                    for ( int row = 0; row < 5; row++ )
                    {
                        msgArea.append( bingo.myBoard()[row][col] + "\t" );
                    }
                    msgArea.append( "\n" );
                }
                check++;
                msgArea.append( "\n" + "The number selected was " + num
                    + ". You are on turn " + check );

                if ( bingo.check() )
                {
                    money += 20;
                    msgArea.append( "\n" + "You won 20 coins" );
                    msgArea.append( "\n" + "Your balance is: " + money );
                    nextBtn.setEnabled( false );
                    betBtn.setEnabled( true );
                }
            }
            else if ( check >= 50 )
            {
                msgArea
                    .setText( "You lost 10 coins. Sorry, please play again." );
                msgArea.setText( "Balance: " + money );
                betBtn.setEnabled( true );
                nextBtn.setEnabled( false );
            }

        }
        else
        {
            betBtn.setText( "Start Over" );
            betBtn.setEnabled( true );
            nextBtn.setEnabled( false );
            money = 100;
        }
        if ( e.getActionCommand().equals( "back" ) )
        {
            casinoWindow casino = new casinoWindow();
            casino.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            casino.setBounds( 0, 0, 500, 350 );
            casino.setVisible( true );
            dispose();
        }
    }

}
