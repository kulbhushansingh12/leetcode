package leetcode.challenges.september;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/insert-interval/
public class InsertInterval {
   public int[][] insert(int[][] intervals, int[] newInterval) {
      List<int[]> result = new ArrayList<>();
      for(int[] interval : intervals) {

         int start= Math.max(interval[0], newInterval[0]);
         int end = Math.min(interval[1], newInterval[1]);

         // check overlap
         //if start is less than or equal to end then we can say there is overlap
         if((newInterval[0] >= interval[0] && newInterval[0] <= interval[1]) ||
                 (newInterval[1] >= interval[0] && newInterval[1] <= interval[1]) ||
                 (newInterval[0] <= interval[0] && newInterval[1] >= interval[1])) {
            newInterval[0]=Math.min(interval[0], newInterval[0]);
            newInterval[1]=Math.max(interval[1], newInterval[1]);
         }else{
            if(interval[0]<=newInterval[0]) result.add(interval);
            else {
               result.add(newInterval);
               newInterval=interval;
            }
         }


      }

      result.add(newInterval);

      int[][] resultArray = new int[result.size()][2];
      int i=0;
      while(i<result.size()) resultArray[i]= result.get(i++);

      return resultArray;


   }

   public int[][] insert1(int[][] intervals, int[] newInterval) {
      List<int[]> result = new ArrayList<>();
      for (int[] interval : intervals) {

         // Check for intersection
         // if newInterval start or end is in between interval or interval is in between newInterval

         if ((newInterval[0] >= interval[0] && newInterval[0] <= interval[1])
            || (newInterval[1] >= interval[0] && newInterval[1] <= interval[1])
            || (newInterval[0] <= interval[0] &&  newInterval[1] >= interval[1]) ) {

            // New interval will become min and max of start and end index respectively
            newInterval[0] = Math.min(newInterval[0], interval[0]);
            newInterval[1] = Math.max(newInterval[1], interval[1]);
         } else {
            // Add the number to result set
            result.add(interval);
         }

      }

      result.add(newInterval);

      Collections.sort(result, Comparator.comparingInt(o -> o[0]));

      int[][] res = new int[result.size()][2];
      for (int i=0; i<result.size(); i++) {
         res[i] = result.get(i);
      }
      return res;
   }

   public static void main(String[] args) {
      InsertInterval insertInterval = new InsertInterval();
      int[][] res = insertInterval.insert1(new int[][]{{1,3}, {6,9}}, new int[]{2, 5});
      printTwoByTwoMatrix(res);

      res = insertInterval.insert1(new int[][]{{2,4}, {6,9}}, new int[]{0, 1});
      printTwoByTwoMatrix(res);

      res = insertInterval.insert1(new int[][]{{2,4}, {6,9}}, new int[]{10, 11});
      printTwoByTwoMatrix(res);

      res = insertInterval.insert1(new int[][]{{1,2}, {3,5}, {6,7}, {8,10}, {12, 16}}, new int[]{4, 8});
      printTwoByTwoMatrix(res);
   }

   private static void printTwoByTwoMatrix(int[][] res) {
      System.out.print("[");
      for (int[] interval : res) {
         System.out.print(Arrays.toString(interval));
         System.out.print(",");
      }
      System.out.println("]");
   }
}
