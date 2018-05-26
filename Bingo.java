import java.util.Random;


public class Bingo
{
    public int[][] board;

    Random rand;


    public Bingo()
    {
        board = new int[5][5];
        rand = new Random();
    }


    public void drawBoard()
    {
        for ( int row = 0; row < 5; row++ )
        {
            for ( int col = 1; col <= 5; col++ )
            {
                board[row][col - 1] = rand.nextInt(  20  ) + 20*row;
            }
        }
        board[2][2] = 0;
    }


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


    public int[][] myBoard()
    {
        return board;
    }
    
    public Random getRand()
    {
        return rand;
    }

}
