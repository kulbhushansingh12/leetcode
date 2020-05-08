package geeksforgeeks.linkedlist;

//https://www.geeksforgeeks.org/print-reverse-of-a-linked-list-without-actually-reversing/
public class PrintReverseWithoutReversing {
   public static void printReverse(ListNode head) {
      if(head == null)
         return;
      printReverse(head.next);
      System.out.print(head.val + " ");
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      ListNode n1 = new ListNode(2);
      ListNode n2 = new ListNode(3);
      ListNode n3 = new ListNode(4);
      head.next = n1;
      n1.next = n2;
      n2.next = n3;
      printReverse(head);
   }
}
