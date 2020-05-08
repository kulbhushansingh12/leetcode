package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

   public static List<List<Integer>> solution1(int numRows) {
      List<List<Integer>> result = new ArrayList<>();
      if (numRows == 0) {
         return result;
      }
      List<Integer> current = new ArrayList<>();
      current.add(1);
      result.add(current);
      if (numRows == 1) {
         return result;
      }

      for(int i = 1; i < numRows; i++) {
         List previous = result.get(i-1);
         current = new ArrayList<>();
         current.add(1);
         for (int j = 1; j < i; j++) {
            current.add(((Integer)previous.get(j-1)+ (Integer) previous.get(j)));
         }
         current.add(1);
         result.add(current);
      }

      return result;
   }

   public static void main(String[] args) {
      printPT(solution1(2));
      printPT(solution1(5));
   }

   public static void printPT(List<List<Integer>> pt) {
      for (int i = 0; i < pt.size(); i ++) {
         for (Integer num : pt.get(i)) {
            System.out.print(num + " ");
         }
         System.out.println();
      }
   }
}
