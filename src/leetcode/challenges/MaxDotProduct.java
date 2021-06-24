package leetcode.challenges;

//https://leetcode.com/problems/max-dot-product-of-two-subsequences/
public class MaxDotProduct {
   public int maxDotProduct(int[] nums1, int[] nums2) {
      int [][]aux = new int[nums1.length+1][nums2.length+1];

      // As we can have -ve numbers, fill 1st row and 1 col with max -ve
      // Fill first row with max -ve
      for (int col =0;col<aux[0].length; col++) {
         aux[0][col] = Integer.MIN_VALUE;
      }

      //Fill first col with max -ve
      for (int row=0; row<aux.length; row++) {
         aux[row][0] = Integer.MIN_VALUE;
      }

      for (int row = 1; row < aux.length; row++) {
         for (int col=1; col < aux[row].length; col++) {
            int prevNum = Math.max(aux[row-1][col-1], 0);
            int max = Math.max(nums1[row-1] * nums2[col-1], prevNum + nums1[row-1] * nums2[col-1]);
            aux[row][col] = Math.max(max, Math.max(aux[row][col-1], aux[row-1][col]));
         }
      }
      return aux[aux.length-1][aux[0].length - 1];
   }

   public static void main(String[] args) {
      MaxDotProduct maxDotProduct = new MaxDotProduct();
      System.out.println(maxDotProduct.maxDotProduct(new int[]{2,1,-2,5}, new int[]{3,0,-6}));//18
      System.out.println(maxDotProduct.maxDotProduct(new int[]{3,-2}, new int[]{2, -6, 7}));//21
      System.out.println(maxDotProduct.maxDotProduct(new int[]{-1, -1}, new int[]{1, 1}));//-1
   }
}
