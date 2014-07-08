public class ex11 extends ProjectEulerSolution
{

  public static final int GRID_SIZE = 20;
  public static final int ADJACENT = 4;
  public static int[][] grid = new int[GRID_SIZE][GRID_SIZE];

  public ex11()
  {
    description = "Largest product in a grid";
  }  

  public boolean isInBounds(int x, int y, int deltaX, int deltaY)
  {
    return x + deltaX * ADJACENT >= 0 && x + deltaX * ADJACENT < GRID_SIZE
            && y + deltaY * ADJACENT >= 0 && y + deltaY * ADJACENT < GRID_SIZE;
  }

  public int adjacentProduct(int x, int y, int deltaX, int deltaY)
  {
    int currentProduct = 1;
    int xOffset = 0;
    int yOffset = 0;
    if(!isInBounds(x,y,deltaX,deltaY))
      return -1;
    
    for(int counter = 0; xOffset < ADJACENT; xOffset += deltaX, yOffset += deltaY)
      currentProduct *= grid[x + xOffset][y + yOffset];

    return currentProduct;
  }

  @Override
  public void run(String[] args)
  {
    int largestProduct = 0;
    //fill the grid with the command line arguments
    for(int argumentNumber = 0; argumentNumber < args.length; argumentNumber++)
      grid[argumentNumber % GRID_SIZE][argumentNumber / GRID_SIZE] = Integer.parseInt(args[argumentNumber]);
    for(int x = 0; x < GRID_SIZE; x++)
      for(int y = 0; y < GRID_SIZE; y++)
        for(int xDirection = -1; xDirection <= 1; xDirection++)
          for(int yDirection = -1; yDirection <= 1; yDirection++)
            largestProduct = Math.max(adjacentProduct(x,y,xDirection,yDirection), largestProduct);
    System.out.println(largestProduct);
  }

}