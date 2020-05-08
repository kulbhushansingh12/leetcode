package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/last-stone-weight/
public class LastStoneWeight {
   public int lastStoneWeight(int[] stones) {
      List<Integer> stonesList = new ArrayList<>();
      for (int stone : stones) {
         stonesList.add(stone);
      }
      Collections.sort(stonesList);

      while(stonesList.size() > 1) {
         int newElement = Math.abs(stonesList.get(stonesList.size() -1) - stonesList.get(stonesList.size() -2));
         stonesList.remove(stonesList.size() -1);
         stonesList.remove(stonesList.size() - 1);
         if (newElement != 0) {
            int index = Collections.binarySearch(stonesList, newElement);
            if (index > 0)
               stonesList.add(index + 1, newElement);
            else if (index ==0)
               stonesList.add(index, newElement);
            else {
               index = (index + 1) * -1;
               if (index < (stonesList.size() - 1))
                  stonesList.add(index, newElement);
               else
                  stonesList.add(newElement);
            }
         }
      }

      return stonesList.size() == 0? 0 : stonesList.get(0);
   }


   public static void main(String[] args) {
      LastStoneWeight sw = new LastStoneWeight();
      System.out.println(sw.lastStoneWeight(new int[] {2,7,4,1,8,1}));
      System.out.println(sw.lastStoneWeight(new int[] {1, 3}));
      System.out.println(sw.lastStoneWeight(new int[] {3,7,8}));
   }
}
