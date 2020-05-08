package leetcode;

//https://leetcode.com/problems/majority-element/
public class MajorityElement {
   public int majorityElement(int[] nums) {
      // Moores Algorithm
      // find candidate
      int maxElement = nums[0], count = 1;
      for (int i=1; i<nums.length; i++) {
         if (nums[i] == maxElement)
            ++count;
         else {
            --count;
            if (count == 0) {
               maxElement = nums[i];
               count = 1;
            }
         }
      }
      //Check if it is the majority element
      count = 0;
      for (int num : nums) {
         if (num == maxElement)
            ++count;
      }
      return count > (nums.length/2)? maxElement: -1;
   }

   public static void main(String[] args) {
      MajorityElement majorityElement = new MajorityElement();
      System.out.println(majorityElement.majorityElement(new int[] {3,2,3}));
      System.out.println(majorityElement.majorityElement(new int[] {2,2,1,1,1,2,2}));
   }
}
