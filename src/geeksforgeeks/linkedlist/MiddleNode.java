package geeksforgeeks.linkedlist;

//https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleNode {
   public static ListNode middleNode(ListNode head) {
      if (head == null || head.next == null)
         return head;
      ListNode slow = head, fast = head;
      while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
      }
      return slow;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      ListNode l1 = new ListNode(2);
      ListNode l2 = new ListNode(3);
      ListNode l3 = new ListNode(4);
      ListNode l4 = new ListNode(5);
      ListNode l5 = new ListNode(6);
      ListNode l6 = new ListNode(7);
      head.next = l1;


      ListNode node = middleNode(head);
      ListNode.PrintLL(node);
   }
}
