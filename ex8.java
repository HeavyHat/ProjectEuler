public class ex8 extends ProjectEulerSolution
{

  // See Readme for description system
  public ex8()
  { 
    description = "Largest product in a series";
  }

  @Override
  public void run(String[] args)
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