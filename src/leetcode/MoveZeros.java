package leetcode;

//https://leetcode.com/problems/move-zeroes/submissions/
public class MoveZeros {
   public void moveZeroes(int[] nums) {
      int nonZeroIndex = -1;
      for (int i=0; i<nums.length; i++) {
         if (nums[i] != 0) {
            int temp = nums[i];
            nums[i] = nums[++nonZeroIndex];
            nums[nonZeroIndex] = temp;
         }
      }
   }
}
