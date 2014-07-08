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
    //argument number check
    if(args.length != 2)
      throw new IllegalArgumentException("You must provide precisly 2 argument. Provided " + args.length);
    //the length of the digits we want the product off
    int length = Integer.parseInt(args[0]);
    //the sequence of digits we are going to look through
    String fullNumber = args[1];
    //the largest product to far
    long largestSoFar = -1;
    //for every starting position < fullnumber.length - length
    for (int frontPointer = 0; frontPointer + length <= fullNumber.length(); frontPointer++) {
      long product = 1;
      //find the product of the next length digits 
      for (int currentPointer = 0; currentPointer < length; currentPointer++)
        product *= fullNumber.charAt(frontPointer + currentPointer) - '0';
      //find the maximum of the largestSoFar and the product we just found
      largestSoFar = Math.max(product, largestSoFar);
    }
    //print the largest number we found 
    System.out.println();
    System.out.println(largestSoFar);
  }
}