package test;

public class SlotMachine
{
    Casino casi;
    String[] icons = { "Kumquat", "Diamond", "Cherries", "Melon", "Heart", "Penguin", "Bananas",
        "Horseshoe", "Dog", "Fulk" };

    String[] results;
    
    /**
     * Constructor gives the player 100 coins to begin with and also intiializes the results
     * array that will eventually hold the icons received.
     */
    public SlotMachine()
    {
        casi = new Casino(100);
        results = new String[3];;
    }


    /**
     * 
     * codes functionality behind the spin button. Chooses three random icons when spin 
     * button is clicked. Calls payout method to decide how much the winnings are for 
     * that unique icon combination
     */
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
    }

    int toAdd = 0;
    /**
     * 
     * accesses the results array to be used in window/testing
     * @return results array
     */
    public String[] getResult()
    {
        return results;
    }
    /**
     * 
     * sets the winnings for each combination. The Casino operates on a 90% back system. 
     * E.g if the user spends 100 dollars, he or she theoretically receives 90 dollars back.
     * The probabilities of receiving each "jackpot" are set to this same ratio. 
     * The largest jackpot is Fulk Fulk Fulk. Go Mr. Fulk!
     */
    public void payout()
    {
        toAdd = 0;
        // 90% money back ratio
        // House always makes a profit, user makes about 90% of their money back
        // 900:1 jackpot 1/1000 chance of winning
        if ( results[0] == "Fulk" && results[1] == "Fulk" && results[2] == "Fulk" )
        {
            toAdd = 9000;
        }
        // 450:1 jackpot 1/500 chance of winning
        else if ( ( results[0] == "Penguin" && results[1] == "Penguin" && results[2] == "Penguin" )
            || ( results[0] == "Diamond" && results[1] == "Diamond" && results[2] == "Diamond" ) )
        {
            toAdd = 4500;
        }
        // 90:1 1/100 chance of winning
        else  if ( ( results[0] != "Fulk" && results[0] != "Penguin" && results[0] != "Diamond" )
            && ( results[0] == results[1] && results[1] == results[2] ) )
        {
            toAdd = 900;
        }
        else if ( ( results[0] == results[1] && results[1] != results[2] )
            || ( results[1] == results[2] && results[0] != results[2] )
            || ( results[0] == results[2] && results[1] != results[2] ) )
        {
            toAdd = 20;
        }
        casi.addMoney( toAdd );
    }
    /**
     * 
     * accesses the amount of money that is paid back in the payout method to be used 
     * for display methods.
     * @return toAdd. Integer of coins to be added when payout is called.
     */
    public int getPay()
    {
        return toAdd;
    }
    /**
     * 
     * gets the total money the user has left
     * @return the balance of the user
     */
    public int getTotal()
    {
        return casi.getMoney();
    }
    /**
     * 
     * sets money back to original amount when users restart the game
     */
    public void reset()
    {
        casi.setMoney( 100 );
    }

}
