package geeksforgeeks.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
   List<Integer> result = new ArrayList<>();
   public List<Integer> preorderTraversal(TreeNode root) {
      helper(root);
      return result;
   }

   private void helper(TreeNode root) {
      if (root == null)
         return ;
      result.add(root.val);
      System.out.println(root.val);
      preorderTraversal(root.left);
      preorderTraversal(root.right);
   }


   public List<Integer> preorderTraversalIterative(TreeNode root) {
      if (root == null)
         return Collections.EMPTY_LIST;
      List<Integer> result = new ArrayList<>();
      Stack<TreeNode> stack = new Stack<>();
      stack.push(root);
      while (!stack.isEmpty()) {
         TreeNode node = stack.pop();
         System.out.println(node.val);
         result.add(node.val);
         if (node.right != null)
            stack.push(node.right);
         if (node.left != null)
            stack.push(node.left);
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
      PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
      //preOrderTraversal.preorderTraversal(root);
      preOrderTraversal.preorderTraversalIterative(root);
   }

   private static void test2() {
      System.out.println("==========Test2================");
      TreeNode root = new TreeNode(1);
      TreeNode n1 = new TreeNode(2);
      TreeNode n2 = new TreeNode(3);
      root.right = n1;
      n1.left = n2;
      PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
      preOrderTraversal.preorderTraversal(root);
   }

}
