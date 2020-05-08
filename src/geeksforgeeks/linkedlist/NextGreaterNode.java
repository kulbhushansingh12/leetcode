package geeksforgeeks.linkedlist;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-node-in-linked-list/
public class NextGreaterNode {

   public int[] nextLargerNodes(ListNode head) {
      if (head == null )
         return new int[]{};
      Stack<Pair> stack = new Stack<Pair>();
      int length = getLength(head);
      int index = 0;
      int[] result = new int[length];
      while (head != null) {
         while (!stack.isEmpty() && stack.peek().value < head.val) {
            result[stack.pop().key] = head.val;
         }
         stack.push(new Pair(index, head.val));
         head = head.next;
         ++index;
      }

      return result;
   }

   public int getLength(ListNode head) {
      int count = 0;
      while (head != null) {
         ++count;
         head = head.next;
      }
      return count;
   }

   class Pair {
      int key;
      int value;

      public Pair(int key, int value) {
         this.key = key;
         this.value = value;
      }
   }

   public static void main(String[] args) {
      test1();
      test2();
      test3();
   }

   private static void test1() {
      ListNode head = new ListNode(2);
      ListNode n1 = new ListNode(7);
      ListNode n2 = new ListNode(4);
      ListNode n3 = new ListNode(3);
      ListNode n4 = new ListNode(5);

      head.next = n1;
      n1.next = n2;
      n2.next = n3;
      n3.next = n4;

      NextGreaterNode ngn = new NextGreaterNode();
      System.out.println(Arrays.toString(ngn.nextLargerNodes(head)));
   }

   private static void test2() {
      ListNode head = new ListNode(1);
      ListNode n1 = new ListNode(7);
      ListNode n2 = new ListNode(5);
      ListNode n3 = new ListNode(1);
      ListNode n4 = new ListNode(9);
      ListNode n5 = new ListNode(2);
      ListNode n6 = new ListNode(5);
      ListNode n7 = new ListNode(1);

      head.next = n1;
      n1.next = n2;
      n2.next = n3;
      n3.next = n4;
      n4.next = n5;
      n5.next = n6;
      n6.next = n7;

      NextGreaterNode ngn = new NextGreaterNode();
      System.out.println(Arrays.toString(ngn.nextLargerNodes(head)));
   }

   private static void test3() {
      ListNode head = new ListNode(2);
      ListNode n1 = new ListNode(1);
      ListNode n2 = new ListNode(5);

      head.next = n1;
      n1.next = n2;

      NextGreaterNode ngn = new NextGreaterNode();
      System.out.println(Arrays.toString(ngn.nextLargerNodes(head)));
   }

}
