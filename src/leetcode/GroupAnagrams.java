package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
   public List<List<String>> groupAnagrams(String[] strs) {
      if (strs == null)
         return null;
      List<List<String>> result = new ArrayList<>();
      Map<String, List<String>> map = new HashMap<>();

      //Sort char array and then compare
      for (int i=0; i<strs.length; i++) {
         char[] arr = strs[i].toCharArray();
         Arrays.sort(arr);
         String str = new String(arr);
         List<String> anagrams = map.get(str) == null ? new ArrayList<>(): map.get(str);
         anagrams.add(strs[i]);
         map.put(str, anagrams);
      }

      for (List<String> anagrams : map.values()) {
         result.add(anagrams);
      }

      return result;
   }

   public static void main(String[] args) {
      GroupAnagrams ga = new GroupAnagrams();
      List<List<String>> result = ga.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
      System.out.println();
   }
}
