package geeksforgeeks.Stack;

import java.util.ArrayDeque;
import java.util.Queue;

//https://leetcode.com/problems/implement-stack-using-queues/
public class MyStack {
   /** Initialize your data structure here. */
   Queue<Integer> queue = new ArrayDeque<>();
   public MyStack() {

   }

   /** Push element x onto stack. */
   public void push(int x) {
      queue.add(x);
      int size = queue.size();
      while (size > 1) {
         queue.add(queue.remove());
         size--;
      }
   }

   /** Removes the element on top of the stack and returns that element. */
   public int pop() {
      return queue.remove();
   }

   /** Get the top element. */
   public int top() {
      return queue.peek();
   }

   /** Returns whether the stack is empty. */
   public boolean empty() {
      return queue.isEmpty();
   }

   public static void main(String[] args) {
      MyStack stack = new MyStack();
      stack.push(1);
      stack.push(2);
      System.out.println(stack.top());
      System.out.println(stack.pop());
      System.out.println(stack.empty());
   }
}
