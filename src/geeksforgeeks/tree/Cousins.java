package geeksforgeeks.tree;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/cousins-in-binary-tree/
public class Cousins {
   public boolean isCousins(TreeNode root, int x, int y) {
      Queue<TreeNode> treeNodes = new LinkedList<>();
      treeNodes.add(root);
      TreeNode xParent = null, yParent = null;
      while (!treeNodes.isEmpty()) {
         int size = treeNodes.size();
         for (int i=0; i<size; i++) {
            TreeNode node = treeNodes.remove();
            if (node.left != null) {
               treeNodes.add(node.left);
               if (node.left.val == x)
                  xParent = node;
               if (node.left.val == y)
                  yParent = node;
            }

            if (node.right != null) {
               treeNodes.add(node.right);
               if (node.right.val == x)
                  xParent = node;
               if (node.right.val == y)
                  yParent = node;
            }
         }

         if (xParent != null || yParent != null)
            break;
      }
      return xParent != null && yParent != null && xParent != yParent;
   }
}
