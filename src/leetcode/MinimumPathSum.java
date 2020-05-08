package leetcode;

//https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum {
   public int minPathSum(int[][] grid) {
      if (grid == null || grid.length == 0)
         return 0;
      for (int i=0; i< grid.length; i++) {
         for (int j=0; j<grid[i].length; j++) {
            if (i > 0 && j > 0 && i < grid.length && j < grid[i].length) {
               grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
            } else if (i > 0){
               grid[i][j] += grid[i-1][j];
            } else if (j > 0)
               grid[i][j] += grid[i][j-1];
         }
      }
      return grid[grid.length - 1][grid[0].length - 1];
   }

   public static void main(String[] args) {
      MinimumPathSum pathSum = new MinimumPathSum();
      System.out.println(pathSum.minPathSum(new int[][]{new int[] {1,3,1}, new int[]{1,5,1}, new int[]{4,2,1}}));
   }
}
