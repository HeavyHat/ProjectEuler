public class ex17 extends ProjectEulerSolution
{

  public static final String[] ONES = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", };
  public static final String[] TEEN_UNDER_20 = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
  public static final String[] TEENS = {"twenty", "thirty", "fourty", "fifty", "sixty"};

  public ex17()
  {
    description = "Number letter counts";
  }

  @Override
  public void run(String[] args)
  {
    long sum = 0;
    for(int currentNumber = 1; currentNumber < Integer.parseInt(args[0]); currentNumber++)
    {
      sum += new Number("" + currentNumber).getNumberOfLetters();
    }
    System.out.println(sum);
  }
}