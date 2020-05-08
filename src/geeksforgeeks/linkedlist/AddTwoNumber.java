package geeksforgeeks.linkedlist;

//https://leetcode.com/problems/add-two-numbers-ii/description/
//https://www.geeksforgeeks.org/sum-of-two-linked-lists/
public class AddTwoNumber {
   int carry = 0;
   ListNode result;
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      if (l1 == null )
         return l2;
      if (l2 == null)
         return l1;
      int ll1 = getLength(l1);
      int ll2 = getLength(l2);
      int diff = Math.abs(ll1 - ll2);
      if (diff == 0) {
         addSameSizeNumber(l1, l2);
      } else if (ll1 > ll2) {
           ListNode temp = l1;
           temp = moveList(temp, diff);
           addSameSizeNumber(temp, l2);
           addCarry(l1, diff);
      } else {
         ListNode temp = l2;
         temp = moveList(temp, diff);
         addSameSizeNumber(l1, temp);
         addCarry(l2, diff);
      }

      if (carry != 0) {
         ListNode node = new ListNode(carry);
         node.next = result;
         result = node;
      }

      return result;
   }

   public void addCarry (ListNode node, int diff) {
      if (diff == 0)
         return;
      addCarry(node.next, --diff);
      int sum = node.val + carry;
      carry = sum / 10;
      ListNode newNode = new ListNode(sum % 10);
      newNode.next = result;
      result = newNode;
   }

   public ListNode moveList(ListNode node, int count) {
      while (count-- > 0) {
         node = node.next;
      }
      return node;
   }

   public void addSameSizeNumber(ListNode l1, ListNode l2) {
      if (l1 == null || l2 == null ) {
         return;
      }
      addSameSizeNumber(l1.next, l2.next);

      int sum = l1.val + l2.val + carry;
      int num = sum % 10;
      carry = sum / 10;

      ListNode newNode = new ListNode(num);
      newNode.next = result;
      result = newNode;
   }

   public int getLength(ListNode head) {
      if (head == null) {
         return 0;
      }
      return 1 + getLength(head.next);
   }

   public static void main(String[] args) {
      test1();
      test2();
   }

   public static void test1() {
      ListNode node1 = new ListNode(7);
      ListNode nn1 = new ListNode(2);
      ListNode nn2 = new ListNode(4);
      ListNode nn3 = new ListNode(3);
      node1.next = nn1;
      nn1.next = nn2;
      nn2.next = nn3;

      ListNode node2 = new ListNode(5);
      ListNode n2n1 = new ListNode(6);
      ListNode n2n2 = new ListNode(4);
      node2.next = n2n1;
      n2n1.next = n2n2;

      AddTwoNumber add = new AddTwoNumber();
      ListNode.PrintLL(add.addTwoNumbers(node1, node2));
   }

   public static void test2() {
      ListNode node1 = new ListNode(0);

      ListNode node2 = new ListNode(5);
      ListNode n2n1 = new ListNode(6);
      ListNode n2n2 = new ListNode(4);
      node2.next = n2n1;
      n2n1.next = n2n2;

      AddTwoNumber add = new AddTwoNumber();
      ListNode.PrintLL(add.addTwoNumbers(node2, node1));
   }
}
