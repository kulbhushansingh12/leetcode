package leetcode;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthBinaryTree {

   public int maxDepth(TreeNode root) {
      if (root == null)
         return 0;
      else {
         int ldepth = maxDepth(root.left);
         int rdepth = maxDepth(root.right);

         if (ldepth > rdepth)
            return ldepth + 1;
         else
            return rdepth + 1;
      }
   }

}
