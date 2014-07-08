public class Triple<Type1>
{

  //Variables for storing the given variables
  private final Type1 first, second, third;

  //Constructor that initialises the variables 
  public Triple(Type1 givenFirst, Type1 givenSecond, Type1 givenThird)
  {
    first = givenFirst;
    second = givenSecond;
    third = givenThird;
  }


  //getters for the variables
  public Type1 getFirst()
  {
    return first;
  }

  public Type1 getSecond()
  {
    return second;
  }

  public Type1 getThird()
  {
    return third;
  }
}