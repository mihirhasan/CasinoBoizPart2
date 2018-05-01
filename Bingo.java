public class Bingo
{
String[][] board;

public Bingo()
{
  board = new String[5][5]();
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
  board[2][2] = "o";
}
  
  
}
