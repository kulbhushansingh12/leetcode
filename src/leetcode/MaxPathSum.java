package leetcode;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class MaxPathSum {
   int max = Integer.MIN_VALUE;
   public int maxPathSum(TreeNode root) {
      helper(root);
      return max;
   }

   private int helper(TreeNode root) {
      if(root == null) return 0;
      int left = helper(root.left);
      int right = helper(root.right);
      // upadate max, if (root.val), (root.val + right), (root.val + left) or
      // (root.val + right + left) is greater than max.
      max = Math.max(max, Math.max(root.val, Math.max(root.val + right,
              Math.max(root.val + left,root.val + left + right ))));
      // return the greatest value in (root.val), (root.val + right) or (root.val + left)
      return Math.max(root.val, Math.max(root.val + right, root.val + left));
   }
}
