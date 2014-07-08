public class ex8
{

  // See Readme for description system
  private final static String description = "Largest product in a series";
  
  public static String getDescription()
  {
    return description;
  }

  public static void main(String[] args)
  {
    int length = Integer.parseInt(args[0]);
    String fullNumber = args[1];
    long largestSoFar = -1;
    for (int frontPointer = 0; frontPointer + length <= fullNumber.length(); frontPointer++) {
      long product = 1;
      for (int currentPointer = 0; currentPointer < length; currentPointer++)
        product *= fullNumber.charAt(frontPointer + currentPointer) - '0';
      largestSoFar = Math.max(product, largestSoFar);
    }
    System.out.println();
    System.out.println(largestSoFar);
  }
}