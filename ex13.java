import java.math.BigInteger;

public class ex13 extends ProjectEulerSolution
{
  public ex13()
  {
    description = "Large Sum";
  }

  public void run(String[] args)
  {
    BigInteger sumSoFar = new BigInteger("0");
    for(String number : args)
      sumSoFar = sumSoFar.add(new BigInteger(number));
    System.out.println(sumSoFar.toString());
  }
}