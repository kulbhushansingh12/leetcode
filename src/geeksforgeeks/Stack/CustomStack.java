package geeksforgeeks.Stack;

import java.util.Stack;

//https://leetcode.com/problems/design-a-stack-with-increment-operation/
public class CustomStack {
   int maxSize;
   Stack<Integer> stack;
   public CustomStack(int maxSize) {
      this.maxSize = maxSize;
      stack = new Stack<>();
   }

   public void push(int x) {
      if (stack.isEmpty() || stack.size() < maxSize)
         stack.push(x);
   }

   public int pop() {
      return stack.isEmpty()? -1 : stack.pop();
   }

   public void increment(int k, int val) {
      Stack<Integer> tempStack = new Stack<>();
      while(!stack.isEmpty())
         tempStack.push(stack.pop());

      while (!tempStack.isEmpty() && k > 0) {
         stack.push(tempStack.pop() + val);
         --k;
      }

      while(!tempStack.isEmpty())
         stack.push(tempStack.pop());
   }


   public static void main(String[] args) {
      CustomStack customStack = new CustomStack(3); // Stack is Empty []
      customStack.push(1);                          // stack becomes [1]
      customStack.push(2);                          // stack becomes [1, 2]
      System.out.println(customStack.pop());
      customStack.push(2);                          // stack becomes [1, 2]
      customStack.push(3);                          // stack becomes [1, 2, 3]
      customStack.push(4);                          // stack still [1, 2, 3], Don't add
      customStack.increment(5, 100);                // stack becomes [101, 102, 103]
      customStack.increment(2, 100);                // stack becomes [201, 202, 103]
      System.out.println(customStack.pop());                            // return 103 --> Return top of the
      System.out.println(customStack.pop());
      System.out.println(customStack.pop());
      System.out.println(customStack.pop());
   }
}
