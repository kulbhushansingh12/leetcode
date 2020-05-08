package geeksforgeeks.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/binary-tree-inorder-traversal/
public class InorderTraversal {
   List<Integer> result = new ArrayList<>();
   public List<Integer> inorderTraversal(TreeNode root) {
      if (root == null)
         return Collections.EMPTY_LIST;

      helper(root);
      return result;
   }

   private void helper(TreeNode root) {
      if (root == null)
         return;

      helper(root.left);
      System.out.println(root.val);
      result.add(root.val);
      helper(root.right);
   }

   public List<Integer> inorderTraversalIterative(TreeNode root) {
      if (root == null)
         return Collections.EMPTY_LIST;
      Stack<TreeNode> stack = new Stack<>();
      List<Integer> result = new ArrayList<>();
      while (true) {
         if (root != null) {
            stack.push(root);
            root = root.left;
         } else {
            if (stack.isEmpty())
               break;
            TreeNode node = stack.pop();
            result.add(node.val);
            System.out.println(node.val);
            root = node.right;
         }
      }
      return result;
   }

   public static void main(String[] args) {
      test1();
      test2();
   }

   private static void test1() {
      System.out.println("==========Test1================");
      TreeNode root = new TreeNode(1);
      TreeNode n1 = new TreeNode(2);
      TreeNode n2 = new TreeNode(3);
      TreeNode n3 = new TreeNode(4);
      TreeNode n4 = new TreeNode(5);
      root.left = n1;
      root.right = n2;
      n1.left = n3;
      n1.right = n4;
      InorderTraversal preOrderTraversal = new InorderTraversal();
      //preOrderTraversal.preorderTraversal(root);
      preOrderTraversal.inorderTraversal(root);
   }

   private static void test2() {
      System.out.println("==========Test2================");
      TreeNode root = new TreeNode(1);
      TreeNode n1 = new TreeNode(2);
      TreeNode n2 = new TreeNode(3);
      root.right = n1;
      n1.left = n2;
      InorderTraversal preOrderTraversal = new InorderTraversal();
      preOrderTraversal.inorderTraversal(root);
   }
}
