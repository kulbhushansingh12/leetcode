package geeksforgeeks.tree;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class RightPointers {
   public Node connect(Node root) {
      // Level Order Traversal
      Queue<Node> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
         int size = queue.size();
         Node prevNode = null;
         while (size > 0) {
            Node node = queue.remove();
            if (prevNode != null) {
               prevNode.next = node;
            }
            prevNode = node;
            if (node.left != null)
               queue.add(node.left);
            if (node.right != null)
               queue.add(node.right);

            --size;
         }
         prevNode.next = null;
      }

      return root;
   }

   public static void main(String[] args) {
      RightPointers rightPointers = new RightPointers();
      Node n1 = new Node(4);
      Node n2 = new Node(5);
      Node n3 = new Node(2, n1, n2, null);

      Node n4 = new Node(6);
      Node n5 = new Node(7);
      Node n6 = new Node(3, n4, n5, null);

      Node root = new Node(1, n3, n6, null);
      Node node = rightPointers.connect(root);
      System.out.println();
   }


   static class Node {
      public int val;
      public Node left;
      public Node right;
      public Node next;

      public Node() {}

      public Node(int _val) {
         val = _val;
      }

      public Node(int _val, Node _left, Node _right, Node _next) {
         val = _val;
         left = _left;
         right = _right;
         next = _next;
      }
   };
}
