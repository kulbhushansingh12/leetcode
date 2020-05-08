package geeksforgeeks.linkedlist;

//https://leetcode.com/problems/remove-linked-list-elements/
//https://www.geeksforgeeks.org/delete-a-linked-list-node-at-a-given-position/
public class RemoveNode {

   public static ListNode removeElements(ListNode head, int val) {
      ListNode current = head;
      ListNode prev = null;

      while (current != null) {
         if (current.val == val) {
            if (prev == null) {
               head = head.next;
               current = current.next;
               continue;
            }
            prev.next = current.next;
         } else {
            prev = current;
         }
         current = current.next;
      }

      return head;
   }

   public static void main(String[] args) {
      //[1,2,6,3,4,5,6]
      ListNode head = new ListNode(1);
      ListNode n1 = new ListNode(2);
      ListNode n2 = new ListNode(6);
      ListNode n3 = new ListNode(6);
      ListNode n4 = new ListNode(4);
      ListNode n5 = new ListNode(5);
      ListNode n6 = new ListNode(6);
      head.next = n1;
      n1.next = n2;
      n2.next = n3;
      n3.next = n4;
      n4.next = n5;
      n5.next = n6;
      ListNode.PrintLL(removeElements(head, 6));
   }

}
