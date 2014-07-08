import java.util.TreeSet;

public class ex4
{

  // See Readme for description system
  private final static String description = "Largest Palindrome Product";
  
  public String getDescription()
  {
    return description;
  }

  // Calculates whther a string is a palindrome
  public static boolean isPalindrome(String possiblePalindrome)
  {
    if(possiblePalindrome.charAt(0) 
        == possiblePalindrome.charAt(possiblePalindrome.length() - 1))
      if(possiblePalindrome.length() > 2)
        return isPalindrome(possiblePalindrome.substring(1, possiblePalindrome.length() - 1));
      else
        return true;
    else
      return false;
  }

  public static void main(String[] args)
  {
    int numberOfDigits = Integer.parseInt(args[0]);
    int upperBound = new Double(Math.pow(Math.pow(10,  numberOfDigits) - 1, 2)).intValue();
    int lowerBound = new Double(Math.pow(10, numberOfDigits - 1)).intValue();
    int leftCoeff, rightCoeff;
    TreeSet<Integer> listOfPalindromes = new TreeSet<Integer>();
    rightCoeff = new Double(Math.pow(10, numberOfDigits)-1).intValue();
    leftCoeff = new Double(Math.pow(10, numberOfDigits)-1).intValue();
    for(; leftCoeff >= lowerBound; leftCoeff-- )
    {
      for(; rightCoeff >= lowerBound; rightCoeff--)
        if(isPalindrome("" + (leftCoeff * rightCoeff)))
        {
          listOfPalindromes.add(leftCoeff * rightCoeff);
          //System.out.println(leftCoeff + " " + rightCoeff);
        }
      rightCoeff = new Double(Math.pow(10, numberOfDigits)-1).intValue();
    }
    System.out.println(listOfPalindromes.last());

  }
}