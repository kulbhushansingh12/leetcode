package geeksforgeeks.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
   public boolean isValid(String s) {
      Stack<Character> brkts = new Stack<>();
      Map<Character, Character> dictionary = new HashMap<>();
      dictionary.put('(', ')');
      dictionary.put('{', '}');
      dictionary.put('[', ']');
      for(char ch : s.toCharArray()) {
         if(ch == '(' || ch == '{' || ch == '[') {
            brkts.push(ch);
         } else {
            if(brkts.size()>0) {
               char temp = dictionary.get(brkts.pop());
               if(ch != temp) {
                  return false;
               }
            } else {
               return false;
            }
         }
      }
      if(brkts.size()>0) {
         return false;
      }
      return true;
   }
}
