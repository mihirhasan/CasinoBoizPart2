public class Number
{
    private int num = 0;

    private String color = "";


    public Number( int number, String color )
    {
        num = number;
        this.color = color;
    }


    public int getNum()
    {
        return num;
    }


    public String getColor()
    {
        return color;
    }


    public boolean isEven()
    {
        if ( num % 2 == 0 )
        {
            return true;
        }
        return false;
    }


    public boolean isZero()
    {
        return num == 0;
    }
}
