package leetcode;

//https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {
   public int numIslands(char[][] grid) {
      int numberOfIsland = 0;
      if (grid == null || grid.length == 0)
         return numberOfIsland;

      for (int i=0; i<grid.length; i++) {
         for (int j=0; j < grid[i].length; j++) {
            if (grid[i][j] == '1') {
               numberOfIsland += sinkIsland(grid, i, j);
            }
         }
      }

      return numberOfIsland;
   }

   private int sinkIsland(char[][] grid, int i, int j) {
      if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
         return 0;

      grid[i][j] = '0';

      sinkIsland(grid, i-1, j);
      sinkIsland(grid, i+1, j);
      sinkIsland(grid, i, j-1);
      sinkIsland(grid, i , j+1);
      return 1;
   }


   public int numIslands1(char[][] grid) {
      int numIslands = 0;
      if (grid == null || grid.length == 0) {
         return numIslands;
      }
      boolean[][] visited = new boolean[grid.length][grid[0].length];
      for (int row = 0; row<grid.length; row++) {
         for (int col = 0; col < grid[row].length; col++) {
            if (!visited[row][col] && grid[row][col] == '1') {
               numIslands += 1;
               visited[row][col] = true;
               markConnectedLandAsVisited(grid, row, col, visited);
            }
         }
      }

      return numIslands;
   }

   private void markConnectedLandAsVisited(char[][] grid, int row, int col, boolean[][] visited) {
      int[] dirX = {0, 0, -1, 1};
      int[] dirY = {-1, 1, 0, 0};
      for (int i=0; i<4; i++) {
         int currRow = row + dirX[i];
         int currCol = col + dirY[i];
         if (isValid(currRow, currCol, grid.length, grid[0].length, visited, grid)) {
            visited[currRow][currCol] = true;
            markConnectedLandAsVisited(grid, currRow, currCol, visited);
         }
      }
   }

   private boolean isValid(int row, int col, int rowLimit, int colLimit, boolean[][] visited,char[][] grid) {
      return row >= 0 && row < rowLimit && col >=0 && col < colLimit && !visited[row][col] && grid[row][col] == '1';
   }

   public static void main(String[] args) {
      NumberOfIslands islands = new NumberOfIslands();
      System.out.println(islands.numIslands1(new char[][] {new char[]{'1'}, new char[]{'1'}}));

      System.out.println(islands.numIslands1(new char[][]{new char[]{'1', '1', '1', '1', '0'},
      new char[]{'1', '1', '0', '1', '0'}, new char[] {'1','1','0','0','0'}, new char[]{'0','0','0','0','0'}}));


      System.out.println(islands.numIslands1(new char[][]{new char[]{'1', '1', '0', '0', '0'},
              new char[]{'1', '1', '0', '0', '0'}, new char[] {'0','0','1','0','0'}, new char[]{'0','0','0','1','1'}}));
   }
}
