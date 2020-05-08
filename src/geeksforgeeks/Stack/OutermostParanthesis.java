package geeksforgeeks.Stack;

import java.util.ArrayDeque;

//https://leetcode.com/problems/remove-outermost-parentheses/
public class OutermostParanthesis {

   public String removeOuterParentheses(String S) {
      int openingCount = 0;
      int closingCount = 0;
      ArrayDeque<Character> primitiveStack = new ArrayDeque<>();
      StringBuilder sb = new StringBuilder();
      for (char ch : S.toCharArray()) {
         if (ch == '(')
            openingCount++;
         else
            closingCount++;
         if (openingCount == closingCount){
            writeToResult(primitiveStack, sb);
            openingCount = 0;
            closingCount = 0;
         } else
            primitiveStack.push(ch);
      }


      return sb.toString();
   }

   private void writeToResult(ArrayDeque<Character> primitiveStack, StringBuilder sb) {
      primitiveStack.removeLast();
      while (!primitiveStack.isEmpty()) {
         sb.append(primitiveStack.removeLast());
      }
   }


   public static String removeOuterParentheses1(String S) {
      int outerCount = 0;
      StringBuilder sb = new StringBuilder();

      for (int i=0; i<S.length(); i++) {
         if (S.charAt(i) == '(') {
            if (outerCount > 0)
               sb.append('(');
            ++outerCount;
         } else {
            if (outerCount > 1) {
               sb.append(')');
            }
            --outerCount;
         }
      }
      return sb.toString();
   }

   public static void main(String[] args) {
      OutermostParanthesis outermostParanthesis = new OutermostParanthesis();
      System.out.println(outermostParanthesis.removeOuterParentheses("(()())(())"));
      System.out.println(outermostParanthesis.removeOuterParentheses("(()())(())(()(()))"));
      System.out.println(outermostParanthesis.removeOuterParentheses("()()"));

      System.out.println(outermostParanthesis.removeOuterParentheses1("(()())(())"));
      System.out.println(outermostParanthesis.removeOuterParentheses1("(()())(())(()(()))"));
      System.out.println(outermostParanthesis.removeOuterParentheses1("()()"));
   }

}
