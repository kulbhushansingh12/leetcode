package leetcode;

//https://leetcode.com/problems/first-bad-version/
public class FirstBadVersion extends VersionControl {
   public int firstBadVersion(int n) {
      int low=0, high = n;
      int mid = 0;
      while (low<high) {
         mid = (low + high)/2;
         if (isBadVersion(mid)) {
            if (!isBadVersion(mid - 1))
               return mid;
            high = mid - 1;
         } else {
            if (isBadVersion(mid + 1))
               return mid + 1;
            low = mid + 1;
         }
      }

      return low;
   }

   public static void main(String[] args) {
      FirstBadVersion badVersion = new FirstBadVersion();
      System.out.println(badVersion.firstBadVersion(5));
   }
}

class VersionControl {
   public boolean isBadVersion(int version) {
      if (version >= 2)
         return true;
      return false;
   }
}
