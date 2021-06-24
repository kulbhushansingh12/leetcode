package leetcode;

// https://leetcode.com/problems/maximum-length-of-repeated-subarray/
public class MaxLengthRepeatedSubArray {
   public int findLength(int[] A, int[] B) {
      int[][] aux = new int[A.length + 1][B.length + 1];

      for (int row = 1; row < aux.length; row++) {
         for (int col = 1; col < aux[row].length; col++) {
            if (A[row-1] == B[col-1]) {
               aux[row][col] = Math.min(Math.min(aux[row-1][col-1], aux[row][col-1]), aux[row-1][col]) + 1;
               //aux[row][col] = Math.max(aux[row - 1][col - 1], aux[row][col-1]) + 1;
            } else {
               aux[row][col] = Math.max(Math.max(aux[row-1][col-1], aux[row][col-1]), aux[row-1][col]);
            }
         }
      }

      return aux[A.length][B.length];
   }

   public static void main(String[] args) {
      MaxLengthRepeatedSubArray repeatedSubArray = new MaxLengthRepeatedSubArray();
      System.out.println(repeatedSubArray.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
      System.out.println(repeatedSubArray.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,2,7}));
      System.out.println(repeatedSubArray.findLength(new int[]{1,1,1,1,1}, new int[]{1,1,1,1,1}));
      System.out.println(repeatedSubArray.findLength(new int[]{1,1,1,1,0}, new int[]{0,1,1,1,1}));
      System.out.println(repeatedSubArray.findLength(new int[]{0,1,1,1,1}, new int[]{1,0,1,0,1}));
   }
}
