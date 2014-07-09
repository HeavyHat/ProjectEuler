public class ex12 extends ProjectEulerSolution
{

  public ex12()
  {
    description = "Highly divisible triangular number.";
  }

  //returns the number of factors this number has
  public int divisibility(int number)
  {
    //count of divisors found
    int count = 0;
    //use the sqrt for smaller numbers
    int end = (int)Math.sqrt(number);
    for (int currentFactor = 1; currentFactor < end; currentFactor++) {
      if (number % currentFactor == 0)
        count += 2;
    }
    if (end * end == number)
      count++;
    return count;
  }

  @Override
  public void run(String[] args)
  {
    //the number of factors the triangular number should have
    int desiredDivisibility = Integer.parseInt(args[0]);
    int lastNumber = 1;
    //the number in the series
    int numberInSeries = 2;
    boolean found = false;
    while(!found)
    {
      if(divisibility(lastNumber) >= desiredDivisibility)
        found=true;
      else
        lastNumber = lastNumber + numberInSeries;
      numberInSeries++;
    }
    //print result
    System.out.println(lastNumber);
  }
}