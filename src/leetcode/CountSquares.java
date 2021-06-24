package leetcode;

//https://leetcode.com/problems/count-square-submatrices-with-all-ones/
public class CountSquares {
   public int countSquares(int[][] matrix) {
      if (matrix.length ==0)
         return 0;
      int count = 0;
      int aux[][] = new int[matrix.length+1][matrix[0].length+1];
      for (int row=1; row<aux.length; row++) {
         for (int col=1; col<aux[row].length; col++) {
            if (matrix[row-1][col-1] == 1) {
               aux[row][col] = Math.min(aux[row][col-1], Math.min(aux[row-1][col], aux[row-1][col-1])) + 1;
               count += aux[row][col];
            } else {
               aux[row][col] = 0;
            }
         }
      }
      return count;
   }

   public static void main(String[] args) {
      CountSquares countSquares = new CountSquares();
      System.out.println(countSquares.countSquares(new int[][]{{0,1,1,1}, {1,1,1,1}, {0,1,1,1}}));
      System.out.println(countSquares.countSquares(new int[][]{{1,0,1}, {1,1,0}, {1,1,0}}));
   }
}
