package leetcode;

//https://leetcode.com/contest/weekly-contest-189/problems/number-of-students-doing-homework-at-a-given-time/
public class BusyStudent {
   public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
      if (startTime.length == 0)
         return 0;
      int count = 0;
      for (int i=0 ;i<startTime.length; i++) {
         if (startTime[i]>= queryTime && endTime[i] <= queryTime) {
            ++count;
         }
      }
      return count;
   }
}
