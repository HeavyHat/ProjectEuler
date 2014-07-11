public class ex15 extends ProjectEulerSolution
{

  public ex15()
  {
    description="Lattice Paths";
  }

  //recursive solution (WARNING: SLOWS DOWN QUICKLY)
  public static long calculatePaths(int gridSize, int x, int y)
  {
    long numberOfPaths = 0;
    if(x < gridSize)
      numberOfPaths += calculatePaths(gridSize, x+1, y);
    if(y < gridSize)
      numberOfPaths += calculatePaths(gridSize, x, y+1);
    if(y == gridSize && x == gridSize)
      numberOfPaths++;
    return numberOfPaths;
  }

  public static long calculatePathsIterativly(int gridSize)
  {
    gridSize++;
    //A grid that contains all combinations of lattice paths at a given point
    long[][] grid = new long[gridSize][gridSize];
    // fill up the grid by adding [x-1][y-1] together 
    for(int x = 0; x < gridSize; x++)
      for(int y = 0; y < gridSize; y++)
        if(x-1 >= 0)
          if(y-1 >= 0)
            grid[x][y] = grid[x-1][y] + grid[x][y-1]; 
          else
            grid[x][y] = grid[x-1][y];
        else
          if(y-1 >= 0)
            grid[x][y] = grid[x][y-1];
          else
            grid[x][y] = 1;
    return grid[gridSize-1][gridSize-1];
  }

  @Override
  public void run(String[] args)
  {
    int gridSize = Integer.parseInt(args[0]);
    System.out.println(calculatePathsIterativly(gridSize));
  }
}