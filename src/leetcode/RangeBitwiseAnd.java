package leetcode;

//https://leetcode.com/problems/bitwise-and-of-numbers-range/
public class RangeBitwiseAnd {
   public int rangeBitwiseAnd(int m, int n) {
      int result = m;
      for (int i = m + 1; i<= n; i++){
         result &= i;
      }
      return result;
   }

   public static void main(String[] args) {
      RangeBitwiseAnd bitwiseAnd = new RangeBitwiseAnd();
      System.out.println(bitwiseAnd.rangeBitwiseAnd(5,7));
   }
}
