package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/sort-characters-by-frequency/
public class FrequencySort {
   public String frequencySort(String s) {
      if (s == null || s.isBlank() || s.length() ==1)
         return s;
      Map<Character, Integer> frequencyMap = new LinkedHashMap<>();
      for (char ch : s.toCharArray()) {
         frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
      }
      List<Character> sortedList = new LinkedList<>();

      frequencyMap.entrySet().stream()
              .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
              .forEachOrdered(x -> sortedList.add(x.getKey()));

      StringBuilder result = new StringBuilder();
      for (Character ch : sortedList) {
         for (int i= 0; i<frequencyMap.get(ch); i++) {
            result.append(ch);
         }
      }
      return result.toString();
   }

   public static void main(String[] args) {
      FrequencySort frequencySort = new FrequencySort();
      System.out.println(frequencySort.frequencySort("tree"));
      System.out.println(frequencySort.frequencySort("cccaaa"));
      System.out.println(frequencySort.frequencySort("Aabb"));
   }
}
