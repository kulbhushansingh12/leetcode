package leetcode;

//https://leetcode.com/problems/uncrossed-lines/
public class UncrossedLines {
   public int maxUncrossedLines(int[] A, int[] B) {
      int aux[][] = new int[A.length + 1][B.length + 1];
      for (int row = 1; row<aux.length; row++) {
         for (int col = 1; col<aux[row].length; col++) {
            int val = A[row-1] == B[col-1]? 1: 0;
            val += aux[row-1][col-1];
            aux[row][col] = Math.max(val, Math.max(aux[row-1][col], aux[row][col-1]));
         }
      }
      return aux[aux.length-1][aux[0].length-1];
   }

   public static void main(String[] args) {
      UncrossedLines uncrossedLines = new UncrossedLines();
      System.out.println(uncrossedLines.maxUncrossedLines(new int[]{1,4,2}, new int[]{1,2,4}));//2
      System.out.println(uncrossedLines.maxUncrossedLines(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2}));//3
      System.out.println(uncrossedLines.maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1}));// 2
   }
}
