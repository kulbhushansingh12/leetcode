package leetcode;

//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3315/
public class IsValidSequenceBT {
   public boolean isValidSequence(TreeNode root, int[] arr) {
      return helper(root, arr, 0);
   }

   public boolean helper(TreeNode root, int[] arr, int index) {
      if (root.val != arr[index])
         return false;
      if (index == arr.length - 1)
         return root.right == null && root.left == null;

      if (root.left != null && helper(root.left, arr, index+1)){
         return true;
      }
      if (root.right != null && helper(root.right, arr, index+1)){
         return true;
      }
      return false;
   }
}
