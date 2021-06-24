package leetcode;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {
   public int search(int[] nums, int target) {
      if (nums == null || nums.length == 0)
         return -1;
      int low = 0, high = nums.length - 1;
      while (low <= high) {
         int mid = ((low + high) / 2);
         if (nums[mid] == target)
            return mid;
         else if (target >= nums[low]) {
            if (target < nums[mid])
               high = mid - 1;
            else if (target > nums[high])
               high = mid - 1;
         } else
            low = mid + 1;
      }

      return -1;
   }

   public static void main(String[] args) {
      SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
      System.out.println(search.search(new int[] {4,5,6,7,8, 9,0,1,2,3}, 9));
      System.out.println(search.search(new int[] {4,5,6,7,0,1,2}, 3));
      System.out.println(search.search(new int[]{5,1,3}, 5));
      System.out.println(search.search(new int[] {9,0,1,2,3}, 9));
   }
}
