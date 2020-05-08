package leetcode;

//https://leetcode.com/problems/jewels-and-stones/
public class JewelsInStones {
   public int numJewelsInStones(String J, String S) {
      int count = 0;
      boolean[] arr = new boolean[255];
      for (Character ch : J.toCharArray())
         arr[ch] = true;

      for (Character ch : S.toCharArray()) {
         if (arr[ch])
            ++count;
      }

      return count;
   }

   public int numJewelsInStones2(String J, String S) {
      int jewelCount = 0;
      for (int i=0; i<S.length(); i++) {
         if (J.contains(String.valueOf(S.charAt(i)))) {
            ++jewelCount;
         }
      }
      return jewelCount;
   }
}
