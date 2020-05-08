package leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/ransom-note/
public class RansomNote {
   public boolean canConstruct(String ransomNote, String magazine) {
      if (ransomNote == null || ransomNote.isEmpty())
         return true;
      Map<Character, Integer> charCount = new HashMap<>();
      for (Character ch : ransomNote.toCharArray()){
         charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
      }

      for (Character ch : magazine.toCharArray()) {
         if (charCount.get(ch) != null)
            charCount.put(ch, charCount.get(ch) - 1);
      }

      // Check of all are 0
      for (Integer num : charCount.values()) {
         if (num > 0)
            return false;
      }

      return true;
   }
}

