package leetcode;

//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3299/
public class StringShift {
   public String stringShift(String s, int[][] shift) {
      int left = 0, right = 0;
      for (int i=0; i< shift.length; i++) {
         if (shift[i][0] == 1)
            right += shift[i][1];
         else
            left += shift[i][1];
      }
      int num = (right - left) % s.length();
      if (num > 0)
         return s.substring(s.length()- num) + s.substring(0, s.length()- num);
      else if (num < 0)
         return s.substring(num * -1) + s.substring(0, num * -1);
      return s;
   }

   public static void main(String[] args) {
      StringShift ss = new StringShift();
      /*System.out.println(ss.stringShift("abc", new int[][] {new int[]{0,1}, new int[]{1,2}}));
      System.out.println(ss.stringShift("abcdefg", new int[][] {new int[]{1,1}, new int[]{1,1}, new int[]{0,2},
              new int[]{1,3}}));
      System.out.println(ss.stringShift("wpdhhcj", new int[][]{new int[]{0,7}, new int[]{1,7}, new int[]{1,0},
            new int[]{1,3}, new int[]{0,3}, new int[]{0,6}, new int[]{1,2}}));*/
      System.out.println(ss.stringShift("yisxjwry", new int[][]{new int[]{1,8}, new int[]{1,4}, new int[]{1,3},
         new int[]{1,6}, new int[]{0,6}, new int[]{1,4}, new int[]{0,1}, new int[]{0,2}}));
   }
}
