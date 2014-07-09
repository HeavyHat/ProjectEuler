public class ex11 extends ProjectEulerSolution
{

  public static final int GRID_SIZE = 20;
  public static final int ADJACENT = 4;
  public static int[][] grid = new int[GRID_SIZE][GRID_SIZE];

  public ex11()
  {
    description = "Largest product in a grid";
  }  

  //returns true if travelling ADJACENT tiles results in being in bounds
  //NOTE: deltax/y should be in the range -1 <= x <= 1
  public boolean isInBounds(int x, int y, int deltaX, int deltaY)
  {
    return x + deltaX * ADJACENT >= 0 && x + deltaX * ADJACENT < GRID_SIZE
            && y + deltaY * ADJACENT >= 0 && y + deltaY * ADJACENT < GRID_SIZE;
  }

  //calculates the product of of an adjacent in a given direction
  //NOTE: deltax/y should be in the range -1 <= x <= 1
  public int adjacentProduct(int x, int y, int deltaX, int deltaY)
  {
    int currentProduct = 1;
    int xOffset = 0;
    int yOffset = 0;
    // if not in bounds or not in a valid direction return -1
    if(!isInBounds(x,y,deltaX,deltaY) || deltaX == 0 && deltaY == 0)
      return -1;
    
    for(int counter = 0; counter < ADJACENT; xOffset += deltaX
                                            ,yOffset += deltaY
                                            , counter++)
      currentProduct *= grid[x + xOffset][y + yOffset];
    //System.out.println(currentProduct);
    return currentProduct;
  }

  @Override
  public void run(String[] args)
  {
    int largestProduct = 0;
    //fill the grid with the command line arguments
    for(int argumentNumber = 0; argumentNumber < args.length; argumentNumber++)
      grid[argumentNumber % GRID_SIZE][argumentNumber / GRID_SIZE] 
        = Integer.parseInt(args[argumentNumber]);

    //tries every tile in every direction and passes it to the adjacent 
    for(int x = 0; x < GRID_SIZE; x++)
      for(int y = 0; y < GRID_SIZE; y++)
        for(int xDirection = -1; xDirection <= 1; xDirection++)
          for(int yDirection = -1; yDirection <= 1; yDirection++)
            largestProduct= Math.max(adjacentProduct(x,y,xDirection,yDirection)
                                     , largestProduct);
    //Print the result
    System.out.println(largestProduct);
  }

}