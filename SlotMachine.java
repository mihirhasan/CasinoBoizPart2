package test;

public class SlotMachine
{
    Casino casi;


    public SlotMachine()
    {
        casi = new Casino();
    }

    String[] icons = { "Kumquat", "Diamond", "Cherries", "Melon", "Heart", "Penguin", "Bananas",
        "Horseshoe", "Dog", "Fulk" };

    String[] results = new String[3];


    public void spin()
    {
        casi.removeMoney( 10 );
        int rand0 = (int)( Math.random() * 10 );
        int rand1 = (int)( Math.random() * 10 );
        int rand2 = (int)( Math.random() * 10 );

        results[0] = icons[rand0];
        results[1] = icons[rand1];
        results[2] = icons[rand2];
        payout();
        display();
    }

    int toAdd = 0;


    public void payout()
    {
        // 90% money back ratio
        // House always makes a profit, user makes about 90% of their money back
        // 900:1 jackpot 1/1000 chance of winning
        if ( results[0] == "Fulk" && results[1] == "Fulk" && results[2] == "Fulk" )
        {
            toAdd = 9000;
        }
        // 450:1 jackpot 1/500 chance of winning
        if ( ( results[0] == "Penguin" && results[1] == "Penguin" && results[2] == "Penguin" )
            || ( results[0] == "Diamond" && results[1] == "Diamond" && results[2] == "Diamond" ) )
        {
            toAdd = 4500;
        }
        // 90:1 1/100 chance of winning
        if ( ( results[0] != "Fulk" && results[0] != "Penguin" && results[0] != "Diamond" )
            && ( results[0] == results[1] && results[1] == results[2] ) )
        {
            toAdd = 900;
        }
        // 2:1 Jackpot for 2 of a kind ~1/3 chance of winning
        if ( ( results[0] == results[1] && results[1] != results[2] )
            || ( results[1] == results[2] && results[0] != results[2] )
            || ( results[0] == results[2] && results[1] != results[2] ) )
        {
            toAdd = 20;
        }
        casi.addMoney( toAdd );
    }


    private void display()
    {
        System.out.println( results[0] + " || " + results[1] + " || " + results[2] );
        if ( toAdd > 0 )
        {
            System.out.println( "Congratulations! You made " + toAdd + " buckeroos!" );
        }
        else
        {
            System.out.println( "Sorry, you LOSE" );
        }
        System.out.println( "Current Balance:" + casi.getMoney() + "" );

    }

}
