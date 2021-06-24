package leetcode.challenges.september;

import geeksforgeeks.tree.TreeNode;

// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
public class SumRootToLeaf {
   public int sumRootToLeaf(TreeNode root) {
      sumRootToLeadHelper(root, "");
      return res;
   }

   int res = 0;

   public void sumRootToLeadHelper(TreeNode node, String num) {
      if (node == null) {
        return;
      }

      // If Leaf node
      if (node.right == null && node.left == null) {
         res += Integer.parseInt(num + node.val, 2);
      }
      sumRootToLeadHelper(node.left, num + node.val);
      sumRootToLeadHelper(node.right, num+node.val);
   }

   public static void main(String[] args) {
      SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();
      TreeNode ll1 = new TreeNode(0);
      TreeNode lr1 = new TreeNode(1);
      TreeNode lef1 = new TreeNode(0, ll1, lr1);

      TreeNode rl1 = new TreeNode(0);
      TreeNode rr1 = new TreeNode(1);
      TreeNode rig1 = new TreeNode(1, rl1, rr1);

      TreeNode root = new TreeNode(1, lef1, rig1);

      System.out.println(sumRootToLeaf.sumRootToLeaf(root));
   }
}
