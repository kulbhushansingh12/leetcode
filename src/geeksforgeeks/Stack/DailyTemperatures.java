package geeksforgeeks.Stack;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures/
public class DailyTemperatures {
   public int[] dailyTemperatures(int[] T) {
      if (T == null || T.length == 0)
         return T;
      Stack<Element> stack = new Stack<>();

      for (int i=0; i<T.length; i++) {
         if (stack.isEmpty() || stack.peek().value > T[i]) {
            stack.push(new Element(T[i], i));
         } else {
            while (!stack.isEmpty() && stack.peek().value < T[i]) {
               Element el = stack.pop();
               T[el.index] = i - el.index;
            }
            stack.push(new Element(T[i], i));
         }
      }

      while (!stack.isEmpty()) {
         T[stack.pop().index] = 0;
      }
      return T;

   }

   class Element {
      int value;
      int index;
      public Element(int value, int index) {
         this.value = value;
         this.index = index;
      }
   }


   public static void main(String[] args) {
      DailyTemperatures temperatures = new DailyTemperatures();
      System.out.println(Arrays.toString(temperatures.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));

      System.out.println(Arrays.toString(temperatures.dailyTemperatures(new int[]{80, 2,3})));
   }
}
