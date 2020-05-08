package leetcode;

import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3289/
public class CountingElements {
   public int countElements(int[] arr) {
      int count = 0;

      Map<Integer, Integer> elementCounts = new TreeMap<>();
      for (int n: arr) {
         int currentCount = elementCounts.get(n) == null? 0: elementCounts.get(n);
         elementCounts.put(n, ++currentCount);
      }

      for (Map.Entry<Integer, Integer> entrySet: elementCounts.entrySet()) {
         int num = entrySet.getKey();
         int numCount = entrySet.getValue();
         int consecutiveCount = elementCounts.get(num+1) != null? elementCounts.get(num+1):0;
         if (consecutiveCount != 0) {
            count += numCount;
         }
      }

      return count;
   }

   public static void main(String[] args) {
      CountingElements ce = new CountingElements();
      System.out.println(ce.countElements(new int[] {1,2,3}));
      System.out.println(ce.countElements(new int[] {1,1,3,3,5,5,7,7}));
      System.out.println(ce.countElements(new int[] {1,3,2,3,5,0}));
      System.out.println(ce.countElements(new int[] {1,1,2,2}));
   }
}
