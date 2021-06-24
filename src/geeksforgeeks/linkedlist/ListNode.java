package geeksforgeeks.linkedlist;

public class ListNode {
   public int val;
   public ListNode next;
   public ListNode(int x) {
      this.val = x;
   }

   public static void PrintLL(ListNode node) {
      while (node != null) {
         System.out.print(node.val + " ");
         node = node.next;
      }
      System.out.println();
   }
}
