import java.util.HashMap;
import java.util.Map;


public class Roulette
{
    private HashMap<Integer, Number> board;
    
    private int betType;
    
    private int betAmount;

    private int betSquare;
    
    public Roulette()
    {
        board = new HashMap<Integer, Integer>();
        
        board.put( 0, 0 );
        board.put( 1, 1 );
        board.put( 2, 2 );
        board.put( 3, 1 );
        board.put( 4, 2);
        board.put( 5, 1) ;
        board.put( 6, 2 );
        board.put( 7, 1) ;
        board.put( 8, 2 );
        board.put( 9, 1) ;
        board.put( 10, 2) ;
        board.put( 11, 2) ;
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
        board.put( 27, 1);
        board.put( 28, 2 );
        board.put( 29, 2 );
        board.put( 30, 1 );
        board.put( 31, 2 );
        board.put( 32, 1);
        board.put( 33, 2 );
        board.put( 34, 1);
        board.put( 35, 2 );
        board.put( 36, 1 );
    }
    
    /**
    betTypes are here
    1 = number (35:1)
    2 = column (2:1)
    3 = color //1 = red and 2 = black (1:1)
    4 = even or odd //0 = even and 1 = odd (1:1) 
    5 = 1 to 18 (1:1) //18 = value
    6 = 19 to 36 (1:1) // 36 = value
    
    @param betA is the Amount to bet
    @param betT is the type of bet
    @param betS is the square the bet is placed on
    
    @return the amount that should be paid or 0, and if they don't have enough money, or it is under the minimum. 
    */
    public int bet(int betA, int betT, int betS)
    {
        betAmount = betA;
        betType = betT; 
        betSquare = betS;
        
        if ( betAmount >= 5 && betAmount >= coin )//coin amount 
        {
            int roll = (int)(Math.random() * 36);
            if( betType == 1 && roll == betSquare)
            {
                return betAmount * 36;
            }
            else if( betType == 2)
            {
                if (roll / 12 == betSquare)
                {
                    return betAmount * 3;
                }
            }
            else if( betType == 3)
            {
                if( board.get(roll) == betSquare)
                {
                    return betAmount * 2;
                }
            }
            else if( betType == 4)
            {
                if( roll % 2 == betSquare)
                {
                    return betAmount * 2;
                }
            }
            else if( betType == 5 || betType == 6)
            {
                if ( roll <= betSquare && roll > (betSquare - 18))
                {
                    return betAmount *2;
                }
            }
        }
        else
        {
            return -1;
        }
    }
    
    
}
