package leetcode;

import java.util.Stack;

//https://leetcode.com/problems/min-stack/
public class MinStack {
   Stack<Integer> mainStack;
   Stack<Integer> supportingStack;
   /** initialize your data structure here. */
   public MinStack() {
      mainStack = new Stack<>();
      supportingStack = new Stack<>();
   }

   public void push(int x) {
      mainStack.push(x);
      if (supportingStack.isEmpty() || supportingStack.peek() >= x) {
         supportingStack.push(x);
      }
   }

   public void pop() {
      if ((int)mainStack.pop() == supportingStack.peek() && supportingStack.size() > 0) {
         supportingStack.pop();
      }
   }

   public int top() {
      return mainStack.peek();
   }

   public int getMin() {
      return supportingStack.peek();
   }

   public static void main(String[] args) {
      test1();
      test2();
      test3();
      test4();
   }

   private static void test1() {
      System.out.println("-----------Test1-------------");
      MinStack minStack = new MinStack();
      minStack.push(-2);
      minStack.push(0);
      minStack.push(-3);
      System.out.println(minStack.getMin());
      minStack.pop();
      System.out.println(minStack.top());
      System.out.println(minStack.getMin());
   }

   private static void test2() {
      System.out.println("-----------Test2-------------");
      MinStack minStack = new MinStack();
      minStack.push(0);
      minStack.push(1);
      minStack.push(0);
      System.out.println(minStack.getMin());
      minStack.pop();
      System.out.println(minStack.getMin());
   }

   private static void test3(){
      System.out.println("-----------Test3-------------");
      MinStack minStack = new MinStack();
      minStack.push(2);
      minStack.push(0);
      minStack.push(3);
      minStack.push(0);
      System.out.println(minStack.getMin());
      minStack.pop();
      System.out.println(minStack.getMin());
      minStack.pop();
      System.out.println(minStack.getMin());
      minStack.pop();
      System.out.println(minStack.getMin());
   }

   private static void test4() {
      System.out.println("-----------Test4-------------");
      MinStack minStack = new MinStack();
      minStack.push(512);
      minStack.push(-1024);
      minStack.push(-1024);
      minStack.push(512);
      minStack.pop();
      System.out.println(minStack.getMin());
      minStack.pop();
      System.out.println(minStack.getMin());
      minStack.pop();
      System.out.println(minStack.getMin());
   }
}
