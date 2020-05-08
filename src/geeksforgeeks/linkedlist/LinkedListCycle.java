package geeksforgeeks.linkedlist;

//https://leetcode.com/problems/linked-list-cycle/
//https://www.geeksforgeeks.org/check-if-a-linked-list-is-circular-linked-list/
public class LinkedListCycle {

   public static boolean hasCycle(ListNode head) {
      if (head == null || head.next == null) {
         return false;
      }
      ListNode slowPointer = head;
      head = head.next;
      while (head != null && head.next != null) {
         if(slowPointer == head) {
            return true;
         }
         slowPointer = slowPointer.next;
         head = head.next.next;
      }
      return false;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      ListNode n1 = new ListNode(2);
      head.next = n1;
      n1.next = head;
      System.out.println(hasCycle(head));
   }
}
