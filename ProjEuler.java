import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/*
 * This class is used to run the other solutions and none of the solutions should be called directly
 */
public class ProjEuler
{

  public static void main(String[] args)
  {
    try
    {
      // gets the excercise to be run and the description by calling various methods
      int number = Integer.parseInt(args[0]);
      Class<?> currentSolution = Class.forName("ex" + number);
      Class<?> solution = Class.forName("ProjectEulerSolution");
      // check to make sure the class is indeed a ProjectEulerSolution
      if(currentSolution.getSuperclass() == solution) 
      {
        ProjectEulerSolution thisSolution = (ProjectEulerSolution)currentSolution.newInstance();
        //gets the start time of the program
        long startTime = System.currentTimeMillis();
        Method descMethod = currentSolution.getMethod("getDescription");
        String description = (String)descMethod.invoke(thisSolution);
        System.out.println("=== Excercise " + args[0] + " - " + description +  " ===\n");
        Method mainMethod = currentSolution.getMethod("run", String[].class);
        //runs the solution
        if(args.length > 1)
        {
          mainMethod.invoke(thisSolution,(Object) Arrays.copyOfRange(args, 1, args.length));
        }
        else
          mainMethod.invoke(thisSolution,(Object) new String[0]);
        long endTime = System.currentTimeMillis();
        //prints the time taken in seconds
        System.out.println("\n=== Time Taken: " + String.format("%10.2f",((endTime - startTime)/1000.0F)) + " ===");
      }
      else
      {
        System.out.println("Not a Project Euler solution.");
      }

    }
    //The following error handling catches all reflective errors
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
    //IllegalArgumentException thrown by any of the solutions for a general error handling solution
    catch(IllegalArgumentException exception)
    {
      System.err.println("An Incorrect number of argument were passed to this excercise.\n"
                          + "Excercise returned message: " + exception.getMessage());
    }
    // a final catch all for any overlooked exceptions. Although this code should ideally never run
    catch(Exception exception)
    {
      System.err.println("Something unforseen has happened :-(");
      exception.printStackTrace();
    }
  }
}