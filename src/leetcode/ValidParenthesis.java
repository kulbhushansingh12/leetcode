package leetcode;

import java.util.Stack;

//https://leetcode.com/problems/valid-parenthesis-string/
public class ValidParenthesis {
   public boolean checkValidString(String s) {
      Stack<Character> stack = new Stack();
      int starCount = 0;
      for (Character ch : s.toCharArray()) {
         if (ch == '(')
            stack.push(ch);
         else if (!stack.isEmpty() && stack.peek() != ')' && ch == '*')
            starCount++;
         else {
            if (!stack.isEmpty())
               stack.pop();
            else if (stack.isEmpty() && starCount > 0)
               --starCount;
            else if (ch == ')')
               return false;
         }
      }
      return stack.isEmpty() || starCount >= stack.size();
   }

   public static void main(String[] args) {
      ValidParenthesis validParenthesis = new ValidParenthesis();
      System.out.println(validParenthesis.checkValidString("()")); //true
      System.out.println(validParenthesis.checkValidString("(*)")); //true
      System.out.println(validParenthesis.checkValidString("(*))")); //true
      System.out.println(validParenthesis.checkValidString("(((******))"));//true
      System.out.println(validParenthesis.checkValidString("*"));//true
      System.out.println(validParenthesis.checkValidString(")**("));//false
      System.out.println(validParenthesis.checkValidString("((*)"));//true
      System.out.println(validParenthesis.checkValidString("))"));//false
      System.out.println(validParenthesis.checkValidString("(())))"));//false
      System.out.println(validParenthesis.checkValidString("((())()()(*)(*()(())())())()()((()())((()))(*"));//false
   }
}
