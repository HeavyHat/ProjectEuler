import java.util.TreeSet;

public class ex4 extends ProjectEulerSolution
{
  public ex4()
  {
    description = "Largest Palindrome Product";
  }

  // Calculates whther a string is a palindrome
  public static boolean isPalindrome(String possiblePalindrome)
  {
    //if the first chracter = the last charcter return whether the string in the middle is a palindrome
    if(possiblePalindrome.charAt(0) 
        == possiblePalindrome.charAt(possiblePalindrome.length() - 1))
      if(possiblePalindrome.length() > 2)
        return isPalindrome(possiblePalindrome.substring(1, possiblePalindrome.length() - 1));
      else
        return true;
    else
      return false;
  }

  @Override
  public void run(String[] args)
  {
    //argument number check
    if(args.length != 1)
      throw new IllegalArgumentException("You must provide precisly 1 argument. Provided " + args.length);
    //number of digits in each of the products factors
    int numberOfDigits = Integer.parseInt(args[0]);
    //the upperbound for the integer factors and the lowerbound
    int upperBound = new Double(Math.pow(Math.pow(10,  numberOfDigits) - 1, 2)).intValue();
    int lowerBound = new Double(Math.pow(10, numberOfDigits - 1)).intValue();
    //temperarory variable for the left and right coefficients
    int leftCoeff, rightCoeff;
    //a tree set of the integer palindromes
    TreeSet<Integer> listOfPalindromes = new TreeSet<Integer>();
    //initialise the coefficients
    rightCoeff = new Double(Math.pow(10, numberOfDigits)-1).intValue();
    leftCoeff = new Double(Math.pow(10, numberOfDigits)-1).intValue();
    //nested for loop to systematically try all the combinations
    for(; leftCoeff >= lowerBound; leftCoeff-- )
    {
      for(; rightCoeff >= lowerBound; rightCoeff--)
        if(isPalindrome("" + (leftCoeff * rightCoeff)))
          listOfPalindromes.add(leftCoeff * rightCoeff);
      rightCoeff = new Double(Math.pow(10, numberOfDigits)-1).intValue();
    }
    //print the greatest palindrome in the set
    System.out.println(listOfPalindromes.last());

  }
}