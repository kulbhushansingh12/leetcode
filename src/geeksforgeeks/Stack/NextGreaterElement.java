package geeksforgeeks.Stack;

import geeksforgeeks.linkedlist.NextGreaterNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-i/
public class NextGreaterElement {
   public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      Map<Integer, Integer> nextHigherNum = new HashMap<>();
      Stack<Integer> stack = new Stack<>();

      for (int num : nums2) {
         while (!stack.isEmpty() && stack.peek() < num)
            nextHigherNum.put(stack.pop(), num);

         stack.push(num);
      }

      for (int i=0; i<nums1.length; i++) {
         nums1[i] = nextHigherNum.getOrDefault(nums1[i], -1);
      }
      return nums1;
   }

   public static void main(String[] args) {
      NextGreaterElement nextGreaterElement = new NextGreaterElement();
      System.out.println(Arrays.toString(nextGreaterElement.nextGreaterElement(new int[] {4,1,2}, new int[] {1,3,4,2})));
   }
}
