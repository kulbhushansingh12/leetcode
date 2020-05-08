package leetcode;

import com.sun.source.tree.Tree;

//https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBT {
   int max = 0;
   public int diameterOfBinaryTree(TreeNode root) {
      maxDepth(root);
      return max;
   }

   private int maxDepth(TreeNode root) {
      if (root == null) return 0;

      int left = maxDepth(root.left);
      int right = maxDepth(root.right);

      max = Math.max(max, left + right);

      return Math.max(left, right) + 1;
   }

   public static void main(String[] args) {
      test1();
   }

   private static void test1() {
      TreeNode root = new TreeNode(1);
      TreeNode n1 = new TreeNode(2);
      TreeNode n2 = new TreeNode(3);
      TreeNode n3 = new TreeNode(4);
      TreeNode n4 = new TreeNode(5);
      root.right = n2;
      root.left =    n1;
      n1.left = n3;
      n1.right = n4;

      DiameterOfBT diameterOfBT = new DiameterOfBT();

      System.out.println(diameterOfBT.diameterOfBinaryTree(root));
   }
}

