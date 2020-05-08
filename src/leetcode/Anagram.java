package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Anagram {

   public static boolean isAnagram1(String s, String t) {
      if (s.length() == t.length()) {
         Map<Character, Integer> charCount = new HashMap<>();
         for (int i=0; i<s.length(); i++) {
            int count = charCount.get(s.charAt(i)) != null ? charCount.get(s.charAt(i))  : 0;
            charCount.put(s.charAt(i), ++count);
            count = charCount.get(t.charAt(i)) != null ? charCount.get(t.charAt(i)) : 0;
            charCount.put(t.charAt(i), --count);
         }

         //check if all count is 0
         for (Map.Entry<Character, Integer> valueSet : charCount.entrySet()) {
            if(valueSet.getValue() != 0) {
               return false;
            }
         }
         return true;
      }
      return false;
   }

   public static boolean isAnagram2(String s, String t) {
      int[] counts = new int[256];
      for(char c: s.toCharArray()){
         counts[c]++;
      }
      for(char c: t.toCharArray()){
         counts[c]--;
      }

      for(int i: counts){
         if(i != 0) return false;
      }
      return true;
   }

   /**
    * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
    * https://leetcode.com/problems/find-all-anagrams-in-a-string/
    */
   public static List<Integer> anagramInString(String s, String p) {
      List<Integer> startIndices = new ArrayList<>();
      for (int i=0; i<s.length() - (p.length()-1); i++) {
         if (isAnagram2(s.substring(i, (i + p.length())), p)) {
            startIndices.add(i);
         }
      }
      return startIndices;
   }

   public static List<Integer> anagramInString2(String s, String p) {
      List<Integer> startIndices = new ArrayList<>();

      return startIndices;
   }

   public static void main(String[] args) {

      System.out.println(isAnagram1("anagram", "nagaram"));
      System.out.println(isAnagram1("rat", "car"));

      System.out.println(isAnagram2("anagram", "nagaram"));
      System.out.println(isAnagram2("rat", "car"));
   }

}
