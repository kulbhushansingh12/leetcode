package leetcode;

//https://leetcode.com/problems/remove-k-digits/
public class RemoveKDigit {
   public static String removeKdigits(String num, int k) {
      int count = 0;
      while (count < k) {
         if (num.length() == 1 || num.length() ==0 ) {
            return "0";
         }
         if (num.charAt(0) > num.charAt(1)) {
            num = num.substring(1);
         } else {
            num = num.charAt(0) + num.substring(2);
         }
         ++count;
      }

      return String.valueOf(Integer.valueOf(num));
   }

   public static void main(String[] args) {
      System.out.println(RemoveKDigit.removeKdigits("1432219", 3));
      System.out.println(RemoveKDigit.removeKdigits("10200", 1));
      System.out.println(RemoveKDigit.removeKdigits("10", 2));
      System.out.println(RemoveKDigit.removeKdigits("112", 1));
   }
}
