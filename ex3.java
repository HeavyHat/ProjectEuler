import java.math.BigInteger;

public class ex3
{

  // See Readme for description system
  private final static String description = "Largest Prime Factor";
  
  public String getDescription()
  {
    return description;
  }

  public static void main(String[] args)
  {
    BigInteger number = new BigInteger(args[0]);
    Integer greatestDivisor = 2;
    Integer greatestFound = 0;
    while(number.compareTo(new BigInteger("1")) > 0)
    {
      if(number.mod(new BigInteger(greatestDivisor.toString())).equals(new BigInteger("0")))
      {
        number = number.divide(new BigInteger(greatestDivisor.toString()));
        greatestFound = greatestDivisor;
        greatestDivisor = 2;
      }
      else
        greatestDivisor++;
    }
    System.out.println(greatestFound);
  }
}