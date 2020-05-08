package leetcode;

//https://leetcode.com/problems/maximal-square/
public class MaximalSquare {
   public int maximalSquare(char[][] matrix) {
      if (matrix.length == 0)
         return 0;
      int result = 0;
      int [][]aux = new int[matrix.length + 1][matrix[0].length + 1];
      for (int i=1; i<aux.length; i++) {
         for (int j=1; j<aux[i].length; j++) {
            if (matrix[i-1][j-1] == '1') {
               aux[i][j] = Math.min(Math.min(aux[i][j-1], aux[i-1][j-1]), aux[i-1][j]) + 1;
               result = Math.max(result, aux[i][j]);
            }
         }
      }
      return result*result;
   }
}
