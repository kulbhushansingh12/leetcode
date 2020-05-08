package geeksforgeeks.linkedlist;

//https://leetcode.com/problems/intersection-of-two-linked-lists/
public class Intersection {
   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      if (headA == null || headB == null)
         return null;
      int l1 = getLength(headA);
      int l2 = getLength(headB);
      int diff = Math.abs(l1 - l2);
      if (l1 > l2) {
         headA = moveList(headA, diff);
      } else if (l2 > l1) {
         headB = moveList(headB, diff);
      }
      boolean isZero = false;
      while (headA != null && headB != null) {
         if (headA.val == headB.val  && !isZero){
            return headA;
         }
         isZero = headA.val == 0 || headB.val == 0 ? true : false;
         headA = headA.next;
         headB = headB.next;
      }
      return null;
   }

   private ListNode moveList(ListNode head, int count) {
      if (count == 0)
         return head;
      return moveList(head.next, --count);
   }

   private int getLength(ListNode head) {
      int count = 0;
      while(head != null) {
         ++count;
         head = head.next;
      }
      return count;
   }

   public static void main(String[] args) {
      test1();
      test2();
      test3();
   }

   private static void test1() {
      ListNode headA = new ListNode(4);
      ListNode n1 = new ListNode(1);
      ListNode n2 = new ListNode(8);
      ListNode n3 = new ListNode(4);
      ListNode n4 = new ListNode(5);
      headA.next = n1;
      n1.next = n2;
      n2.next = n3;
      n3.next = n4;

      ListNode headB = new ListNode(5);
      ListNode b1 = new ListNode(0);
      ListNode b2 = new ListNode(1);
      ListNode b3 = new ListNode(8);
      ListNode b4 = new ListNode(4);
      ListNode b5 = new ListNode(5);
      headB.next = b1;
      b1.next = b2;
      b2.next = b3;
      b3.next = b4;
      b4.next = b5;

      Intersection i = new Intersection();
      System.out.println(i.getIntersectionNode(headA, headB).val);
   }

   private static void test2() {
      ListNode headA = new ListNode(0);
      ListNode n1 = new ListNode(9);
      ListNode n2 = new ListNode(1 );
      ListNode n3 = new ListNode(2);
      ListNode n4 = new ListNode(4);
      headA.next = n1;
      n1.next = n2;
      n2.next = n3;
      n3.next = n4;

      ListNode headB = new ListNode(3);
      ListNode b1 = new ListNode(2);
      ListNode b2 = new ListNode(4);
      headB.next = b1;
      b1.next = b2;
      Intersection i = new Intersection();
      System.out.println(i.getIntersectionNode(headA, headB).val);
   }

   private static void test3() {
      ListNode headA = new ListNode(2);
      ListNode n1 = new ListNode(6);
      ListNode n2 = new ListNode(4);
      headA.next = n1;
      n1.next = n2;


      ListNode headB = new ListNode(1);
      ListNode b1 = new ListNode(5);
      headB.next = b1;
      Intersection i = new Intersection();
      System.out.println(i.getIntersectionNode(headA, headB));
   }

}
