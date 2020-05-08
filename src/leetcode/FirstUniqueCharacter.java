package leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/first-unique-character-in-a-string/
public class FirstUniqueCharacter {
   public int firstUniqChar(String s) {
      int index = Integer.MAX_VALUE;
      Map<Character, Integer> charIndexMap = new HashMap<>();
      for (int i=1; i<=s.length(); i++) {
         if (charIndexMap.get(s.charAt(i-1)) != null) {
            charIndexMap.put(s.charAt(i - 1), Integer.MAX_VALUE);
            continue;
         }
         charIndexMap.put(s.charAt(i-1), i);
      }

      for (Integer ind: charIndexMap.values()) {
         if (ind < index)
            index = ind;
      }
      return index == Integer.MAX_VALUE ? -1 : index - 1;
   }

   public int firstUniqChar1(String s) {
      int res = Integer.MAX_VALUE;

      for(char c = 'a'; c <= 'z'; c++){
         int index = s.indexOf(c);

         if(index != -1 && index == s.lastIndexOf(c))
            res = Math.min(res, index);
      }

      return res == Integer.MAX_VALUE ? -1 : res;
   }

   public static void main(String[] args) {
      FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
      System.out.println(firstUniqueCharacter.firstUniqChar("leetcode"));
      System.out.println(firstUniqueCharacter.firstUniqChar("loveleetcode"));
      System.out.println(firstUniqueCharacter.firstUniqChar("aabbb"));
   }
}
