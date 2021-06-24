package geeksforgeeks.recurssion;

//https://leetcode.com/problems/reverse-string/
public class ReverseString {
   public static void reverseString(char[] s) {
      reverseStringHelper(s, 0, s.length-1);
   }

   public static void reverseStringHelper(char[] s, int leftIndex, int rightIndex) {
      if (s == null || s.length < 2 || leftIndex > rightIndex) {
         return;
      }

      char temp = s[leftIndex];
      s[leftIndex] = s[rightIndex];
      s[rightIndex] = temp;
      reverseStringHelper(s, ++leftIndex, --rightIndex);
   }

   public static String reverseString1(String s) {
      if (s == null || s.length() < 2)
         return s;

      return reverseString1(s.substring(1)) + s.charAt(0);
   }

      public static void main(String[] args) {
      /*char[] ch = "abcer".toCharArray();
      reverseString(ch);
      System.out.println(new String(ch));*/
         System.out.println(reverseString1("abcef"));
   }
}
