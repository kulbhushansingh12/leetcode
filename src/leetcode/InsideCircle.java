package leetcode;

public class InsideCircle {

   private  boolean isInside(int circle_x, int circle_y,
                           int rad, int x, int y)
   {
      if ((x - circle_x) * (x - circle_x) +
              (y - circle_y) * (y - circle_y) <= rad * rad)
         return true;
      else
         return false;
   }



}
