public class ex5 extends ProjectEulerSolution
{

  // See Readme for description system
  public ex5()
  { 
    description = "Smallest multiple";
  } 

  public int upperBound;

  // returns whether a number is divisible by a given factor
  public static boolean isntDivisible(int number,int factor)
  {
    return (number % factor == 0);
  }

  @Override
  public void run(String[] args)
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