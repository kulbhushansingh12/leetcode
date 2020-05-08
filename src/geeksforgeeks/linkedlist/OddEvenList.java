package geeksforgeeks.linkedlist;

//https://leetcode.com/problems/odd-even-linked-list/
//https://www.geeksforgeeks.org/rearrange-a-linked-list-such-that-all-even-and-odd-positioned-nodes-are-together/
public class OddEvenList {
   public static ListNode oddEvenList(ListNode head) {
      if (head == null) {
         return null;
      }
      ListNode current = head;
      int i = 2;
      ListNode odd = head;
      ListNode prev = current;
      current =  current.next;
      while (current != null) {
         if (i%2 != 0) {
           prev.next = current.next;
           ListNode temp = odd.next;
           odd.next = current;
           current.next = temp;
           odd = current;
           current = prev.next;
         } else {
            prev = current;
            current = current.next;
         }
         ++i;
      }

      return head;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      ListNode n1 = new ListNode(2);

      head.next = n1;
      printLL(oddEvenList(head));
   }

   public static void printLL (ListNode node) {
      while (node != null) {
         System.out.print(node.val + " ");
         node = node.next;
      }
      System.out.println();
   }
}
