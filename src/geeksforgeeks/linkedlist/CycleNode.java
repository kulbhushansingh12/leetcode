package geeksforgeeks.linkedlist;

//https://leetcode.com/problems/linked-list-cycle-ii/
public class CycleNode {
   //Floyd's algorithm
   public static ListNode detectCycle(ListNode head) {
      if (head == null || head.next == null) {
         return null;
      }
      ListNode slowP = head;
      ListNode fastP = head;
      // With two pointers find the loop
      while (fastP != null && fastP.next != null) {
         slowP = slowP.next;
         fastP = fastP.next.next;
         if (slowP == fastP) {
            break;
         }
      }
      if (fastP == null || fastP.next == null) {
         return null;
      }
      // Reset Slow Pointer to beginning
      slowP = head;

      // move slow and fast pointer by 1
      while (fastP != null) {
         if (slowP == fastP) {
            break;
         }
         slowP = slowP.next;
         fastP = fastP.next;
      }

      return slowP;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      ListNode n1 = new ListNode(2);
      ListNode n2 = new ListNode(3);
      ListNode n3 = new ListNode(4);
      head.next = n1;
      n1.next = n2;
      //n2.next = n3;
      //n3.next = head;

      ListNode cycleNode = detectCycle(head);
      System.out.println(cycleNode);
   }

}
