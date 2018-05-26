package test;

public class Casino

{
    private int money;

    /**
     * Casino object gives user a starting amount of money, depending on what game is 
     * played
     * @param num the amount of money that the user starts with
     */
    public Casino( int num )
    {
        money = num;
    }

    /**
     * 
     * accesses the amount of money that the user has at a given moment.
     * @return the amount of moeny the user has. Used in game calsses
     */
    public int getMoney()
    {
        return money;
    }

    /**
     * 
     * sets the amount of money the user has to something else
     * @param num amount of money that user's balance is to be set to
     */
    public void setMoney( int num )
    {
        money = num;
    }

    /**
     * 
     * adds money to the users balance
     * @param num amount of money that is to be added to balance
     */
    public void addMoney( double toAdd )
    {
        money += toAdd;
    }

    /**
     * 
     * removes money from the users balance
     * @param num amount of money that is to be removed from balance
     */
    public void removeMoney( double toRemove )
    {
        money -= toRemove;
    }

}
