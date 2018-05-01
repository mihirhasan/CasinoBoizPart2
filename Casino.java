public class Casino
{
private double money;
  
  public Casino()
  {
    money =1000;
  }
  
  public double getMoney()
  {
    return money;
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
