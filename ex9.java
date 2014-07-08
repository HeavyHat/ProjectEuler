import java.util.List;
import java.util.ArrayList;

public class ex9 extends ProjectEulerSolution
{

  public ex9()
  {
    description = "Special Pythagorean triplet";
  }

  //returns where a given triple is a pythagorean triplet 
  public static boolean isPythagoreanTriplet(Triple<Integer> triplet)
  {
    return triplet.getThird() >= triplet.getFirst() && triplet.getThird() >= triplet.getSecond()
            && (int)Math.pow(triplet.getFirst(),2) + (int)Math.pow(triplet.getSecond(),2) == (int)Math.pow(triplet.getThird(),2);
  }

  @Override
  public void run(String[] args)
  {
    //argument number check
    if(args.length != 1)
      throw new IllegalArgumentException("You must provide precisly 1 argument. Provided " + args.length);
    // the number that a + b + c must be equal to
    int specialNumber = Integer.parseInt(args[0]);
    int first, second, third;
    first = second = third = 1;
    //the list of possible triples
    List<Triple<Integer>> listOfPossibles = new ArrayList<Triple<Integer>>();
    //try every combination that adds to the specail number and if it is a pythagorean triplet add it to the list
    for(; first <= specialNumber; first++)
    {
      for(; second <= (specialNumber - first); second++)
      {
        for(; third <= (specialNumber - first - second); third++)
          if(first + second + third == specialNumber)
            listOfPossibles.add(new Triple<Integer>(first, second, third));
        third = 1;
      }
      second = 1;
    }
    //print the result 
    for(Triple<Integer> triplet : listOfPossibles)
      if(isPythagoreanTriplet(triplet))
      {
        System.out.println(triplet.getFirst() + " + " + triplet.getSecond() + " + " + triplet.getThird() + " = " + specialNumber);
        System.out.println(triplet.getFirst() + " x " + triplet.getSecond() + " x " + triplet.getThird() + " = " 
                            + (triplet.getFirst()*triplet.getSecond()*triplet.getThird()) );
      }

  }
} 