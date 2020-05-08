package geeksforgeeks.linkedlist;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicatesSl {

   public ListNode deleteDuplicates(ListNode head) {
      if (head ==null || head.next == null) {
         return head;
      }
      ListNode current = head;
      ListNode prev = null;

      while (current != null) {
         if (prev != null && current.val == prev.val) {
            prev.next = current.next;
            current = current.next;
            continue;
         }
         prev = current;
         current = current.next;
      }
      return head;
   }

   public static void main(String[] args) {
      test1();
      test2();
   }

   private static void test1() {
      ListNode head = new ListNode(1);
      ListNode n1 = new ListNode(1);
      ListNode n2 = new ListNode(2);
      head.next = n1;
      n1.next = n2;

      RemoveDuplicatesSl rd = new RemoveDuplicatesSl();
      ListNode.PrintLL(rd.deleteDuplicates(head));
   }

   private static void test2() {
      ListNode head = new ListNode(1);
      ListNode n1 = new ListNode(1);
      ListNode n2 = new ListNode(1);
      ListNode n3 = new ListNode(3);
      ListNode n4 = new ListNode(3);
      head.next = n1;
      n1.next = n2;
      n2.next = n3;
      n3.next = n4;

      RemoveDuplicatesSl rd = new RemoveDuplicatesSl();
      ListNode.PrintLL(rd.deleteDuplicates(head));
   }
}
