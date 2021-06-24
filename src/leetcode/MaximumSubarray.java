package leetcode;

//https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {
   public static int maxSubArray1(int[] nums) {
      int currSum = 0;
      int maxSum = Integer.MIN_VALUE;
      for(int i = 0; i < nums.length; i++) {
         currSum += nums[i];
         if (maxSum < currSum)
            maxSum = currSum;
         if (currSum < 0)
            currSum = 0;
      }
      return maxSum;

   }

   public static void main(String[] args) {
      System.out.println(maxSubArray1(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
      System.out.println(maxSubArray1(new int[] {-1}));
      System.out.println(maxSubArray1(new int[] {5, -3, 5}));
   }
}
