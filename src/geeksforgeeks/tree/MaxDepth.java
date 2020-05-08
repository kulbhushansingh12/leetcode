package geeksforgeeks.tree;

import com.sun.source.tree.Tree;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaxDepth {
   // Bottom Up approach
   public int maxDepth1(TreeNode root) {
      if (root == null)
         return 0;

      int left = maxDepth1(root.left);
      int right = maxDepth1(root.right);
      return Math.max(left, right) + 1;
   }

   int answer = 0;
   public int maxDepth2(TreeNode root) {
      if (root == null)
         return answer;
      findMaxDepth(root, 1);
      return answer;
   }

   private void findMaxDepth(TreeNode root, int depth) {
      if (root == null) {
         return;
      }
      if (root.left == null && root.right == null) {
         answer = Math.max(answer, depth);
      }
      findMaxDepth(root.left, depth + 1);
      findMaxDepth(root.right, depth + 1);
   }


   public static void main(String[] args) {
      MaxDepth maxDepth = new MaxDepth();
      TreeNode root = new TreeNode(3);
      TreeNode n1 = new TreeNode(9);
      TreeNode n2 = new TreeNode(20);
      TreeNode n3 = new TreeNode(15);
      TreeNode n4 = new TreeNode(7);
      root.left = n1;
      root.right = n2;
      n2.left = n3;
      n2.right = n4;
      System.out.println(maxDepth.maxDepth2(root));
   }
}
