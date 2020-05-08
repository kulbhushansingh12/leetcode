package geeksforgeeks.linkedlist;

//https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoList {
   public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null)
         return l2;
      if (l2 == null)
         return l1;
      ListNode head = null;
      ListNode prev = null;

      while (l1 != null && l2 != null) {
         if (l1.val < l2.val) {
            if (head == null) {
               head = l1;
               prev = head;
            } else {
               prev.next = l1;
               prev = prev.next;
            }
            l1 = l1.next;
         } else {
            if (head == null) {
               head = l2;
               prev = head;
            } else {
               prev.next = l2;
               prev = prev.next;
            }
            l2 = l2.next;
         }
      }
      if (l1 == null) {
         prev.next = l2;
      } else  {
         prev.next = l1;
      }
      ListNode.PrintLL(head);
      return head;
   }

   public static void main(String[] args) {
      // 1->2->4, 1->3->4
      ListNode list1 = new ListNode(1);
      ListNode n1 = new ListNode(2);
      ListNode n2 = new ListNode(4);
      list1.next = n1;
      n1.next = n2;

      ListNode list2 = new ListNode(1);
      ListNode ln1 = new ListNode(3);
      ListNode ln2 = new ListNode(4);
      list2.next = ln1;
      ln1.next = ln2;

      mergeTwoLists(list1, list2);

   }
}