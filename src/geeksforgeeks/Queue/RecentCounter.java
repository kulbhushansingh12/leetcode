package geeksforgeeks.Queue;

import java.util.ArrayDeque;
import java.util.Queue;

//https://leetcode.com/problems/number-of-recent-calls/
public class RecentCounter {
   ArrayDeque<Integer> queue = new ArrayDeque();
   public RecentCounter() {

   }

   public int ping(int t) {
      queue.push(t);

      return queue.size();
   }
}
