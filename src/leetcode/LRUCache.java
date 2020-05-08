package leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/lru-cache/
public class LRUCache {

   private static Map<Integer, Node> cacheMap;
   private int capacity;
   Node head = new Node();
   Node tail = new Node();

   public LRUCache(int capacity) {
      cacheMap = new HashMap<>(capacity);
      this.capacity = capacity;
      head.next = tail;
      tail.prev = head;
   }

   public int get(int key) {
      // move it to front
      if (cacheMap.get(key) != null) {
         Node node = cacheMap.get(key);
         remove(node);
         add(node);
         return node.value;
      }
      return -1;
   }

   public void put(int key, int value) {
      if (cacheMap.get(key) != null) {
         //Update of the value
         Node node = cacheMap.get(key);
         remove(node);
         node.value = value;
         add(node);
         cacheMap.put(key, node);
      } else {
         if (cacheMap.size() == capacity) {
            cacheMap.remove(tail.prev.key);
            remove(tail.prev);
         }
         Node newNode = new Node();
         newNode.value = value;
         newNode.key = key;
         add(newNode);
         cacheMap.put(key, newNode);
      }
   }

   private void add(Node node) {
      Node nextNode = head.next;
      head.next = node;
      node.prev = head;
      node.next = nextNode;
      nextNode.prev = node;
   }

   private void remove(Node node) {
      Node nextNode = node.next;
      Node prevNode = node.prev;

      prevNode.next = nextNode;
      nextNode.prev = prevNode;
   }

   class Node {
      int key;
      int value;
      Node next;
      Node prev;
   }

   public static void main(String[] args) {
      LRUCache cache = new LRUCache(2);
      cache.put(1, 1);
      cache.put(2, 2);
      System.out.println(cache.get(1));       // returns 1
      cache.put(3, 3);    // evicts key 2
      System.out.println(cache.get(2));       // returns -1 (not found)
      cache.put(4, 4);    // evicts key 1
      System.out.println(cache.get(1));       // returns -1 (not found)
      System.out.println(cache.get(3));       // returns 3
      System.out.println(cache.get(4));       // returns 4
   }
}
