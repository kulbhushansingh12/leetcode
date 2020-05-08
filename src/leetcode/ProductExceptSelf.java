package leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/product-of-array-except-self/
public class ProductExceptSelf {

   public int[] productExceptSelf(int[] nums) {
      if (nums.length == 0 || nums.length == 1)
         return nums;
      int[] arr = new int[nums.length];
      arr[0] = 1;
      for (int i=1; i<nums.length; i++) {
         arr[i] = arr[i - 1] * nums[i-1];
      }

      int rightProd = 1;
      for (int i = nums.length - 2; i >=0; i--) {
         rightProd = nums[i + 1] * rightProd;
         arr[i] = arr[i] * rightProd;
      }
      return arr;
   }

   public static void main(String[] args) {
      ProductExceptSelf productExceptSelf = new ProductExceptSelf();
      System.out.println(Arrays.toString(productExceptSelf.productExceptSelf(new int[]{})));
   }

}
