import java.math.BigInteger;


public class ex16 extends ProjectEulerSolution
{
  public ex16()
  {
    description = "Power digit sum";
  }

  @Override 
  public void run(String[] args)
  {
    //argument number check
    if(args.length != 1)
      throw new IllegalArgumentException("You must provide only one argument. Provided " + args.length);
    int powerOfTwo = Integer.parseInt(args[0]);
    powerOfTwo--;
    BigInteger result = new BigInteger("2").shiftLeft(powerOfTwo);
    String stringResult = "" + result;
    long sum = 0;
    for(int digit = 0; digit < stringResult.length(); digit++)
      sum += stringResult.charAt(digit) - '0';
    System.out.println(sum);
  }
}