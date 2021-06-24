package geeksforgeeks.Stack;

import java.util.Stack;

//https://leetcode.com/problems/online-stock-span/
public class StockSpanner {
   Stack<Spanner> stock;
   public StockSpanner() {
      stock = new Stack<>();
   }

   public int next(int price) {
      int span = 1;
      while (!stock.isEmpty() && stock.peek().price <= price) {
         span += stock.pop().span;
      }

      stock.push(new Spanner(price, span));
      return span;
   }

   class Spanner {
      int price;
      int span;
      public Spanner(int price, int span) {
         this.price = price;
         this.span = span;
      }
   }

   public static void main(String[] args) {
      StockSpanner spanner = new StockSpanner();
      System.out.println(spanner.next(100));
      System.out.println(spanner.next(80));
      System.out.println(spanner.next(60));
      System.out.println(spanner.next(70));
      System.out.println(spanner.next(60));
      System.out.println(spanner.next(75));
      System.out.println(spanner.next(85));
   }
}
