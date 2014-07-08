public class ex7
{

  // See Readme for description system
  private final static String description = "10001st prime";
  
  public static String getDescription()
  {
    return description;
  }

  //returns true if prime
  public static boolean isPrime(int number, int factor)
  {
    boolean prime = true;
    factor--;
    while(factor > 1 && prime)
    {
      if(number % factor == 0)
        prime = false;
      factor--;
    }
    return prime;
  }

  public static void main(String[] args)
  {
    int primeNumberToBeFound = Integer.parseInt(args[0]);
    int currentPrimeNo = 1;
    int currentPrime = 1;
    int currentNumber = 1;;
    while(currentPrimeNo <= primeNumberToBeFound + 1)
    {
      if(isPrime(currentNumber,currentNumber))
      {
        currentPrimeNo++;
        currentPrime = currentNumber;
      }
      currentNumber++;
    }
    System.out.println(currentPrime);
  }
}