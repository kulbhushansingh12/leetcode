package geeksforgeeks.linkedlist;

import java.util.List;

//https://leetcode.com/problems/split-linked-list-in-parts/
public class SplitLL {

   public ListNode[] splitListToParts(ListNode root, int k) {
      int length = getLength(root);
      int windowLength = (length / k) == 0? 1: length/k ;
      int extraNode = length%k == length? 0: length%k;
      ListNode[] result = new ListNode[k];

      for (int i=0; i<k; i++) {
         ListNode current = root;
         ListNode prev = null;
         if (current == null) {
            result[i] = current;
            continue;
         }
         int size = windowLength;
         while (size > 0 && current != null) {
            prev = current;
            current = current.next;
            --size;
         }
         if (extraNode != 0 && current != null) {
            prev = current;
            current = current.next;
            --extraNode;
         }
         if (prev != null)
            prev.next = null;
         result[i] = root;
         root = current;
      }

      return result;
   }

   private int getLength(ListNode root) {
      if (root == null)
         return 0;
      return 1 + getLength(root.next);
   }

   public static void main(String[] args) {
      test1();
      test2();
   }

   private static void test1() {
      System.out.println("---------Test1-------------");
      ListNode root = new ListNode(1);
      ListNode n1 = new ListNode(2);
      ListNode n2 = new ListNode(3);
      root.next = n1;
      n1.next = n2;

      SplitLL splitLL = new SplitLL();
      ListNode[] result = splitLL.splitListToParts(root, 5);
      printList(result);
   }

   private static void test2() {
      System.out.println("---------Test2-------------");
      ListNode root = new ListNode(1);
      ListNode n1 = new ListNode(2);
      ListNode n2 = new ListNode(3);
      ListNode n3 = new ListNode(4);
      ListNode n4 = new ListNode(5);
      ListNode n5 = new ListNode(6);
      ListNode n6 = new ListNode(7);
      ListNode n7 = new ListNode(8);
      ListNode n8 = new ListNode(9);
      ListNode n9 = new ListNode(10);
      root.next = n1;
      n1.next = n2;
      n2.next = n3;
      n3.next = n4;
      n4.next = n5;
      n5.next = n6;
      n6.next = n7;
      n7.next = n8;
      n8.next = n9;
      SplitLL splitLL = new SplitLL();
      ListNode[] result = splitLL.splitListToParts(root, 3);
      printList(result);
   }

   private static void printList(ListNode[] arr) {
        for (int i=0; i<arr.length; i++) {
        ListNode root = arr[i];
        while(root != null) {
           int val = root != null ? root.val: -1;
           System.out.print(root.val + " ");
           root = root.next;
        }
        System.out.println();
        }
        }

        }
