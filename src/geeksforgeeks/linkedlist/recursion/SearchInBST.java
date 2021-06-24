package geeksforgeeks.linkedlist.recursion;

import org.w3c.dom.Node;

import geeksforgeeks.tree.TreeNode;

// https://leetcode.com/problems/search-in-a-binary-search-tree/
public class SearchInBST {
   public TreeNode searchBST(TreeNode root, int val) {
      if (root == null || root.val == val)
         return root;

      TreeNode leftNode = searchBST(root.left, val);
      TreeNode rightNode = searchBST(root.right, val);

      return leftNode != null ? leftNode : rightNode;
   }

   public static void main(String[] args) {
      TreeNode left = new TreeNode(1);
      TreeNode right = new TreeNode(3);
      TreeNode rootLeft1 = new TreeNode(2, left, right);

      TreeNode rootRight1 = new TreeNode(7);

      TreeNode root = new TreeNode(4, rootLeft1, rootRight1);

      SearchInBST searchInBST = new SearchInBST();
      TreeNode node = searchInBST.searchBST(root, 4);
      System.out.println(node.val);
   }


   private static int isPresent(Node root, int val) {
      if (root == null) {
         return 0;
      }
      if (root.val == val) {
         return 1;
      }

      return root.val < val ? isPresent(root.right, val) : isPresent(root.left, val);
   }

   class Node {
      int val;
      Node left, right;
      Node(int data) {
         this.val = data;
      }
   }
}
