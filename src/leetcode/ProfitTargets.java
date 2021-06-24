package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.w3c.dom.ls.LSOutput;

public class ProfitTargets {

   public static int stockPairs(List<Integer> stocksProfit, long target) {
      // Write your code here
      Map<Long, Integer> compliment = new HashMap<>();
      int index = 0, count = 0;
      for (Integer num : stocksProfit) {
         if (compliment.getOrDefault(Long.valueOf(num), Integer.MAX_VALUE) != Integer.MAX_VALUE) {
            ++count;
            compliment.remove(Long.valueOf(num));
         } else {
            compliment.put((target - num), index);
         }
         ++index;
      }
      return count;
   }

   public static void main(String[] args) {
      System.out.println(stockPairs(Arrays.asList(new Integer[]{5, 7, 9, 13, 11, 6, 6, 3, 3}), 12));;
   }
}
