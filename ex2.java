public class ex2 extends ProjectEulerSolution
{

  public ex2()
  {
    description = "Even Fibonacci numbers";
  }

  @Override
  public void run(String[] args)
  {
    //argument number check
    if(args.length != 1)
      throw new IllegalArgumentException("You must provide precisly 1 argument. Provided " + args.length);
    //variables to store the current and the previous numbers in the fibonacci sequence 
    int currentValue, previousValue; 
    //used for caluculating the next number in sequence
    int tempValue;
    //initialise the first 2 numbers to 1
    currentValue = previousValue = 1;
    int currentTotal = 0;
    //upperbound for the fibonacci sequence
    int upperBound = Integer.parseInt(args[0]);
    while(currentValue < upperBound)
    {
      //generates next number
      tempValue = currentValue;
      currentValue += previousValue;
      previousValue = tempValue;
      //if this number is divisible by 2 add to the current total
      if(currentValue % 2 == 0)
        currentTotal += currentValue;
    }
    System.out.println(currentTotal);
  }
}