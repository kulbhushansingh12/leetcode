package leetcode;

//https://leetcode.com/problems/longest-common-subsequence/
public class LongestCommonSubsequence {

   public int longestCommonSubsequence(String text1, String text2) {
      int[][] aux = new int[text1.length() + 1][text2.length() + 1];
      for (int i=1; i<=text1.length(); i++) {
         for (int j=1; j<=text2.length(); j++) {
            if (text1.charAt(i-1) == text2.charAt(j-1)) {
               aux[i][j] = aux[i-1][j-1] + 1;
            } else {
               aux[i][j] = Math.max(aux[i-1][j], aux[i][j-1]);
            }
         }
      }
      return aux[text1.length()][text2.length()];
   }

   public static void main(String[] args) {
      LongestCommonSubsequence lcs = new LongestCommonSubsequence();
      /*System.out.println(lcs.longestCommonSubsequence("abcde", "ace"));
      System.out.println(lcs.longestCommonSubsequence("abc", "abc"));
      System.out.println(lcs.longestCommonSubsequence("abc", "def"));*/
      System.out.println(lcs.longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
   }

}
