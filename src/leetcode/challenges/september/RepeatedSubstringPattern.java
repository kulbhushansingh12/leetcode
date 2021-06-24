package leetcode.challenges.september;

// https://leetcode.com/problems/repeated-substring-pattern/
public class RepeatedSubstringPattern {
   public boolean repeatedSubstringPattern(String s) {
      StringBuilder sb = new StringBuilder();

      for(int i=0;i<s.length()/2;i++){
         sb.append(s.charAt(i));
         //if the length of the substring is not a integer multiple of the original string length then it cannot be used for this iteration
         if(s.length() % (i+1) != 0) continue;
         int x = s.length()/(i+1);

         //create a repeated string to see if it matches the original
         String st = sb.toString().repeat(x);

         if(st.equals(s)){
            return true;
         }


      }
      return false;
   }

   public static void main(String[] args) {
      RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
      System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abcabcc"));
      System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("a"));
      System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abab"));
      System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("aba"));
      System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abac"));
      System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abcabcabc"));
   }
}
