package leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3313/
public class FirstUnique {
   Node head  =new Node();
   Node tail = new Node();

   Map<Integer, Node> values = new HashMap<>();
   int size = 0;
   public FirstUnique(int[] nums) {
      head.next = tail;
      tail.prev = head;
      for (int num : nums) {
         add(num);
      }
   }

   public int showFirstUnique() {
      return size == 0 ? -1 : tail.prev.value;
   }

   public void add(int value) {
      if (values.get(value) != null) {
         deleteNode(values.get(value));
         size = size > 0 ? --size: size;
      } else {
         Node node = new Node();
         node.value = value;
         ++size;
         addNode(node);
         values.put(value, node);
      }
   }

   public void addNode (Node node) {
      Node headNext = head.next;
      head.next = node;
      node.prev = head;
      headNext.prev = node;
      node.next = headNext;
   }
   public void deleteNode(Node node) {
      if (!node.isRemoved) {
         Node nextNode = node.next;
         Node prev = node.prev;
         prev.next = nextNode;
         nextNode.prev = prev;
      }
   }

   class Node {
      boolean isRemoved;
      int value;
      Node next;
      Node prev;
   }

   public static void main(String[] args) {
      test1();
      test2();
      test3();
   }

   private static void test1() {
      System.out.println("==========Test1==========");
      FirstUnique firstUnique = new FirstUnique(new int[]{2,3,5});
      System.out.println(firstUnique.showFirstUnique());
      firstUnique.add(5);
      System.out.println(firstUnique.showFirstUnique());
      firstUnique.add(2);
      System.out.println(firstUnique.showFirstUnique());
      firstUnique.add(3);
      System.out.println(firstUnique.showFirstUnique());
   }

   private static void test2() {
      System.out.println("=======Test2==============");
      FirstUnique firstUnique = new FirstUnique(new int[]{7,7,7,7,7,7});
      System.out.println(firstUnique.showFirstUnique());
      firstUnique.add(7);
      firstUnique.add(3);
      firstUnique.add(3);
      firstUnique.add(7);
      firstUnique.add(17);
      System.out.println(firstUnique.showFirstUnique());
   }

   private static void test3() {
      System.out.println("==========Test3==========");
      FirstUnique firstUnique = new FirstUnique(new int[]{809});
      System.out.println(firstUnique.showFirstUnique());
      firstUnique.add(809);
      System.out.println(firstUnique.showFirstUnique());
   }
}
