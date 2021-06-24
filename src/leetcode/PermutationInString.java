package leetcode;

//https://leetcode.com/problems/permutation-in-string/
public class PermutationInString {

   public boolean checkInclusion(String s1, String s2) {
      if (s1.length() > s2.length())
         return false;
      int[] s1CharCount = new int[26];
      for (char ch : s1.toCharArray()) {
         ++s1CharCount[ch - 'a'];
      }

      for (int i=0; i<=s2.length() - s1.length(); i++) {
         if (isPermutationPresent(s1CharCount, s2.substring(i, i + s1.length()))) {
            return true;
         }
      }

      return false;
   }

   private boolean isPermutationPresent(int[] s1CharCount, String s2) {
      int[] s2CharCount = new int[26];
      for(char ch : s2.toCharArray()) {
         ++s2CharCount[ch - 'a'];
      }

      for (int i=0; i<26; i++) {
         if (s1CharCount[i] != s2CharCount[i])
            return false;
      }
      return true;
   }

   public static void main(String[] args) {
      PermutationInString permutation = new PermutationInString();
      System.out.println(permutation.checkInclusion("ab", "eidbaooo"));
      System.out.println(permutation.checkInclusion("ab", "eidboaoo"));
      System.out.println(permutation.checkInclusion("adc", "dcda"));
   }
}
