package test;


public class Casino

{
private int money;
  
  public Casino(int num)
  {
    money = num;
  }
  
  public int getMoney()
  {
    return money;
  }
public void setMoney(int num)
{
    money = num;
}

  public void addMoney(double toAdd)
  {
    money += toAdd;
  }
  public void removeMoney(double toRemove)
  {
      money -= toRemove;
  }
  
}
