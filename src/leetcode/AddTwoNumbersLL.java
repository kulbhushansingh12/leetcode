package leetcode;

public class AddTwoNumbersLL {

   public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode head = null;
      ListNode tail ;
      int carry;

      if (l1 != null && l2 != null) {
         int sum = l1.val + l2.val;
         l1 = l1.next;
         l2 = l2.next;

         head = new ListNode(sum % 10);
         tail = head;
         carry = sum / 10;
         if (l1 == null && l2 == null && carry != 0)  {
            tail = new ListNode(carry);
            head.next = tail;
            tail.next = null;
            return head;
         }

         while (l1 != null || l2 != null) {
            sum = 0;
            if (l1 != null) {
               sum = l1.val;
               l1 = l1.next;
            }
            if (l2 != null) {
               sum += l2.val;
               l2 = l2.next;
            }
            sum += carry;
            ListNode newNode = new ListNode(sum % 10);
            tail.next = newNode;
            tail = newNode;
            carry = sum / 10;
         }

         if (carry != 0) {
            tail.next = new ListNode(carry);
         }
      }

      return head;
   }

   public static void main(String[] args) {
      test2();
      System.out.println();
      test1();
      System.out.println();
      test3();
   }

   public static void test1() {
      ListNode l1 = new ListNode(2);
      l1.next = new ListNode(4);
      l1.next.next = new ListNode(3);
      ListNode l2 = new ListNode(5);
      l2.next = new ListNode(6);
      l2.next.next = new ListNode(4);
      printList(addTwoNumbers(l1, l2));
   }

   public static void test2() {
      printList(addTwoNumbers(new ListNode(0), new ListNode(0)));
   }

   public static void test3() {
      ListNode l2 = new ListNode(7);
      l2.next = new ListNode(3);
      printList(addTwoNumbers(new ListNode(0), l2));
   }

   public static void printList(ListNode head) {
      while (head != null) {
         System.out.print(head.val + " ");
         head = head.next;
      }
   }
}


class ListNode {
   int val;
   ListNode next;
   ListNode(int x) {
      val = x;
   }
}