package geeksforgeeks.linkedlist.recursion;

import geeksforgeeks.linkedlist.ListNode;

// https://leetcode.com/problems/reverse-linked-list/
public class ReverseLL {
   public ListNode reverseList(ListNode head) {
      return reverseListHelper(head, null, null);
   }

   public ListNode reverseListHelper(ListNode current, ListNode prev, ListNode next) {
      if (current == null) {
         return prev;
      }
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
      return reverseListHelper(current, prev, next);
   }

   public ListNode reverseList1(ListNode head) {
      if (head == null || head.next == null)
         return head;

      ListNode current = reverseList1(head.next);
      head.next.next = head;
      head.next = null;
      return current;
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
      ReverseLL reverseLL = new ReverseLL();
      ListNode.PrintLL(reverseLL.reverseList1(head));

   }
}
