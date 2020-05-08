package geeksforgeeks.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/linked-list-components/

/**
 * Explaination of the problem is bad. it's grouping of the components.
 *[0,1,2,3,4,5]
 * [2,3,4,5]
 * o/p: 1
 */
public class LinkedComponent {
   public int numComponents(ListNode head, int G[]) {
      List<Integer> components = convertToList(G);
      int count = 0;
      while (head != null) {
         if (components.contains(head.val)) {
            ++count;
            while (head != null && components.contains(head.val)) {
               head = head.next;
            }
         } else
            head = head.next;
      }
      return count;
   }

   private List<Integer> convertToList(int[] g) {
      List<Integer> result = new ArrayList<>();
      for (int num : g) {
         result.add(num);
      }
      return result;
   }

   public static void main(String[] args) {
      test1();
      test2();
      test3();
   }
   private static void test1() {
      ListNode head = new ListNode(0);
      ListNode n1 = new ListNode(1);
      ListNode n2 = new ListNode(2);
      ListNode n3 = new ListNode(3);
      head.next = n1;
      n1.next = n2;
      n2.next = n3;

      LinkedComponent component = new LinkedComponent();
      System.out.println(component.numComponents(head, new int[]{0,1,3}));
   }

   private static void test2() {
      ListNode head = new ListNode(0);
      ListNode n1 = new ListNode(1);
      ListNode n2 = new ListNode(2);
      ListNode n3 = new ListNode(3);
      ListNode n4 = new ListNode(4);
      head.next = n1;
      n1.next = n2;
      n2.next = n3;
      n3.next = n4;

      LinkedComponent component = new LinkedComponent();
      System.out.println(component.numComponents(head, new int[]{0,1,3,4}));
   }

   private static void test3() {
      ListNode head = new ListNode(0);
      ListNode n1 = new ListNode(1);
      ListNode n2 = new ListNode(2);
      ListNode n3 = new ListNode(3);
      ListNode n4 = new ListNode(4);
      head.next = n1;
      n1.next = n2;
      n2.next = n3;
      n3.next = n4;

      LinkedComponent component = new LinkedComponent();
      System.out.println(component.numComponents(head, new int[]{2,3,4}));
   }
}
