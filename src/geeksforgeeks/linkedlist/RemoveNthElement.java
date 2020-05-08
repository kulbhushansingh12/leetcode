package geeksforgeeks.linkedlist;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthElement {

   public ListNode removeNthFromEnd(ListNode head, int n) {
      if (head == null)
         return null;
      // find length of List
      int length = getLength(head);
      int nodeToBeRemoved = length - n;
      if (nodeToBeRemoved == 0)
         return head.next;

      int count = 0;
      ListNode curr = head;
      ListNode prev = null;
      while (curr != null) {
         if (count == nodeToBeRemoved) {
            prev.next = curr.next;
            return head;
         }
         prev = curr;
         curr = curr.next;
         ++count;
      }

      return head;
   }

   public int getLength(ListNode head) {
      ListNode temp = head;
      int count = 0;
      while (temp != null) {
         ++count;
         temp = temp.next;
      }
      return count;
   }

   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      //ListNode.PrintLL(new RemoveNthElement().removeNthFromEnd(head, 2));
      ListNode n1 = new ListNode(2);
      ListNode n2 = new ListNode(3);
      ListNode n3 = new ListNode(4);
      ListNode n4 = new ListNode(5);
      //head.next = n1;
      //n1.next = n2;
      ListNode.PrintLL(new RemoveNthElement().removeNthFromEnd(head, 1));
      /*n2.next = n3;
      n3.next = n4;*/

      //ListNode.PrintLL(new RemoveNthElement().removeNthFromEnd(head, 2));
   }
}
