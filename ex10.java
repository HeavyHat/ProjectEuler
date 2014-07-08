import java.util.Map;
import java.util.HashMap;

public class ex10 extends ProjectEulerSolution
{
  public ex10()
  {
    description = "Summation of primes";
  }

  public void run(String[] args)
  {
    //the upperbound of the prime numbers to be summed
    int upperBound = Integer.parseInt(args[0]);
    //map of all the integers up to this number corresponding to a bool that indicates whether its is prime
    Map<Integer, Boolean> mapOfPossibles = new HashMap<Integer,Boolean>();
    //initailise the map with 2 - n and true
    for(int number = 2; number <= upperBound; number++)
      mapOfPossibles.put(number, true);
    //for every number in the map find a mark all multiples of the number
    for(int number : mapOfPossibles.keySet())
    { 
      int workingNumber = number * 2;
      while(workingNumber <= upperBound)
      {
        if(mapOfPossibles.get(workingNumber))
          mapOfPossibles.put(workingNumber, false);
        workingNumber += number;
      }
    }
    //calculate the sum
    long sumOfPrimes = 0;
    for(int number : mapOfPossibles.keySet())
      if(mapOfPossibles.get(number))
        sumOfPrimes += number;
    System.out.println(sumOfPrimes);
  }
}