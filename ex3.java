import java.math.BigInteger;

public class ex3 extends ProjectEulerSolution
{
  public ex3()
  {
    description = "Largest Prime Factor";
  }

  @Override
  public void run(String[] args)
  {
    //argument number check
    if(args.length != 1)
      throw new IllegalArgumentException("You must provide precisly 1 argument. Provided " + args.length);
    //number to find the largest prime factor of
    BigInteger number = new BigInteger(args[0]);
    Integer greatestDivisor = 2;
    Integer greatestFound = 0;
    //while(number > 1)
    while(number.compareTo(new BigInteger("1")) > 0)
    {
      //if(number % greatestDivisor == 0) // if divisible
      if(number.mod(new BigInteger(greatestDivisor.toString())).equals(new BigInteger("0")))
      {
        //divide th number by this divisor
        number = number.divide(new BigInteger(greatestDivisor.toString()));
        //the greatest divisor so far has been found
        greatestFound = greatestDivisor;
        //reinit to 2
        greatestDivisor = 2;
      }
      else
        greatestDivisor++;
    }
    System.out.println(greatestFound);
  }
}