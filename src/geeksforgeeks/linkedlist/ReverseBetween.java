package geeksforgeeks.linkedlist;

import java.util.List;

//https://leetcode.com/problems/reverse-linked-list-ii/
public class ReverseBetween {

   public static ListNode reverseBetween(ListNode head, int m, int n) {
      ListNode curr = head, prev = null;
      int i = 0;
      while (i < (m-1)) {
         prev = curr;
         curr = curr.next;
         ++i;
      }

      ListNode next = null, fLLTail = prev, rLLTail = curr;

      while (m <= n) {
         next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
         ++m;
      }

      if (fLLTail != null) {
         fLLTail.next = prev;
      } else {
         head = prev;
      }

      rLLTail.next = curr;
      return head;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      ListNode n1 = new ListNode(2);
      ListNode n2 = new ListNode(3);
      ListNode n3 = new ListNode(4);
      ListNode n4 = new ListNode(5);
      head.next = n1;
      n1.next = n2;
      n2.next = n3;
      n3.next = n4;
       printLL(head);
       //printLL(reverseBetween(head, 2, 4));
       //printLL(reverseBetween(head, 1, 2));
      //printLL(reverseBetween(head, 1, 5));
      //printLL(reverseBetween(head, 4, 5));
      printLL(reverseBetween(head, 2, 2));
   }

   public static void printLL(ListNode node) {
      while (node != null) {
         System.out.print(node.val + " ");
         node = node.next;
      }
      System.out.println();
   }
}
