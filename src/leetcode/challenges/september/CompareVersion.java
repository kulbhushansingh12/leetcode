package leetcode.challenges.september;

// https://leetcode.com/problems/compare-version-numbers/
public class CompareVersion {
   public int compareVersion(String version1, String version2) {

      String arrVer1[]=version1.split("\\.");
      String arrVer2[]=version2.split("\\.");

      int maxLength = Math.max(arrVer1.length, arrVer2.length);

      for(int i=0;i<maxLength;i++)
      {
         int v1Num= i < arrVer1.length ? Integer.parseInt(arrVer1[i]) : 0;
         int v2Num= i < arrVer2.length ? Integer.parseInt(arrVer2[i]) : 0;

         if (v1Num == v2Num)
            continue;

         return v1Num - v2Num > 0 ? 1 : -1;
      }

      return 0;
   }
}
