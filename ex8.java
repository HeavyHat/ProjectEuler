public class ex8
{

  // See Readme for description system
  private final static String description = "Largest product in a series";
  
  public String getDescription()
  {
    return description;
  }

  //Gets the product of a digit string
  public static int digitProduct(String digitsString)
  {
    int currentResult = 1;
    for(int currentDigit = 0; currentDigit < digitsString.length(); currentDigit++)
      currentResult *= Character.digit(digitsString.charAt(currentDigit),10);
    return currentResult;
  }

  public static void main(String[] args)
  {
    int frontPointer = 0;
    int backPointer = Integer.parseInt(args[0]);
    String fullNumber = args[1];
    long largestSoFar = 0;
    String productNumbers = "";
    while(backPointer < fullNumber.length())
    {
      if(digitProduct(fullNumber.substring(frontPointer, backPointer)) > largestSoFar)
      {
        largestSoFar = digitProduct(fullNumber.substring(frontPointer,backPointer));
        productNumbers = fullNumber.substring(frontPointer, backPointer);
      }
      frontPointer++;
      backPointer++;
    }
    for(int digit= 0; digit < productNumbers.length(); digit++)
    {
      System.out.print(productNumbers.charAt(digit));
      if(digit != productNumbers.length() - 1)
        System.out.print(" X ");
    }
    System.out.println();
    System.out.println(largestSoFar);
  }
}