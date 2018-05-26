package test;

public class Card
{
    String nam;

    int value;


    public Card( String name, int val )
    {
        nam = name;
        value = val;
    }


    public int getVal()
    {
     
        return value;
    }


    public String getName()
    {
        return nam;
    }
    public void setAce(int num)
    {
        value = num;
    }
}
