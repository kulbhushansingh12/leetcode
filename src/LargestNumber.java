import java.util.List;

public class LargestNumber {

   public int getLargestNum(List<Integer> arr) {
      int result = 0;
      for (int num : arr) {
         if (result < num)
            result = num;
      }
      return result;
   }

   public static void main(String[] args) {
      LargestNumber largestNumber = new LargestNumber();

   }

}
