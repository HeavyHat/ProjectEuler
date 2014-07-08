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
      Class<?> currentSolution = Class.forName("ex" + number);
      Class<?> solution = Class.forName("ProjectEulerSolution");
      if(currentSolution.getSuperclass() == solution)
      {
        ProjectEulerSolution thisSolution = (ProjectEulerSolution)currentSolution.newInstance();
        long startTime = System.currentTimeMillis();
        Method descMethod = currentSolution.getMethod("getDescription");
        String description = (String)descMethod.invoke(thisSolution);
        System.out.println("=== Excercise " + args[0] + " - " + description +  " ===\n");
        Method mainMethod = currentSolution.getMethod("run", String[].class);
        if(args.length > 1)
        {
          mainMethod.invoke(thisSolution,(Object) Arrays.copyOfRange(args, 1, args.length));
        }
        else
          mainMethod.invoke(thisSolution,(Object) new String[0]);
        long endTime = System.currentTimeMillis();
        System.out.println("\n=== Time Taken: " + String.format("%10.2f",((endTime - startTime)/100.0F)) + " ===");
      }
      else
      {
        System.out.println("Not a Project Euler solution.");
      }

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
    catch(InstantiationException exception)
    {
      System.err.println(exception.getCause());
    }
  }
}