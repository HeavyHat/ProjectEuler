public class ex7 extends ProjectEulerSolution
{

  // See Readme for description system
  public ex7()
  {
    description = "10001st prime";
  }

  //returns true if prime
  public static boolean isPrime(int number)
  {
    //assume it is prime
    boolean prime = true;
    //start with all the numbers less than this number
    int factor = number;
    factor--;
    //while the factor we are trying is greater than 1 and the number is already known to be prime so far
    while(factor > 1 && prime)
    {
      //if it can be divided then the number is not prime
      if(number % factor == 0)
        prime = false;
      factor--;
    }
    return prime;
  }

  @Override
  public void run(String[] args)
  {
    //argument number check
    if(args.length != 1)
      throw new IllegalArgumentException("You must provide precisly 1 argument. Provided " + args.length);
    //the prime number to be found e.g. 10001st
    int primeNumberToBeFound = Integer.parseInt(args[0]);
    //how many prime numbers we have found so far 
    int currentPrimeNo = 1;
    //the last prime we have found
    int currentPrime = 1;
    //the current number we are testing to see if it is prime
    int currentNumber = 1;
    //while currentprime number is less than the number we are trying to find 
    while(currentPrimeNo <= primeNumberToBeFound + 1)
    {
      //if it is prime then perform the relevant operations of the counters
      if(isPrime(currentNumber))
      {
        currentPrimeNo++;
        currentPrime = currentNumber;
      }
      //finally increase the number
      currentNumber++;
    }
    //print the last prime we found
    System.out.println(currentPrime);
  }
}