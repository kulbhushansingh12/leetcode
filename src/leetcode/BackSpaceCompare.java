package leetcode;

//https://leetcode.com/problems/backspace-string-compare/
public class BackSpaceCompare {
   public boolean backspaceCompare(String S, String T) {

      int sIndex = S.length() - 1;
      int skipCountS = 0;
      int tIndex = T.length() - 1;
      int skipCountT = 0;

      while (sIndex >= 0 || tIndex >= 0) {
         while (sIndex >= 0) {
            if (S.charAt(sIndex) == '#') {
               ++skipCountS; --sIndex;
            } else if (skipCountS > 0) {
               --skipCountS; --sIndex;
            } else {
               break;
            }
         }

         while (tIndex >= 0) {
            if(T.charAt(tIndex) == '#') {
               ++skipCountT; --tIndex;
            } else if (skipCountT > 0) {
               --skipCountT; --tIndex;
            } else {
               break;
            }
         }

         if (tIndex >= 0 && sIndex >0 && (S.charAt(sIndex) != T.charAt(tIndex))) {
            return false;
         }

         if ((sIndex >= 0) != (tIndex >= 0))
            return false;

         --tIndex; --sIndex;
      }

      return true;
   }

   public static void main(String[] args) {
      BackSpaceCompare bsc = new BackSpaceCompare();
      System.out.println(bsc.backspaceCompare("", ""));
      System.out.println(bsc.backspaceCompare("ab#c", "ad#c"));
      System.out.println(bsc.backspaceCompare("ab##", "c#d#"));
      System.out.println(bsc.backspaceCompare("a##c", "#a#c"));
      System.out.println(bsc.backspaceCompare("a#c", "b"));
      System.out.println(bsc.backspaceCompare("bbbextm", "bbb#extm"));
   }
}
