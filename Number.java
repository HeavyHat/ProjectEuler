public class Number
{
  public static final String[] ONES = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
  public static final String[] TEENS = {"ten","eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
  public static final String[] TYS = {"twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};

  private Number subNumber = null;
  private String longNumber;

  public Number(String number)
  {
    switch(number.length())
    {
      case 1: if(number != "0")
                longNumber = ONES[Integer.parseInt(number) - 1];
              else
                longNumber = "";
              break; 
      case 2: if(Integer.parseInt(number) > 9)
                if(Integer.parseInt(number) > 19)
                {
                  longNumber = TYS[Integer.parseInt("" + number.charAt(0)) - 2];
                  subNumber = new Number(number.substring(1,2));
                }
                else
                {
                  longNumber = TEENS[Integer.parseInt("" + number.charAt(1))];
                }
              break;
      case 3: longNumber = ONES[Integer.parseInt("" + number.charAt(0)) - 1];
              longNumber += " hundred ";
              if(number.charAt(1) != '0' && number.charAt(2) != '0')
              {
                longNumber += "and";
                subNumber = new Number(number.substring(1,3));
              }
              break;
      case 4: longNumber = ONES[Integer.parseInt("" + number.charAt(0)) - 1];
              longNumber += " thousand";
              if(number.charAt(1) != '0' && number.charAt(2) != '0' && number.charAt(3) != '0')
                subNumber = new Number(number.substring(1,4));
              break;
      default: ;
              break;
    }
  }

  public int getNumberOfLetters()
  {
    if(longNumber != null && longNumber != "")
    {
      longNumber = longNumber.replace(" ", "");
      return longNumber.length() + (subNumber != null ? subNumber.getNumberOfLetters() : 0);
    }
    else
    {
      return 0;
    }
  }

  @Override
  public String toString()
  {
    if(subNumber == null)
      return longNumber;
    else
      return longNumber + " " + subNumber;
  }

}