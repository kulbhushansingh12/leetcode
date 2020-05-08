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

   public static void main(String[] args) {
      int[] ints = {1, 2, 3};
      NumberOfIslands islands = new NumberOfIslands();
      System.out.println(islands.numIslands(new char[][] {new char[]{'1'}, new char[]{'1'}}));

      System.out.println(islands.numIslands(new char[][]{new char[]{'1', '1', '1', '1', '0'},
      new char[]{'1', '1', '0', '1', '0'}, new char[] {'1','1','0','0','0'}, new char[]{'0','0','0','0','0'}}));


      System.out.println(islands.numIslands(new char[][]{new char[]{'1', '1', '0', '0', '0'},
              new char[]{'1', '1', '0', '0', '0'}, new char[] {'0','0','1','0','0'}, new char[]{'0','0','0','1','1'}}));
   }
}
