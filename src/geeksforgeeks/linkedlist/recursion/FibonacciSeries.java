package geeksforgeeks.linkedlist.recursion;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/fibonacci-number/
public class FibonacciSeries {
   Map<Integer, Integer> computeCache = new HashMap<>();
   public int fib(int N) {
      if (N < 2)
         return N;
      int num = 0;
      if (computeCache.get(N) == null) {
         num = fib(N - 1) + fib(N - 2);
         computeCache.put(N, num);
      }
      return computeCache.get(N);
   }

   public static void main(String[] args) {
      FibonacciSeries fibonacciSeries = new FibonacciSeries();
      System.out.println(fibonacciSeries.fib(3));
   }
}
