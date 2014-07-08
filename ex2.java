public class ex2
{

  // See Readme for description system
  private final static String description = "Even Fibonacci numbers";

  public static String getDescription()
  {
    return description;
  }

  public static void main(String[] args)
  {
    int currentValue, previousValue;
    int tempValue;
    currentValue = previousValue = 1;
    int currentTotal = 0;
    int upperBound = Integer.parseInt(args[0]);
    while(currentValue < upperBound)
    {

      tempValue = currentValue;
      currentValue += previousValue;
      previousValue = tempValue;
      if(currentValue % 2 == 0)
        currentTotal += currentValue;
    }
    System.out.println(currentTotal);
  }
}