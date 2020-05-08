package geeksforgeeks.Stack;

//https://leetcode.com/problems/baseball-game/
public class BaseballGame {
   public int calPoints(String[] ops) {
      int validPointer = -1;
      int totalSum = 0;
      for (int i = 0; i< ops.length; i++) {
         int sum = 0;
         switch (ops[i]) {
            case "D":
               sum = 2 * Integer.valueOf(ops[validPointer]);
               ops[++validPointer] = String.valueOf(sum);
               totalSum += sum;
               break;
            case "C":
               totalSum -= (Integer.valueOf(ops[validPointer]));
               --validPointer;
               break;
            case "+":
               sum = Integer.valueOf(ops[validPointer]) + Integer.valueOf(ops[validPointer - 1]);
               ops[++validPointer] = String.valueOf(sum);
               totalSum += sum;
               break;
            default:
               totalSum += Integer.valueOf(ops[i]);
               ops[++validPointer] = ops[i];
         }
      }
      return totalSum;
   }

   public static void main(String[] args) {
      BaseballGame game = new BaseballGame();
      System.out.println(game.calPoints(new String[] {"5","2","C","D","+"}));
      System.out.println(game.calPoints(new String[] {"5","-2","4","C","D","9","+","+"}));
   }
}
