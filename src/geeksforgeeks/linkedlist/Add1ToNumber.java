package geeksforgeeks.linkedlist;

public class Add1ToNumber {

   static class Node
   {
      int data;
      Node next;

      public Node(int data) {
         this.data = data;
      }
   }

   public static Node add1ToNumber(Node head) {
      head = reverseLL(head);
      int carry = 0;
      boolean firstNum = true;
      Node firstNode = head, tail = null;
      while (head != null) {
         int sum = carry;
         if (firstNum) {
            sum += 1;
            firstNum = false;
         }
         sum += head.data;
         head.data = sum % 10;
         carry = sum / 10;
         tail = head;
         head = head.next;
      }

      if (carry != 0)  {
         tail.next = new Node(carry);
      }
      return reverseLL(firstNode);
   }

   public static Node reverseLL(Node head) {
      Node current = head;
      Node prev = null;
      Node next = null;
      while (current != null) {
         next = current.next;
         current.next = prev;
         prev = current;
         current = next;
      }
      return prev;

   }

   public static void main(String[] args) {
      Node head = new Node(1);
      Node n1 = new Node(0);
      Node n2 = new Node(1);
      head.next = n1;
      n1.next = n2;
      printLL(add1ToNumber(head));
   }

   public static void printLL(Node node) {
      while (node != null) {
         System.out.print(node.data + " ");
         node = node.next;
      }
      System.out.println();
   }

}
