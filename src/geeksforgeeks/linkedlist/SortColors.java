package geeksforgeeks.linkedlist;

import java.util.Arrays;

//https://www.geeksforgeeks.org/sort-a-linked-list-of-0s-1s-or-2s/
// Similar with array# https://leetcode.com/problems/sort-colors/
public class SortColors {
   public void sortColors(int[] nums) {
      int zeroCount = -1, oneCount = -1, twoCount = -1;
      for (int i=0; i<nums.length; i++) {
         if (nums[i] == 0) {
            nums[++twoCount] = 2;
            nums[++oneCount] = 1;
            nums[++zeroCount]=0;
         } else if (nums[i] == 1) {
            nums[++twoCount] = 2;
            nums[++oneCount] = 1;
         } else {
            nums[++twoCount] = 2;
         }
      }

   }

   public static void main(String[] args) {
      int nums[] = new int[] {2,0,2,1,1,0};
      SortColors sc =new SortColors();
      sc.sortColors(nums);
      System.out.println(Arrays.toString(nums));
   }

}
