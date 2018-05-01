public class Bingo
{
int[][] board;

public Bingo()
{
  board = new int[5][5];
}
  
public void drawBoard()
{
  for (int col = 1; col <= 5; col++)
  {
    for (int row = 0; row < 5; row++)
    {
      board[row][col -1] = (int)Math.random() * 20 * col;
    }
  }
  board[2][2] = 0;
}
  
  public boolean increment()
  {
    int rand = (int)Math.random() *100;
    for (int col = 1; col <= 5; col++)
     {
    for (int row = 0; row < 5; row++)
    {
      if( board[row][col-1] == rand)
      {
        board[row][col-1] = 0;
      }
    }
  }
    
    
    int check 0;
    for( int row = 0; row < 5; row ++)
    {
      for (int col = 0; col < 5; col ++)
      {
        if( board[row][col] = 0)
        {
          check++
        }
        if ( check == 5)
        {
          return true
        }
      }
      check =0;
    }
    
    for (int col = 0; col < 5; col ++)
    {
      for (int row = 0; row < 5; row++)
      {
        if( board[row][col] = 0)
        {
          check++
        }
        if ( check == 5)
        {
          return true
        }
      }
      check =0;
    }
    
    for (int both = 0; both < 5; both++)
    {
      if ( board[both][both] = 0)
      {
        check++;
      }
      if(check == 5)
      {
        return true;
      }
    }
    
    
    
    
  }
  
  
}
