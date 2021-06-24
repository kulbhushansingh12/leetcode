package geeksforgeeks.tree;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestor {
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      isLCA(root, p, q);
      return lcaNode;
   }
   TreeNode lcaNode = null;
   public boolean isLCA(TreeNode node, TreeNode p, TreeNode q) {
      if (node == null) {
         return false;
      }

      int left = isLCA(node.left, p, q) ? 1 : 0;

      int right = isLCA(node.right, p, q) ? 1 : 0;

      int mid = (node == p || node == q) ? 1 : 0;

      if (left + mid + right >= 2) {
         lcaNode = node;
      }
      return (mid + right + left) > 0;
   }

   public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null)
         return null;

      if (root == p || root == q) {
         return root;
      }

      TreeNode lLCA = lowestCommonAncestor1(root.left, p, q);

      TreeNode rLCA = lowestCommonAncestor1(root.right, p, q);

      if (lLCA!= null && rLCA != null) {
         return root;
      }

      if (lLCA != null)
         return lLCA;
      else
         return rLCA;
   }


}
