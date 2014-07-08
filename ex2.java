public class ex2 extends ProjectEulerSolution
{

  public ex2()
  {
    description = "Even Fibonacci numbers";
  }

  @Override
  public void run(String[] args)
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