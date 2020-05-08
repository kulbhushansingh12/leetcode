package geeksforgeeks.linkedlist;

import java.util.Stack;

//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
public class FlattenDoublyLinkedList {

   public Node flatten(Node head) {
     Stack<Node> stack  = new Stack<>();
     Node prev = null;
     Node newHead = null;
     stack.push(head);
     while(!stack.empty()) {
        Node curr = stack.pop();
        if (newHead == null) {
           newHead = curr;
        } else {
           prev.next = curr;
           curr.prev = prev;
        }

        if (curr.next != null)
           stack.push(curr.next);

        if (curr.child != null){
           stack.push(curr.child);
           curr.child = null;
        }

        prev = curr;
     }
      return newHead;
   }

   public static void main(String[] args) {
      Node head = new Node(1);
      Node n1 = new Node(2);
      Node n2 = new Node(3);
      Node n3 = new Node(7);
      Node n4 = new Node(4);

      head.child = n1;
      n1.child = n2;
      n2.child = n3;
      n3.child = n4;

      FlattenDoublyLinkedList flattenDoublyLinkedList = new FlattenDoublyLinkedList();
      print(flattenDoublyLinkedList.flatten(head));
   }

   public static  void print(Node n) {
      while(n != null) {
         System.out.print(n.val +" ");
         if (n.child != null)
            System.out.println("Child  didn't removed");
         n = n.next;
      }
      System.out.println();
   }

   static class Node {
      public int val;
      public Node prev;
      public Node next;
      public Node child;
      public Node(int x) {
         val = x;
      }
   }
}
