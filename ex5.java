public class ex5 extends ProjectEulerSolution
{

  // See Readme for description system
  public ex5()
  { 
    description = "Smallest multiple";
  } 

  // returns whether a number is divisible by a given factor
  public static boolean isDivisible(int number,int factor)
  {
    return (number % factor == 0);
  }

  @Override
  public void run(String[] args)
  {
    //argument number check
    if(args.length != 1)
      throw new IllegalArgumentException("You must provide precisly 1 argument. Provided " + args.length);
    //first number to try
    int currentNumber = 1; 
    //the upperbound of natural number from 1 to uppbound that the number must divide by
    int upperBound = Integer.parseInt(args[0]);
    //has the number been found
    boolean found = false;
    while(!found)
    {
      //assume it has been found
      found = true;
      //test all the natural number until we know that one of them doesnt divide 
      for(int currentFactor = 1; currentFactor <= upperBound; currentFactor++)
        if(!isDivisible(currentNumber, currentFactor))
        {
          found = false;
          break;
        }
      //if it hasn't been found still increase the number we are testing
      if(!found)
        currentNumber++;
    }
    //print the final result
    System.out.println(currentNumber);
  }
}