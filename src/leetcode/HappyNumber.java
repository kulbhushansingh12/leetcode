package leetcode;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/happy-number/
public class HappyNumber {

   public boolean isHappy(int n) {
      Set<Integer> repeatingNumber = new HashSet<>();
      if (n ==0)
         return false;
      while (repeatingNumber.add(n)) {
         int sum = sumOfDigit(n);
         if(sum == 1)
            return true;
         n = sum;
      }
      return false;
   }

   public int sumOfDigit(int num) {
      int sum = 0;
      while (num > 0) {
         int digit = num%10;
         sum += (digit * digit);
         num = num/10;
      }
      return sum;
   }

   public static void main(String[] args) {
      HappyNumber happyNumber = new HappyNumber();
      System.out.println(happyNumber.isHappy(19));
   }

}
