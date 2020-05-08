package geeksforgeeks.linkedlist;
//https://www.geeksforgeeks.org/delete-n-nodes-after-m-nodes-of-a-linked-list/
public class SkipMDeleteN {
   static class Node {
      int data;
      Node next;

      public Node(int data) {
         this.data = data;
      }
   }

   public static Node skipMDeleteN(Node head, int m, int n) {
      Node curr = head;
      Node prev = null;
      while (curr != null) {
         int retain = m, delete = n;

         while (retain > 0 && curr != null) {
            prev = curr;
            curr = curr.next;
            --retain;
         }

         while (delete >0 && curr != null) {
            curr = curr.next;
            --delete;
         }
         prev.next = curr;
      }
      return head;
   }

   public static void main(String[] args) {
      Node head = new Node(1);
      Node n1 = new Node(2);
      Node n2 = new Node(3);
      Node n3 = new Node(4);
      Node n4 = new Node(5);
      Node n5 = new Node(6);
      Node n6 = new Node(7);
      Node n7 = new Node(8);
      head.next = n1;
      n1.next = n2;
      n2.next = n3;
      n3.next = n4;
      n4.next = n5;
      n5.next = n6;
      n6.next = n7;

      printLL(skipMDeleteN(head, 3, 2));
   }

   public static void printLL(Node head) {
      while(head != null) {
         System.out.print(head.data+ " ");
         head = head.next;
      }
      System.out.println();
   }
}
