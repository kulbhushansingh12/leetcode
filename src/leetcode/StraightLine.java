package leetcode;

//https://leetcode.com/problems/check-if-it-is-a-straight-line/
//ref : http://www.mathcentre.ac.uk/resources/uploaded/mc-ty-strtlines-2009-1.pdf
public class StraightLine {
   // Straight line equation y = mx + c
   public boolean checkStraightLine(int[][] coordinates) {
      if (coordinates.length == 1)
         return true;

      int x2 = coordinates[1][0], x1 = coordinates[0][0], y2 = coordinates[1][1], y1= coordinates[0][1];
      int m = 0;
      if (x2 - x1 == 0)
         m = 1;
      else
         m = (y2 - y1) / (x2 - x1);

      int c = y1 - (m * x1);

      for (int i=0; i<coordinates.length;i++) {
         if ( (coordinates[i][1] - m*coordinates[i][0] - c) != 0)
            return false;
      }
      return true;
   }

   public static void main(String[] args) {
      StraightLine straightLine = new StraightLine();
      System.out.println(straightLine.checkStraightLine(new int[][]{{1,2}, {2,3}, {3,4}, {4,5},{5,6},{6,7}}));
      System.out.println(straightLine.checkStraightLine(new int[][]{{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}}));
   }
}
