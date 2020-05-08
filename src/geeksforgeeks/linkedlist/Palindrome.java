package geeksforgeeks.linkedlist;

import java.util.List;

//https://leetcode.com/problems/palindrome-linked-list/
public class Palindrome {
   public boolean isPalindrome(ListNode head) {
      if (head == null || head.next == null)
         return true;
      // find middle node and reverse half of the list
      ListNode slowPointer = head, fastPointer = head, prevNode = null;
      int length = getLength(head);
      //Finding middle
      while (fastPointer != null && fastPointer.next != null) {
         prevNode = slowPointer;
         slowPointer = slowPointer.next;
         fastPointer = fastPointer.next.next;
      }
      if (slowPointer.next == null) {
         if (head.val == head.next.val)
            return true;
         return false;
      }
      ListNode current;
      if (length %2 == 0) {
         current = prevNode.next;
         prevNode.next = null;
      } else {
         current = slowPointer.next;
         slowPointer.next = null;
      }
      ListNode prev = null;
      ListNode next;

      while (current != null) {
         next = current.next;
         current.next = prev;
         prev = current;
         current = next;
      }

      //compare the list
      while (head != null && prev != null) {
         if (head.val != prev.val){
            return false;
         }
         head = head.next;
         prev = prev.next;
      }

      return true;
   }

   public int getLength(ListNode node) {
      int count = 0;
      while (node != null){
         ++count;
         node = node.next;
      }
      return count;
   }

   public static void main(String[] args) {
      test1();
      test2();
      test3();
   }
   private static void test3() {
      ListNode head = new ListNode(1);
      ListNode n1 = new ListNode(1);
      ListNode n2 = new ListNode(2);
      ListNode n3 = new ListNode(1);
      head.next = n1;
      n1.next = n2;
      n2.next = n3;
      Palindrome p = new Palindrome();
      System.out.println(p.isPalindrome(head));
   }
   private static void test1() {
      ListNode head = new ListNode(1);
      ListNode n1 = new ListNode(2);
      head.next = n1;
      Palindrome p = new Palindrome();
      System.out.println(p.isPalindrome(head));
   }

   private static void test2() {
      ListNode head = new ListNode(1);
      ListNode n1 = new ListNode(2);
      ListNode n2 = new ListNode(2);
      ListNode n3 = new ListNode(1);
      head.next = n1;
      n1.next = n2;
      n2.next = n3;
      Palindrome p = new Palindrome();
      System.out.println(p.isPalindrome(head));
   }
}
