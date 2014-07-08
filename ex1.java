import java.util.ArrayList;
import java.util.List;

public class ex1 extends ProjectEulerSolution
{
  public ex1()
  {
    description = "Multiples of 3 and 5";
  }

  @Override
  public void run(String[] args)
  {
    //Check to make sure that the correct number of arguments have been provided
    if(args.length != 1)
      throw new IllegalArgumentException("You must provide precisly 1 argument. Provided " + args.length);
    int upperBound = Integer.parseInt(args[0]) - 1;
    //list of all the multiples to be summed
    List<Integer> listOfMultiples = new ArrayList<Integer>();
    //fills the list
    for(int currentNumber = upperBound; currentNumber > 0; currentNumber--)
      if(currentNumber % 5 == 0 || currentNumber % 3 == 0)
        listOfMultiples.add(currentNumber);
    int totalSum = 0;
    //sums the list
    for(int multiple : listOfMultiples)
      totalSum += multiple;
    System.out.println(totalSum);
  }
}