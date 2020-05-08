package geeksforgeeks.Stack;

import java.util.ArrayDeque;
import java.util.Stack;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
public class RemoveDuplicates {
   public String removeDuplicates(String S) {
      Stack<Character> stack = new Stack<>();
      for (char ch : S.toCharArray()) {
         if (!stack.isEmpty() && stack.peek() == ch) {
            stack.pop();
            while (!stack.isEmpty() && stack.peek() == ch) {
               stack.pop();
            }
         } else
            stack.push(ch);
      }

      StringBuilder sb = new StringBuilder();
      while (!stack.isEmpty()) {
         sb.append(stack.pop());
      }

      return sb.reverse().toString();
   }

   public String removeDuplicates1(String S) {
      Stack<Character> stack = new Stack<>();
      for (char ch: S.toCharArray()) {
         if (!stack.isEmpty() && stack.peek() == ch)
            stack.pop();
         else
            stack.push(ch);
      }

      StringBuilder sb = new StringBuilder();
      while (!stack.isEmpty()) {
         sb.append(stack.pop());
      }
      return sb.reverse().toString();
   }


   public String removeDuplicates2(String S) {
      char[] arr = S.toCharArray();
      int end = -1;
      for (char ch : arr) {
         if (end >= 0 && arr[end] == ch)
            --end;
         else
            arr[++end] = ch;
      }
      return new String(arr, 0, end+1);
   }

   public static void main(String[] args) {
      RemoveDuplicates removeDuplicates = new RemoveDuplicates();
      System.out.println(removeDuplicates.removeDuplicates("abbaca"));
      System.out.println(removeDuplicates.removeDuplicates1("abbaca"));
      System.out.println(removeDuplicates.removeDuplicates2("abbaca"));
   }
}
