package geeksforgeeks.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/binary-tree-postorder-traversal/
public class PostOrderTraversal {
   List<Integer> result = new ArrayList<>();
   public List<Integer> postorderTraversal(TreeNode root) {
      if (root == null)
         return Collections.EMPTY_LIST;
      helper(root);
      return result;
   }

   private void helper(TreeNode root) {
      if (root == null)
         return;
      helper(root.left);
      helper(root.right);
      result.add(root.val);
      System.out.println(root.val);
   }


   public List<Integer> postOrderTraversalIterative(TreeNode root) {
      if (root == null)
         return Collections.emptyList();

      Stack<TreeNode> stack = new Stack<>();
      List<Integer> result = new ArrayList<>();
      TreeNode current = root;
      while (current != null || !stack.isEmpty()) {
         if (current != null ) {
            stack.push(current);
            current = current.left;
         } else {
            // Check if current is leaf node.
            TreeNode topNode = stack.peek();
            if (topNode.right == null) {
               topNode = stack.pop();
               result.add(topNode.val);
               // We have visited left child, now pop all right children
               while (!stack.isEmpty() && topNode == stack.peek().right) {
                  topNode = stack.pop();
                  result.add(topNode.val);
               }
            } else {
               current = topNode.right;
            }
         }
      }

      return result;
   }


   public static void main(String[] args) {
      test1();
      test2();
      test3();
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
      PostOrderTraversal preOrderTraversal = new PostOrderTraversal();
      //preOrderTraversal.preorderTraversal(root);
      preOrderTraversal.postOrderTraversalIterative(root);
   }

   private static void test2() {
      System.out.println("==========Test2================");
      TreeNode root = new TreeNode(1);
      TreeNode n1 = new TreeNode(2);
      TreeNode n2 = new TreeNode(3);
      root.right = n1;
      n1.left = n2;
      PostOrderTraversal preOrderTraversal = new PostOrderTraversal();
      preOrderTraversal.postOrderTraversalIterative(root);
   }

   private static void test3(){
      System.out.println("=============Test3=========");
      TreeNode root = new TreeNode(10);
      TreeNode n1 = new TreeNode(-6);
      TreeNode n2 = new TreeNode(8);
      TreeNode n3 = new TreeNode(15);
      root.left = n1;
      root.right =n3;
      n1.right = n2;
      PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
      postOrderTraversal.postOrderTraversalIterative(root);
   }
}
