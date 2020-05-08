package geeksforgeeks.linkedlist;

//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
//https://www.geeksforgeeks.org/decimal-equivalent-of-binary-linked-list/
public class DecimalValue {

   public static int getDecimalValue(ListNode head) {
      int sum = 0;

      while (head != null) {
         sum = sum * 2 + head.val;
         head = head.next;
      }
      return sum;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      ListNode n1 = new ListNode(0);
      ListNode n2 = new ListNode(0);

      head.next = n1;
      n1.next = n2;

      System.out.println(getDecimalValue(head));
   }
}
