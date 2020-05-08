package geeksforgeeks.linkedlist;

//https://www.geeksforgeeks.org/find-length-of-a-linked-list-iterative-and-recursive/
public class LengthOfLinkedList {
   public static int countLength(ListNode head) {
      int count = 0;
      while (head != null) {
         ++count;
         head  = head.next;
      }
      return count;
   }

   public static int countLengthRecursively(ListNode head) {
      if (head == null) {
         return 0;
      }
      return 1 + countLengthRecursively(head.next);
   }
}
