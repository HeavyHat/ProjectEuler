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
    //argument number check
    if(args.length != 1)
      throw new IllegalArgumentException("You must provide precisly 1 argument. Provided " + args.length);
    //uppbound of integets to find the sum square difference for 
    int upperBound = Integer.parseInt(args[0]);
    //sum of all the number upto the uppbound
    int sumOfTerms = upperBound*(upperBound + 1)/2;
    //calculate the sum of all the seperate squares
    int sumOfSquares= 0;
    for(int currentNumber = 1; currentNumber <= upperBound; currentNumber++)
      sumOfSquares += square(currentNumber);
    //print the difference
    System.out.println(square(sumOfTerms) - sumOfSquares);
  }
}