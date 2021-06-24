package leetcode.challenges.september;

import java.util.Arrays;

// https://leetcode.com/problems/largest-time-for-given-digits/
public class LargestTime {
   public String largestTimeFromDigits(int[] A) {
      Arrays.sort(A);
      StringBuilder sb = new StringBuilder();
      int firstNum = -1;
      // First Number 0-2
      for (int i = 0; i < A.length; i++) {
         if (A[i] > 2)
            return "";
         if (i + 1 < A.length && A[i + 1] >= A[i] && A[i + 1] <= 2)
            continue;
         else {
            sb.append(A[i]);
            firstNum = A[i];
            A[i] = -1;
            break;
         }
      }

      // Second number 0-3
      int secondNum = -1;
      int secondIndex = -1;
      for (int i = 0; i < A.length; i++) {
         if (A[i] > 3 && secondNum == -1 && firstNum == 2)
            return "";
         if ((i + 1 < A.length && A[i + 1] >= A[i] && A[i + 1] <= 3) || (i + 1 < A.length && A[i + 1] == -1) || A[i] == -1) {
            if (A[i + 1] == -1) {
               secondNum = A[i];
               secondIndex = i;
               i = i + 1;
            }
            continue;
         } else {
            if ((A[i] > secondNum && A[i] <= 3) || (firstNum < 2 && A[i] > secondNum)) {
               if (i + 1 < A.length && firstNum < 2 && A[i+1] >= A[i])
                  continue;
               sb.append(A[i]);
               A[i] = -1;
            } else {
               sb.append(secondNum);
               A[secondIndex] = -1;
            }
            break;
         }
      }
      if ((sb.length() < 2 && secondNum > -1)) {
         sb.append(secondNum);
         A[secondIndex] = -1;
      }

      sb.append(":");

      // Third Number 0-5
      int thirdNum = -1;
      int thirdIndex = -1;
      for (int i = 0; i<A.length; i++) {
         if (A[i] > 5 && thirdNum == -1)
            return "";

         if ((i + 1 < A.length && A[i + 1] >= A[i] && A[i + 1] <= 5) || (i + 1 < A.length && A[i + 1] == -1) || (i + 1 < A.length && A[i] == -1)) {
            if ((A[i + 1] == -1 || (A[i+1] == A[i] && A[i+1] > -1)) && A[i+1] <= 5) {
               if (A[i] > 5)
                  break;
               thirdNum = A[i];
               thirdIndex = i;
               if (A[i+1] == -1)
                  i = i + 1;
            }
            continue;
         } else {
            if (A[i] > thirdNum && A[i] <= 5) {
               sb.append(A[i]);
               A[i] = -1;
            } else {
               sb.append(thirdNum);
               A[thirdIndex] = -1;
            }
            break;
         }
      }

      if (sb.length() < 4 && thirdNum > -1) {
         sb.append(thirdNum);
         A[thirdIndex] = -1;
      }

      // Last Number any non -1
      for (int i=0;i<A.length; i++) {
         if (A[i] != -1) {
            sb.append(A[i]);
            break;
         }

      }

      return sb.toString();
   }

   public static void main(String[] args) {
      LargestTime largestTime = new LargestTime();

      // First Number test cases
      System.out.println(largestTime.largestTimeFromDigits(new int[]{2, 0, 6, 6}));
      System.out.println(largestTime.largestTimeFromDigits(new int[]{0, 4, 4, 8}));
      System.out.println(largestTime.largestTimeFromDigits(new int[]{3, 2, 7, 0}));
      System.out.println(largestTime.largestTimeFromDigits(new int[]{1, 9, 6, 0}));
      System.out.println(largestTime.largestTimeFromDigits(new int[]{3, 3, 0, 4}));
      System.out.println(largestTime.largestTimeFromDigits(new int[]{0, 4, 0, 3}));
      System.out.println(largestTime.largestTimeFromDigits(new int[]{4, 1, 0, 0}));
      System.out.println(largestTime.largestTimeFromDigits(new int[]{1, 2, 3, 4}));
      System.out.println(largestTime.largestTimeFromDigits(new int[]{0, 4, 0, 0}));
      System.out.println(largestTime.largestTimeFromDigits(new int[]{2, 0, 0, 4}));
      System.out.println(largestTime.largestTimeFromDigits(new int[]{0, 0, 0, 2}));
      System.out.println(largestTime.largestTimeFromDigits(new int[]{5, 6, 7, 8}));

      //Second Number test cases
      System.out.println(largestTime.largestTimeFromDigits(new int[]{2, 6, 7, 8}));
      System.out.println(largestTime.largestTimeFromDigits(new int[]{2, 2, 1, 2}));
      System.out.println(largestTime.largestTimeFromDigits(new int[]{0, 0, 2, 2}));
      System.out.println(largestTime.largestTimeFromDigits(new int[]{1, 2, 2, 3}));

   }
}
