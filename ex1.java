import java.util.ArrayList;
import java.util.List;

public class ex1
{

  // See Readme for description system
  private final static String description = "Multiples of 3 and 5";
  public static String getDescription()
  {
    return description;
  }

  public static void main(String[] args)
  {
    int upperBound = Integer.parseInt(args[0]) - 1;
    List<Integer> listOfMultiples = new ArrayList<Integer>();
    for(int currentNumber = upperBound; currentNumber > 0; currentNumber--)
      if(currentNumber % 5 == 0 || currentNumber % 3 == 0)
        listOfMultiples.add(currentNumber);
    int totalSum = 0;
    for(int multiple : listOfMultiples)
      totalSum += multiple;
    System.out.println(totalSum);
  }
}