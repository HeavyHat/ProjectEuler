import java.util.List;
import java.util.ArrayList;

public class ex14 extends ProjectEulerSolution
{

  public ex14()
  {
    description="Longest Collatz Sequence";
  }

  //lists for storing the last sequence found and the current biggest sequence found
  private static List<Long> biggestSoFar = new ArrayList<Long>();
  private static List<Long> currentSequence = new ArrayList<Long>();

  //method for finding the lengths of a given starting term and updating the lists 
  public long chainLength(long startingTerm)
  {
    currentSequence = new ArrayList<Long>();
    long nextTerm = startingTerm;
    long length = 0;
    //while the Collatz sequence term != 1 add the term to the list and work out next term
    while(nextTerm != 1)
    {
      currentSequence.add(nextTerm);
      if(nextTerm<= 0){ System.out.print(nextTerm+ "->"); break;}
      if(nextTerm % 2 == 0)
        nextTerm /= 2;
      else
        nextTerm = nextTerm*3 + 1;
      //increase length
      length++;
    }
    return length;
  }

  public void run(String[] args)
  {
    //argument number check
    if(args.length != 1)
      throw new IllegalArgumentException("You must provide precisly 1 argument. Provided " + args.length);
    long bestStartingTerm = 0;
    long maxInteger = Long.parseLong(args[0]);
    //if the next term is of greater length than the biggest term then this is the new biggest
    for(int currentInt = 1; currentInt < maxInteger; currentInt++)
      if(chainLength(currentInt) > biggestSoFar.size())
      {
        bestStartingTerm = currentInt;
        biggestSoFar = currentSequence;
      }
    //print results
    for(long number : biggestSoFar)
      System.out.print(number + "->");
    System.out.println(bestStartingTerm);
    System.out.println("1\n" + biggestSoFar.size());
  } 
}