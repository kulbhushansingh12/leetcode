package geeksforgeeks.linkedlist.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle-ii/
public class PascalTriangle {
   public List<Integer> getRow(int rowIndex) {
      if (rowIndex == 0)
         return Collections.singletonList(1);

      List<Integer> prevRow = getRow(rowIndex-1);

      List<Integer> currRow = new ArrayList<>();
      currRow.add(1);
      for (int i=1; i<rowIndex; i++) {
         currRow.add(i, prevRow.get(i) + prevRow.get(i-1));
      }
      currRow.add(1);
      return currRow;
   }

   public static void main(String[] args) {
      PascalTriangle pascalTriangle = new PascalTriangle();
      List<Integer> row = pascalTriangle.getRow(4);
      for (int num : row) {
         System.out.print(num + " ");
      }

   }
}
