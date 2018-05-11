import java.util.HashMap;
import java.util.Map;


public class Roulette
{
    private HashMap<Integer, Number> board;
    
    private int bet;


    public Roulette()
    {
        board = new HashMap<Integer, Number>();
        
        board.put( 0, new Number( 0, "green") );
        board.put( 1, new Number( 1, "red") );
        board.put( 2, new Number( 2, "black") );
        board.put( 3, new Number( 3, "red") );
        board.put( 4, new Number( 4, "black") );
        board.put( 5, new Number( 5, "red") );
        board.put( 6, new Number( 6, "black") );
        board.put( 7, new Number( 7, "red") );
        board.put( 8, new Number( 8, "black") );
        board.put( 9, new Number( 9, "red") );
        board.put( 10, new Number( 10, "black") );
        board.put( 11, new Number( 11, "black") );
        board.put( 12, new Number( 12, "red") );
        board.put( 13, new Number( 13, "black") );
        board.put( 14, new Number( 14, "red") );
        board.put( 15, new Number( 15, "black") );
        board.put( 16, new Number( 16, "red") );
        board.put( 17, new Number( 17, "black") );
        board.put( 18, new Number( 18, "red") );
        board.put( 19, new Number( 19, "red") );
        board.put( 20, new Number( 20, "black") );
        board.put( 21, new Number( 21, "red") );
        board.put( 22, new Number( 22, "black") );
        board.put( 23, new Number( 23, "red") );
        board.put( 24, new Number( 24, "black") );
        board.put( 25, new Number( 25, "red") );
        board.put( 26, new Number( 26, "black") );
        board.put( 27, new Number( 27, "red") );
        board.put( 28, new Number( 28, "black") );
        board.put( 29, new Number( 29, "black") );
        board.put( 30, new Number( 30, "red") );
        board.put( 31, new Number( 31, "black") );
        board.put( 32, new Number( 32, "red") );
        board.put( 33, new Number( 33, "black") );
        board.put( 34, new Number( 34, "red") );
        board.put( 35, new Number( 35, "black") );
        board.put( 36, new Number( 36, "red") );
    }
    
    public void bet(int bet)
    {
        
    }
    
    
}
