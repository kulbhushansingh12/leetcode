package geeksforgeeks.Stack;

import java.util.Stack;

//https://leetcode.com/problems/implement-queue-using-stacks/
public class MyQueue {
   Stack<Integer> stack;
   Stack<Integer> queue;
   private int front;
   /** Initialize your data structure here. */
   public MyQueue() {
      stack = new Stack<>();
      queue = new Stack<>();
   }

   /** Push element x to the back of queue. */
   public void push(int x) {
      if (stack.isEmpty())
         front = x;
      stack.push(x);
   }

   /** Removes the element from in front of queue and returns that element. */
   public int pop() {
      if (queue.isEmpty()) {
         while (!stack.isEmpty())
            queue.push(stack.pop());
      }
      return queue.pop();
   }

   /** Get the front element. */
   public int peek() {
      if (!queue.isEmpty())
         return queue.peek();
      return front;
   }

   /** Returns whether the queue is empty. */
   public boolean empty() {
      return stack.isEmpty() && queue.isEmpty();
   }

   public static void main(String[] args) {
      MyQueue queue = new MyQueue();
      queue.push(1);
      queue.push(2);
      System.out.println(queue.peek());
      System.out.println(queue.pop());
      System.out.println(queue.empty());
   }
}
