package leetcode;

/**
 * Time complexity would be M*N
 */
public class GroupCount {
   public static int countGroups(int[][] mat) {
      int count = 0;
      for (int row=0; row<mat.length; row++) {
         for (int col = 0; col < mat[row].length; col++) {
            if (mat[row][col] == 1) {
               ++count;
               countGroupHelperFunction(mat, row, col);
            }
         }
      }
      return count;
   }

   public static void countGroupHelperFunction(int[][] mat, int row, int col) {
      if(row < 0 || row >= mat.length || col < 0 || col >= mat[row].length || mat[row][col] == 0) {
         return;
      }
      mat[row][col] = 0;
      countGroupHelperFunction(mat, row+1, col); //up
      countGroupHelperFunction(mat, row-1, col); //down
      countGroupHelperFunction(mat, row, col-1); //left
      countGroupHelperFunction(mat, row, col+1); //right
   }

   public static void main(String[] args) {
      test1();
      test2();
      test3();
      test4();
   }

   private static void test1() {
      int count = countGroups(new int[][]{{1, 1, 0, 0, 1},
                                          {0, 1, 0, 0, 1},
                                          {1, 1, 0, 1, 0}}); //3
      System.out.println(count == 3);
   }

   private static void test2() {
      int count = countGroups(new int[][]{{1, 0, 0, 0, 1},
                                          {0, 0, 0, 0, 0},
                                          {0, 0, 0, 1, 0}});//3
      System.out.println(count == 3);
   }

   private static void test3() {
      int count = countGroups(new int[][]{{1, 1, 1, 0, 0, 0},
                                          {0, 0, 1, 0, 0, 0},
                                          {1, 0, 1, 0, 0, 0},
                                          {1, 1, 1, 0, 0, 0}}); // 1
      System.out.println(count == 1);
   }

   private static void test4() {
      int count = countGroups(new int[][]{{1, 1, 1, 1, 1},
                                          {1, 0, 1, 0, 1},
                                          {1, 1, 1, 1, 1}}); //1
      System.out.println(count == 1);
   }
}
