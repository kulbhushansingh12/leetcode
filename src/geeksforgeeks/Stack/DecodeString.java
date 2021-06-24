package geeksforgeeks.Stack;

import java.util.Stack;

// https://leetcode.com/problems/decode-string/
public class DecodeString {
   public String decodeString(String s) {
      Stack<String> stack = new Stack<>();
      for (char ch : s.toCharArray()) {
         String currStr = "" + ch;
         if (ch == ']') {
            String str = getComputeString(stack);
            int repeat = getNumberOfTimesToRepeat(stack);
            currStr = str.repeat(Integer.valueOf(repeat));
         }
         stack.push(currStr);
      }
      String result = "";
      while (!stack.isEmpty()) {
         result += stack.pop();
      }

      return new StringBuilder(result).reverse().toString();
   }

   private int getNumberOfTimesToRepeat(Stack<String> stack) {
      String digits = "0123456789";
      String result = "";
      while (!stack.isEmpty()) {
         if (stack.isEmpty() || !digits.contains(stack.peek())) {
            break;
         }
         result += stack.pop();
      }
      if (result.length() > 1) {
         result = new StringBuilder(result).reverse().toString();
      }
      return Integer.parseInt(result);
   }

   private String getComputeString(Stack<String> stack) {
      String str = "";
      while (!stack.isEmpty()) {
         if ("[".equals(stack.peek())) {
            break;
         }
         str += stack.pop();
      }
      // remove opening square bracket
      stack.pop();
      return str;
   }

   public static void main(String[] args) {
      DecodeString decodeString = new DecodeString();
      System.out.println(decodeString.decodeString("10[a]")); // a..a
      System.out.println(decodeString.decodeString("3[a]2[bc]"));//aaabcbc
      System.out.println(decodeString.decodeString("3[a2[c]]"));//accaccacc
      System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));//abcabccdcdcdef
      System.out.println(decodeString.decodeString("abc3[cd]xyz"));//abccdcdcdxyz
      System.out.println(decodeString.decodeString("xyz")); //xyz
   }
}
