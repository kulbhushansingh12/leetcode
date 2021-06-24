package geeksforgeeks.linkedlist.recursion;

import geeksforgeeks.linkedlist.ListNode;

//https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapPairNodes {
   public ListNode swapPairs(ListNode head) {
      if (head == null || head.next == null)
         return head;
      ListNode prev = null;
      ListNode curr = head;
      head = head.next;
      ListNode pairNext = null;
      ListNode pairPrev = null;
      while (curr != null) {
         if (curr.next == null)
            return head;
         //Convert to pair
         if (curr.next != null) {
            pairNext = curr.next.next;
            curr.next.next = null;
         }
         // Swap Pair nodes
         curr = swapNodes(curr);

         //Linking
         if (pairPrev != null)
            pairPrev.next = curr;
         if(curr.next != null) {
            curr.next.next = pairNext;
            pairPrev = curr.next;
            curr = curr.next.next;
         }
      }
      return head;
   }

   public ListNode swapNodes(ListNode head) {
      if (head.next == null)
         return head;
      ListNode next = head.next;
      head.next = null;
      next.next = head;
      return next;
   }

   public static void main(String[] args) {
      SwapPairNodes spn = new SwapPairNodes();
      ListNode head = new ListNode(1);
      ListNode n1 = new ListNode(2);
      ListNode n2 = new ListNode(3);
      //ListNode n3 = new ListNode(4);
      //ListNode n5 = new ListNode(6);
      head.next = n1;
      n1.next = n2;
      //n2.next = n3;
      ListNode.PrintLL(spn.swapPairsRecursively(head));
   }

   public ListNode swapPairsRecursively(ListNode head) {
      if (head == null || head.next == null) {
         return head;
      }
      ListNode swappedHead = swapNode1(head);

      ListNode node = swapPairsRecursively(swappedHead.next.next);

      swappedHead.next.next = node;

      return swappedHead;
   }

   public ListNode swapNode1(ListNode head) {
      if (head.next == null)
         return head;
      ListNode pairNext = head.next.next;
      ListNode next = head.next;
      head.next = null;
      next.next = head;
      head.next = pairNext;
      return next;
   }
}
