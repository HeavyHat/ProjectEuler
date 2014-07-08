import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ProjEuler
{

  public static void main(String[] args)
  {
    try
    {
      int number = Integer.parseInt(args[0]);
      Class<?> solution = Class.forName("ex" + number);
      Method mainMethod = solution.getMethod("main", String[].class);
      Method descMethod = solution.getMethod("getDescription");
      String description = (String)descMethod.invoke(null);
      long startTime = System.currentTimeMillis();
      System.out.println("=== Excercise " + args[0] + " - " + description +  " ===\n");
      if(args.length > 1)
      {
        mainMethod.invoke(null,(Object) Arrays.copyOfRange(args, 1, args.length));
      }
      else
        mainMethod.invoke(null,(Object) new String[0]);
      long endTime = System.currentTimeMillis();
      System.out.println("\n=== Time Taken: " + String.format("%10.2f",((endTime - startTime)/100.0F)) + " ===");

    }
    catch(ClassNotFoundException exception)
    {
      System.err.println("Class Not Found \"ex" + args[0] + "\": " + exception.getCause());
      System.err.println("Have you started this excercise?");
    }
    catch(NoSuchMethodException exception)
    {
      System.err.println("Method not found \"main\": " + exception.getCause());
      System.err.println("Have you finished this excercise?");
    }
    catch(IllegalAccessException exception)
    {
      System.err.println(exception.getCause());
    }
    catch(InvocationTargetException exception)
    {
      System.err.println(exception.getCause());
    }
  }
}