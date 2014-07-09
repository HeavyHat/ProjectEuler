// small class to act as container for two types
public class Double<Type1>
{
  private final static Type1 first, second;

  public Double(Type1 givenFirst, Type1 givenSecond)
  {
    first = givenFirst;
    second = givenSecond;
  }

  public Type1 getFirst()
  {
    return first;
  }

  public Type1 getSecond()
  {
    return second;
  }
}