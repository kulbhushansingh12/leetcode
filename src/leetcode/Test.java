package leetcode;

import java.util.ArrayList;

public class Test {

   public static String[] solution(int N, int K) {
      if (N == 0) {
         return new String[] {""};
      }
      ArrayList<String> result = new ArrayList<String>();
      for (String p : solution(N - 1, K - 1)) {
         for (char l : new char[] {'a', 'b', 'c'}) {
            int pLen = p.length();
            if (pLen == 0 || p.charAt(pLen - 1) != l) {
               result.add(p + l);
            }
         }
      }
      int prefSize = Math.min(result.size(), K);
      return result.subList(0, prefSize).toArray(new String[prefSize]);
   }

   public static void main(String[] args) {
      String[] strArr  = solution(2, 4);
      System.out.println(strArr);
   }
}
