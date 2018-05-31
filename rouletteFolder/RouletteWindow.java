import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


/**
 * Provides GUI for a trader.
 */
public class RouletteWindow extends JFrame implements ActionListener
{
    private static final String PROMPT = ">> ";

    private JButton betBtn, backBtn;

    private JRadioButton btn1, btn2, btn3, btn4, btn5, btn6;

    private JTextField symbText, nsText, priceText;

    private JTextArea msgArea;

    private Roulette roulette;


    /**
     * Constructs a new trading window for a trader.
     * 
     * @param roulette
     *            a roulette game that is played in the
     */
    public RouletteWindow( Roulette roulette )
    {
        super( "Roulette" );

        this.roulette = roulette;

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

        JLabel label = new JLabel( "Bet Amount:  ", JLabel.RIGHT );
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbLayout.setConstraints( label, gbc );
        panel.add( label );
        symbText = new JTextField( 5 );
        symbText.setBackground( Color.cyan );
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbLayout.setConstraints( symbText, gbc );
        panel.add( symbText );

        JLabel filler = new JLabel( " " );
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbLayout.setConstraints( filler, gbc );
        panel.add( filler );

        label = new JLabel( "Bet Type:", JLabel.RIGHT );
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbLayout.setConstraints( label, gbc );
        panel.add( label );

        filler = new JLabel( " " );
        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbLayout.setConstraints( filler, gbc );
        panel.add( filler );

        ButtonGroup gr = new ButtonGroup();
        btn1 = new JRadioButton( "Number", true );
        btn2 = new JRadioButton( "Columns", false );
        btn3 = new JRadioButton( "Colors", false );
        btn4 = new JRadioButton( "Even or Odd", false );
        btn5 = new JRadioButton( "1 to 18", false );
        btn6 = new JRadioButton( "19 to 36", false );
        btn1.addActionListener( this );
        btn2.addActionListener( this );
        btn3.addActionListener( this );
        btn4.addActionListener( this );
        btn5.addActionListener( this );
        btn6.addActionListener( this );
        gr.add( btn1 );
        gr.add( btn2 );
        gr.add( btn3 );
        gr.add( btn4 );
        gr.add( btn5 );
        gr.add( btn6 );
        gbc.gridy = 4;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbLayout.setConstraints( btn1, gbc );
        panel.add( btn1 );
        btn1.setActionCommand( "numBet" );
        gbc.gridy = 5;
        gbLayout.addLayoutComponent( btn2, gbc );
        panel.add( btn2 );
        btn2.setActionCommand( "colBet" );
        gbc.gridy = 6;
        gbLayout.addLayoutComponent( btn3, gbc );
        panel.add( btn3 );
        btn3.setActionCommand( "colorBet" );
        gbc.gridy = 7;
        gbLayout.addLayoutComponent( btn4, gbc );
        panel.add( btn4 );
        btn4.setActionCommand( "evenBet" );
        gbc.gridy = 8;
        gbLayout.addLayoutComponent( btn5, gbc );
        panel.add( btn5 );
        btn5.setActionCommand( "firstNumBet" );
        gbc.gridy = 9;
        gbLayout.setConstraints( btn6, gbc );
        panel.add( btn6 );
        btn6.setActionCommand( "secondNumBet" );

        label = new JLabel( "Square:  ", JLabel.RIGHT );
        gbc.gridy = 10;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbLayout.setConstraints( label, gbc );
        panel.add( label );
        nsText = new JTextField( 5 );
        nsText.setBackground( Color.cyan );
        gbc.gridy = 10;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbLayout.setConstraints( nsText, gbc );
        panel.add( nsText );

        betBtn = new JButton( "BET" );
        betBtn.addActionListener( this );
        betBtn.setActionCommand( "bet" );
        gbc.gridy = 11;
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbLayout.setConstraints( betBtn, gbc );
        panel.add( betBtn );
        
        backBtn = new JButton( "Back to Menu" );
        backBtn.addActionListener( this );
        backBtn.setActionCommand( "back" );
        gbc.gridy = 12;
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbLayout.setConstraints( backBtn, gbc );
        panel.add( backBtn );

        msgArea = new JTextArea( 10, 30 );
        msgArea.setLineWrap( true );
        msgArea.setWrapStyleWord( true );
        msgArea.setEditable( false );
        msgArea.setBorder( new EmptyBorder( 5, 10, 5, 10 ) );
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
        int y = (int)( Math.random() * 300 );
        setBounds( x, y, 500, 280 );
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


    /**
     * Processes GUI events in this window.
     * 
     * @param e
     *            an event.
     */
    public void actionPerformed( ActionEvent e )
    {
        nsText.setEditable( true );
        nsText.setBackground( Color.CYAN);
        if ( e.getActionCommand().equals( "numBet" ) )
        {
            roulette.setBetType( 1 );
            showMessage(
                "In the section labeled bet square please select which square you would like to bet on." );
        }
        else if ( e.getActionCommand().equals( "colBet" ) )
        {
            roulette.setBetType( 2 );
            showMessage(
                "In the section labeled bet square please select which column you want to bet on." );
        }
        else if ( e.getActionCommand().equals( "colorBet" ) )
        {
            roulette.setBetType( 3 );
            showMessage(
                "In the section labeled bet square type 1 for red and 2 for black" );
        }
        else if ( e.getActionCommand().equals( "evenBet" ) )
        {
            roulette.setBetType( 4 );
            showMessage(
                "In the section labeled bet square type 0 for even and 1 for odd" );
        }
        else if ( e.getActionCommand().equals( "firstNumBet" ) )
        {
            roulette.setBetType( 5 );
            roulette.setBetSquare( 18 );
            nsText.setText( "18" );
            showMessage( "Your chose the bet in the range from 1 to 18." );
            nsText.setBackground( Color.GRAY);
            nsText.setEditable( false );
        }
        else if ( e.getActionCommand().equals( "secondNumBet" ) )
        {
            roulette.setBetType( 6 );
            roulette.setBetSquare( 36 );
            nsText.setText( "36" );
            showMessage( "Your chose the bet in the range from 19 to 36." );
            nsText.setBackground( Color.GRAY);
            nsText.setEditable( false );
        }
        else if ( e.getActionCommand().equals( "bet" ) )
        {
            try
            {
                roulette.setBetAmount( Integer.parseInt( symbText.getText() ) );
                roulette.setBetSquare( Integer.parseInt( nsText.getText() ) );
                showMessage(
                    "You bet: " + Integer.parseInt( symbText.getText() ) );
                int hold = roulette.bet();
                if ( hold == -1 )
                {
                    showMessage(
                        "You did not bet more than $5 or you don't have that much money" );
                }
                else if ( hold == -2 )
                {
                    showMessage(
                        "You did not enter a proper bet. Please complete all the " );
                }
                else
                {
                    showMessage( "You won: " + hold );
                }
                showMessage( "You have: " + roulette.getMoney() );
            }
            catch ( NumberFormatException ex )
            {
                showMessage( "Please enter an integer." );
            }
        }
        else if ( e.getActionCommand().equals( "back" ))
        {
            CasinoWindow casino = new CasinoWindow();
            casino.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            casino.setBounds( 0, 0, 500, 350 );
            casino.setVisible( true );
            dispose();
        }
    }
}
