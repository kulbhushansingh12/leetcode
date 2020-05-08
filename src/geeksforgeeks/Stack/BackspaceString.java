package geeksforgeeks.Stack;

import leetcode.BackSpaceCompare;

import java.util.Stack;

//https://leetcode.com/problems/backspace-string-compare/
public class BackspaceString {
   public boolean backspaceCompare(String S, String T) {
      Stack<Character> sStack = new Stack<>();
      Stack<Character> tStack = new Stack<>();

      getStack(S, sStack);
      getStack(T, tStack);
      if (sStack.size() == tStack.size()) {
         while(!sStack.isEmpty() && !tStack.isEmpty()) {
            if (sStack.pop() != tStack.pop())
               return false;
         }
         return true;
      }
      return false;
   }

   private void getStack(String S, Stack<Character> sStack) {
      for (int i=0;i < S.length(); i++) {
         if (S.charAt(i) == '#') {
            if (!sStack.isEmpty())
               sStack.pop();
            continue;
         }
         sStack.push(S.charAt(i));
      }
   }

   public static void main(String[] args) {
      BackspaceString bsc = new BackspaceString();
      System.out.println(bsc.backspaceCompare("", ""));
      System.out.println(bsc.backspaceCompare("ab#c", "ad#c"));
      System.out.println(bsc.backspaceCompare("ab##", "c#d#"));
      System.out.println(bsc.backspaceCompare("a##c", "#a#c"));
      System.out.println(bsc.backspaceCompare("a#c", "b"));
      System.out.println(bsc.backspaceCompare("bbbextm", "bbb#extm"));
   }
}
