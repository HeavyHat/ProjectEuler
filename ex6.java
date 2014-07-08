public class ex6 extends ProjectEulerSolution
{

  // See Readme for description system
  public ex6()
  {
    description = "Sum square Difference";
  }

  //squares two numbers 
  public static int square(int number)
  {
    return number * number;
  }

  @Override
  public void run(String[] args)
  {
    int upperBound = Integer.parseInt(args[0]);
    int sumOfTerms = upperBound*(upperBound + 1)/2;
    int sumOfSquares= 0;
    for(int currentNumber = 1; currentNumber <= upperBound; currentNumber++)
      sumOfSquares += square(currentNumber);
    System.out.println(square(sumOfTerms) - sumOfSquares);
  }
}