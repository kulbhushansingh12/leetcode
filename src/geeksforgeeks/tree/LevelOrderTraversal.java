package geeksforgeeks.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal/
public class LevelOrderTraversal {
   public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();

      Queue<TreeNode> queue = new LinkedList<>();
      // Add root
      queue.add(root);
      //Add level delimiter
      queue.add(null);
      List<Integer> levelList = new ArrayList<>();
      while (!queue.isEmpty()) {
         TreeNode element = queue.poll();

         if (element == null) {
            if (!queue.isEmpty()) {
               queue.add(null);
               result.add(levelList);
               levelList = new ArrayList<>();
               System.out.println();
            } else if(levelList.size()!= 0){
               result.add(levelList);
            }
         } else {
            if (element.left != null)
               queue.add(element.left);

            if (element.right != null)
               queue.add(element.right);

            levelList.add(element.val);
            System.out.print(element.val + " ");
         }
      }
      return result;
   }

   public static void main(String[] args) {
      test1();
   }

   private static void test1() {
      TreeNode root = new TreeNode(3);
      TreeNode n1 = new TreeNode(9);
      TreeNode n2 = new TreeNode(20);
      TreeNode n3 = new TreeNode(15);
      TreeNode n4 = new TreeNode(7);
      root.left = n1;
      root.right = n2;
      n2.left = n3;
      n2.right = n4;

      LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
      levelOrderTraversal.levelOrder(root);
   }
}
