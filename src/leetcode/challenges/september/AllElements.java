package leetcode.challenges.september;

import geeksforgeeks.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
public class AllElements {
   public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
      List<Integer> allElements = getAllElementsUtil(root1, root2, new ArrayList<>());
      Collections.sort(allElements);
      return allElements;
   }

   public List<Integer> getAllElementsUtil(TreeNode node1, TreeNode node2, List<Integer> elements) {
      if (node1 == null && node2 == null)
         return elements;

      if (node1 != null) {
         elements.add(node1.val);
      }
      if (node2 != null) {
         elements.add(node2.val);
      }

      TreeNode node1Left = node1 != null && node1.left != null ? node1.left : null;
      TreeNode node2Left = node2 != null && node2.left != null ? node2.left : null;
      getAllElementsUtil(node1Left, node2Left, elements);
      TreeNode node1Right = node1 != null && node1.right != null ? node1.right : null;
      TreeNode node2Right = node2 != null && node2.right != null ? node2.right : null;
      getAllElementsUtil(node1Right, node2Right, elements);
      return elements;
   }

   public static void main(String[] args) {
      AllElements allElements = new AllElements();
      TreeNode ll1 = new TreeNode(1);
      TreeNode lr1 = new TreeNode(4);

      TreeNode root = new TreeNode(2, ll1, lr1);

      TreeNode l1 = new TreeNode(0);
      TreeNode l2 = new TreeNode(3);
      TreeNode root2 = new TreeNode(1, l1, l2);

      List<Integer> op = allElements.getAllElements(root, root2);

      for (int num : op) {
         System.out.print(num + " ");
      }
   }
}
