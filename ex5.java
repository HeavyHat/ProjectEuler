public class ex5
{

  // See Readme for description system
  private final static String description = "Smallest multiple";
  
  public String getDescription()
  {
    return description;
  }

  public static int upperBound;

  // returns whether a number is divisible by a given factor
  public static boolean isntDivisible(int number,int factor)
  {
    return (number % factor == 0);
  }

  public static void main(String[] args)
  {
    int currentNumber = 1; 
    upperBound = Integer.parseInt(args[0]);
    boolean found = false;
    while(!found)
    {
      found = true;
      for(int currentFactor = 1; currentFactor <= upperBound; currentFactor++)
        if(!isntDivisible(currentNumber, currentFactor))
        {
          found = false;
          break;
        }
      if(!found)
        currentNumber++;
    }
    System.out.println(currentNumber);
  }
}