package leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/
public class LeftMostColumnWithOne {
   public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
      List<Integer> dimensions = binaryMatrix.dimensions();
      int minIndex = -1;
      int row = dimensions.get(0), column = dimensions.get(1);
      for (int i=0; i<row; i++) {
            int low = 0, high = column - 1;
            while (low <= high) {
               int mid = (low + high) / 2;
               if (binaryMatrix.get(i, mid) == 1) {
                  if (mid ==0 || binaryMatrix.get(i, mid - 1) == 0) {
                     minIndex = minIndex == -1 || minIndex > mid ? mid : minIndex;
                     break;
                  }
                  high = mid - 1;
               } else
                  low = mid + 1;
            }
      }
      return minIndex;
   }

   public static void main(String[] args) {
      LeftMostColumnWithOne columnWithOne = new LeftMostColumnWithOne();
   }
}

interface BinaryMatrix {
   int get(int x, int y);
   List<Integer> dimensions();
}