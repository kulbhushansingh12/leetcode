package geeksforgeeks.Stack;

import java.util.Stack;

//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
public class MinAddToMakeValid {
   public int minAddToMakeValid(String S) {
      Stack<Character> stack = new Stack<>();
      for (int i=0; i<S.length(); i++) {
         if (S.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
            stack.pop();
            continue;
         }
         stack.push(S.charAt(i));
      }
      return stack.size();
   }

   public static void main(String[] args) {
      MinAddToMakeValid valid = new MinAddToMakeValid();
      System.out.println(valid.minAddToMakeValid("())"));
      System.out.println(valid.minAddToMakeValid("((("));
      System.out.println(valid.minAddToMakeValid("()"));
      System.out.println(valid.minAddToMakeValid("()))(("));
   }
}
