package leetcode;

//https://leetcode.com/problems/jump-game/
public class JumpGame {
   public boolean canJump(int[] nums) {
      for (int i = 1; i<nums.length; i++) {
         int j=0;
         for (; j<i; j++) {
            if (nums[j] >= (i-j))
               break;
         }
         if (j == i)
            return false;
      }
      return true;
   }

   public boolean canJump1(int[] nums) {

      return false;
   }

   public static void main(String[] args) {
      JumpGame game = new JumpGame();
      System.out.println(game.canJump1(new int[]{2,3,1,1,4}));
      System.out.println(game.canJump(new int[]{3,2,1,0,4}));
   }
}
