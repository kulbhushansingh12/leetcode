package leetcode.challenges.september;

// https://leetcode.com/problems/maximum-product-subarray/
public class MaximumProductSubArray {
   public int maxProduct(int[] nums) {
      if(nums.length==0) {
         return 0;
      }
      int current_max = nums[0];
      int current_min = nums[0];
      int max = nums[0];

      for(int i=1;i<nums.length;i++) {
         int temp = current_max;
         current_max = Math.max(Math.max(current_max * nums[i], current_min * nums[i]), nums[i]);
         current_min = Math.min(Math.min(temp * nums[i], current_min * nums[i]), nums[i]);

         if(max<current_max) {
            max = current_max;
         }
      }
      return max;
   }


   public static void main(String[] args) {
      MaximumProductSubArray maximumProductSubArray = new MaximumProductSubArray();
      System.out.println(maximumProductSubArray.maxProduct(new int[]{2,3,-2,4}));
      System.out.println(maximumProductSubArray.maxProduct(new int[]{-2,0,-1}));
   }
}
