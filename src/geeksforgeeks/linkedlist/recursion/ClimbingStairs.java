package geeksforgeeks.linkedlist.recursion;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {

   private Map<Integer, Integer> stepsCache = new HashMap<>();
   public int climbStairs(int n) {
      return climbStairsHelper(0, n);
   }

   public int climbStairsHelper(int atStair, int n) {
      if (atStair > n)
         return 0;
      if (atStair == n)
         return 1;
      int numberOfSteps = stepsCache.get(atStair) == null ?
              climbStairsHelper(atStair + 1, n) + climbStairsHelper(atStair + 2, n):
              stepsCache.get(atStair);
      stepsCache.put(atStair, numberOfSteps);
      return numberOfSteps;
   }

   public static void main(String[] args) {
      ClimbingStairs climbingStairs = new ClimbingStairs();
      System.out.println(climbingStairs.climbStairs(3));
   }

}
