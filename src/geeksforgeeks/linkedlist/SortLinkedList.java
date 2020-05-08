package geeksforgeeks.linkedlist;

//https://leetcode.com/problems/sort-list/
public class SortLinkedList {
   public ListNode sortList(ListNode head) {
      if (head == null || head.next == null)
         return head;

      //Find Middle Node
      ListNode slowP = head;
      ListNode fastP = head;
      ListNode mid = head;
      while (fastP != null && fastP.next != null) {
         mid = slowP;
         slowP = slowP.next;
         fastP = fastP.next.next;
      }

      // Create Two List
      ListNode rightHead = mid.next;
      mid.next = null;

      //recursively call till we get the sorted LL
      ListNode left = sortList(head);
      ListNode right = sortList(rightHead);

      return merge(left, right);
   }

   public ListNode merge(ListNode list1, ListNode list2) {
      ListNode fakeHead = null;
      ListNode current = fakeHead;

      while (list1 != null && list2 != null) {
         if (list1.val < list2.val) {
            if (fakeHead == null) {
               fakeHead = list1;
               current = fakeHead;
            } else {
               current.next = list1;
               current = current.next;
            }
            list1 = list1.next;
         } else {
            if (fakeHead == null) {
               fakeHead = list2;
               current = fakeHead;
            } else {
               current.next = list2;
               current =current.next;
            }
            list2 = list2.next;
         }
      }

      if (list1 != null) {
         current.next = list1;
      } else if (list2 != null) {
         current.next = list2;
      }

      return fakeHead;
   }


   public static void main(String[] args) {
      ListNode head = new ListNode(-1);
      ListNode n1 = new ListNode(5);
      ListNode n2 = new ListNode(3);
      ListNode n3 = new ListNode(4);
      ListNode n4 = new ListNode(0);
      head.next = n1;
      n1.next = n2;
      n2.next = n3;
      n3.next = n4;
      ListNode.PrintLL(head);
      SortLinkedList st = new SortLinkedList();
      ListNode.PrintLL(st.sortList(head));
   }


}
