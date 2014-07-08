public class ex6
{

  // See Readme for description system
  private final static String description = "Sum square Difference";
  
  public String getDescription()
  {
    return description;
  }

  //squares two numbers 
  public static int square(int number)
  {
    return number * number;
  }

  public static void main(String[] args)
  {
    int upperBound = Integer.parseInt(args[0]);
    int sumOfTerms = upperBound*(upperBound + 1)/2;
    int sumOfSquares= 0;
    for(int currentNumber = 1; currentNumber <= upperBound; currentNumber++)
      sumOfSquares += square(currentNumber);
    System.out.println(square(sumOfTerms) - sumOfSquares);
  }
}