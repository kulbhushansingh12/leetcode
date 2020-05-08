package leetcode;

//https://leetcode.com/problems/complement-of-base-10-integer/
public class NumberComplement {
   public int findComplement(int num) {
      String binaryStr = Integer.toBinaryString(num);
      String str = "";
      for (Character ch : binaryStr.toCharArray()) {
         str += (Integer.valueOf(ch) - 48) ^ 1;
      }
      return Integer.valueOf(str, 2);
   }

   public static void main(String[] args) {
      NumberComplement numberComplement = new NumberComplement();
      System.out.println(numberComplement.findComplement(2));
      System.out.println(numberComplement.findComplement(5));
      System.out.println(numberComplement.findComplement(7));
      System.out.println(numberComplement.findComplement(10));
   }
}
