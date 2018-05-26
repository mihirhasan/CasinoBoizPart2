import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 *  This is the Roulette class that is part of the CasiYes project. 
 *  This class is uses a hashmap to store the board. 
 *
 *  @author  Dave Desouza-Lawrence
 *  @version May 16, 2018
 *  @author  Period: 2
 *  @author  Assignment: CasiYES
 *  @author  Sources: Mihir
 */
public class Roulette
{
    private HashMap<Integer, Integer> board;

    private int betType = 0;

    private int betAmount = 0;

    private int betSquare = 0;
    
    private int money = 0;
    
    private Random rand;
    
    private int testingVariable = -1;


    /**
     * The default no args constructor creates a new roulette object
     * it also creates the board, because the squares are colored in a 
     * random-like fashion.
     */
    public Roulette()
    {
        board = new HashMap<Integer, Integer>();

        board.put( 0, 0 );
        board.put( 1, 1 );
        board.put( 2, 2 );
        board.put( 3, 1 );
        board.put( 4, 2 );
        board.put( 5, 1 );
        board.put( 6, 2 );
        board.put( 7, 1 );
        board.put( 8, 2 );
        board.put( 9, 1 );
        board.put( 10, 2 );
        board.put( 11, 2 );
        board.put( 12, 1 );
        board.put( 13, 2 );
        board.put( 14, 1 );
        board.put( 15, 2 );
        board.put( 16, 1 );
        board.put( 17, 2 );
        board.put( 18, 1 );
        board.put( 19, 1 );
        board.put( 20, 2 );
        board.put( 21, 1 );
        board.put( 22, 2 );
        board.put( 23, 1 );
        board.put( 24, 2 );
        board.put( 25, 1 );
        board.put( 26, 2 );
        board.put( 27, 1 );
        board.put( 28, 2 );
        board.put( 29, 2 );
        board.put( 30, 1 );
        board.put( 31, 2 );
        board.put( 32, 1 );
        board.put( 33, 2 );
        board.put( 34, 1 );
        board.put( 35, 2 );
        board.put( 36, 1 );
        
        money = 1000;
        
        rand = new Random();
    }
    
    /**
     * This constructor is only used for testing.
     * @param ran The testing number that is used in the test.
     */
    public Roulette( int ran )
    {
        board = new HashMap<Integer, Integer>();

        board.put( 0, 0 );
        board.put( 1, 1 );
        board.put( 2, 2 );
        board.put( 3, 1 );
        board.put( 4, 2 );
        board.put( 5, 1 );
        board.put( 6, 2 );
        board.put( 7, 1 );
        board.put( 8, 2 );
        board.put( 9, 1 );
        board.put( 10, 2 );
        board.put( 11, 2 );
        board.put( 12, 1 );
        board.put( 13, 2 );
        board.put( 14, 1 );
        board.put( 15, 2 );
        board.put( 16, 1 );
        board.put( 17, 2 );
        board.put( 18, 1 );
        board.put( 19, 1 );
        board.put( 20, 2 );
        board.put( 21, 1 );
        board.put( 22, 2 );
        board.put( 23, 1 );
        board.put( 24, 2 );
        board.put( 25, 1 );
        board.put( 26, 2 );
        board.put( 27, 1 );
        board.put( 28, 2 );
        board.put( 29, 2 );
        board.put( 30, 1 );
        board.put( 31, 2 );
        board.put( 32, 1 );
        board.put( 33, 2 );
        board.put( 34, 1 );
        board.put( 35, 2 );
        board.put( 36, 1 );
        
        money = 1000;
        
        rand = new Random();
        testingVariable = ran;
        
    }


    /**
     * betTypes are here 
     * 1 = number (35:1) 
     * 2 = column (2:1)
     * 3 = color //1 = red and 2 = black (1:1) 
     * 4 = even or odd //0 = even and 1 = odd (1:1) 
     * 5 = 1 to 18 (1:1) //18 = value 
     * 6 = 19 to 36 (1:1) // 36 = value
     * 
     * @param betA
     *            is the Amount to bet
     * @param betT
     *            is the type of bet
     * @param betS
     *            is the square the bet is placed on
     * 
     * @return the amount that should be paid or 0, and if they don't have
     *         enough money, or it is under the minimum it will return -1.
     */
    public int bet()
    {

        if ( betAmount >= 5  && betAmount <= money )
        {
            money = money - betAmount;
            int roll;
            if( testingVariable == -1)
            {
                roll = ( rand.nextInt() ) + 1;
            }
            else
            {
                roll = testingVariable;
            }
            if ( betType == 1 && roll == betSquare )
            {
                money += betAmount * 36;
                return betAmount * 36;
            }
            else if ( betType == 2 )
            {
                if ( ((roll / 12) + 1) == betSquare )
                {
                    money += betAmount * 3;
                    return betAmount * 3;
                }
            }
            else if ( betType == 3 )
            {
                if ( board.get( roll ) == betSquare )
                {
                    money += betAmount * 2;
                    return betAmount * 2;
                }
            }
            else if ( betType == 4 )
            {
                if ( roll % 2 == betSquare )
                {
                    money += betAmount *2;
                    return betAmount * 2;
                }
            }
            else if ( betType == 5 || betType == 6 )
            {
                if ( roll <= betSquare && roll > ( betSquare - 18 ) )
                {
                    money += betAmount * 2;
                    return betAmount * 2;
                }
            }
        }
        else
        {
            return -1;
        }
        return 0;
    }
    
    /**
     * Sets the Bet amount
     * @param o the amount of the bet
     */
    public void setBetAmount( int o)
    {
        betAmount = o;
    }
    
    /**
     * Set the bet type
     * @param o the bet type
     */
    public void setBetType( int o)
    {
        betType = o;
    }
    
    /**
     * Sets the square you want to bet on.
     * @param o the square that you want to bet, but if the user changes the bet type the bet square needs to be changed accordingly. 
     */
    public void setBetSquare( int o)
    {
        betSquare = o;
    }
    
    /**
     * gets the Bet amount
     * @return the amount of money
     */
    public int getBetAmount()
    {
        return betAmount;
    }
    
    /**
     * Gets the bet type.
     * @return the type of bet
     */
    public int getBetType()
    {
        return betType;
    }
    
    /**
     * Gets the square that bet on.
     * @return the square the bet  
     */
    public int getBetSquare()
    {
        return betSquare;
    }
    
    /**
     * Returns the money that you currently have.
     * @return money the money that you have 
     */
    public int getMoney()
    {
        return money;
    }
    
    /** 
     * Returns the HashMao for testing purposes
     * @return board the board that is used in this class
     */
    public HashMap<Integer, Integer> getBoard()
    {
        return board;
    }

    
}
