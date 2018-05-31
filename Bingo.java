package src;

import java.util.Random;


/**
 *  The bingo game for our casino class. The user can play this game via the casino windo. 
 *
 *  @author  Dave Desouza-Lawrence
 *  @version May 30, 2018
 *  @author  Period: 2
 *  @author  Assignment: CasiYES
 *
 *  @author  Sources: None
 */
public class Bingo
{
    public int[][] board;

    Random rand;


    /**
     * Standard bingo constructor. 
     */
    public Bingo()
    {
        board = new int[5][5];
        rand = new Random();
    }


    /**
     * Fills the board with random values.
     */
    public void drawBoard()
    {
        for ( int row = 0; row < 5; row++ )
        {
            for ( int col = 1; col <= 5; col++ )
            {
                board[row][col - 1] = rand.nextInt(  20  ) + 20 * row + 1;
            }
        }
        board[2][2] = 0;
    }


    /**
     * Adds an element to the board and check if should be replaced.
     * @return
     */
    public int increment()
    {  
            int random = (rand.nextInt(100)) + 1;
            for ( int col = 1; col <= 5; col++ )
            {
                for ( int row = 0; row < 5; row++ )
                {
                    if ( board[row][col - 1] == random )
                    {
                        board[row][col - 1] = 0;
                    }
                }
            }
            return random;
    }


    /**
     * Checks if there has been a win in the board
     * @return true if won or false if lost
     */
    public boolean check()
    {
        int check = 0;
        for ( int row = 0; row < 5; row++ )
        {
            for ( int col = 0; col < 5; col++ )
            {
                if ( board[row][col] == 0 )
                {
                    check++;
                }
                if ( check == 5 )
                {
                    return true;
                }
            }
            check = 0;
        }

        for ( int col = 0; col < 5; col++ )
        {
            for ( int row = 0; row < 5; row++ )
            {
                if ( board[row][col] == 0 )
                {
                    check++;
                }
                if ( check == 5 )
                {
                    return true;
                }
            }
            check = 0;
        }

        check = 0;
        for ( int both = 0; both < 5; both++ )
        {
            if ( board[both][both] == 0 )
            {
                check++;
            }
            if ( check == 5 )
            {
                return true;
            }
        }

        check = 0;
        int down = 4;
        for ( int other = 0; other < 5; other++ )
        {
            if ( board[down][other] == 0 )
            {
                check++;
            }
            if ( check == 5 )
            {
                return true;
            }
            down--;
        }

        return false;
    }


    /**
     * Returns the board
     * @return the board
     */
    public int[][] myBoard()
    {
        return board;
    }
    
    /**
     * Sets teh board to a array. Used only for testing
     * @param array the array 
     */
    public void setBoard( int[][] array)
    {
        board = array;
    }
    
    /**
     * Returns teh random object
     * @return the random object
     */
    public Random getRand()
    {
        return rand;
    }

}
