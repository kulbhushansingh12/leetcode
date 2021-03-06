package leetcode;

//https://leetcode.com/problems/merge-two-binary-trees/
public class MergeBinaryTree {
   public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
      if (t1 == null)
         return t2;
      if (t2 == null)
         return t1;

      TreeNode node = new TreeNode(t1.val + t2.val);
      node.left = mergeTrees(t1.left, t2.left);
      node.right = mergeTrees(t1.right, t2.right);

      return node;
   }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
      TreeNode(int x, TreeNode left, TreeNode right) {
          this.val  = x;
          this.left = left;
          this.right = right;
      }
  }
