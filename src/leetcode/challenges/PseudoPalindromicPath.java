package leetcode.challenges;

import geeksforgeeks.tree.TreeNode;

public class PseudoPalindromicPath {
   int count= 0;
   public int pseudoPalindromicPaths (TreeNode root) {
      countPath(root, new int[9]);
      return count;
   }

   public void countPath(TreeNode root, int[] arr) {
      if (root == null)
         return ;
      ++arr[root.val];
      if (root.left == null && root.right == null) {
         int oddCount = 0;
         for (int num: arr) {
            if (num%2 !=0 || num==1) ++oddCount;
            if (oddCount>1) {
               --count;
               break;
            }
         }
         ++count;
      }
      countPath(root.left, arr);
      countPath(root.right, arr);
      arr[root.val]--;
   }

   public static void main(String[] args) {
      TreeNode n1 = new TreeNode(3);
      TreeNode n2 = new TreeNode(1);
      TreeNode l1 = new TreeNode(3, n1, n2);

      TreeNode n3 = new TreeNode(1);
      TreeNode r1 = new TreeNode(1, null, n3);
      TreeNode root = new TreeNode(2, l1, r1);

      PseudoPalindromicPath path = new PseudoPalindromicPath();
      System.out.println(path.pseudoPalindromicPaths(root));
   }

}
