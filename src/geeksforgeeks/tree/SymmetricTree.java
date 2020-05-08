package geeksforgeeks.tree;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {
   public boolean isSymmetric(TreeNode root) {
      return isSymmetricTree(root, root);
   }

   public boolean isSymmetricTree(TreeNode left, TreeNode right) {
      if (left == null || right == null )
         return left == null && right == null;
      if (left.val != right.val)
         return false;

      return isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right, right.left);
   }

   public boolean isSymmetricIterative(TreeNode root) {
      if (root == null)
         return true;
      Queue<TreeNode> nodes = new LinkedList<>();
      nodes.add(root.left);
      nodes.add(root.right);

      while (!nodes.isEmpty()) {
         TreeNode n1 = nodes.remove();
         TreeNode n2 = nodes.remove();
         if (n1 == null && n2 == null)
            continue;
         if (n1==null || n2 == null)
            return false;
         if (n1.val != n2.val)
            return false;

         nodes.add(n1.left);
         nodes.add(n2.right);
         nodes.add(n1.right);
         nodes.add(n2.left);
      }
      return true;
   }

   public static void main(String[] args) {
      test1();
      test2();
   }

   private static void test1() {
      SymmetricTree symmetricTree = new SymmetricTree();
      TreeNode root = new TreeNode(1);
      TreeNode n1 = new TreeNode(2);
      TreeNode n2 = new TreeNode(2);
      root.left = n1;
      root.right = n2;
      TreeNode n3 =new TreeNode(3);
      TreeNode n4 =new TreeNode(3);
      n1.left = n3;
      n2.right = n4;

      TreeNode n5 = new TreeNode(4);
      TreeNode n6 = new TreeNode(4);
      n1.right = n5;
      n2.left = n6;
      System.out.println(symmetricTree.isSymmetricIterative(root));
   }

   private static void test2() {
      SymmetricTree symmetricTree = new SymmetricTree();
      TreeNode root = new TreeNode(1);
      TreeNode n1 = new TreeNode(2);
      TreeNode n2 = new TreeNode(2);
      root.left = n1;
      root.right = n2;
      TreeNode n3 =new TreeNode(3);
      TreeNode n4 =new TreeNode(3);
      n1.right = n3;
      n2.right = n4;
      System.out.println(symmetricTree.isSymmetricIterative(root));
   }
}
