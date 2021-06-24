package leetcode.challenges.september;

// https://leetcode.com/problems/bulls-and-cows/
public class BullsAndCows {
   public String getHint(String secret, String guess) {
      int bullsCount=0, cowCount = 0;
      int[] secretNumArr = new int[10];
      int[] guessedNumArr = new int[10];
      for (int i=0; i<secret.length(); i++) {
         if (secret.charAt(i) == guess.charAt(i)) {
            ++bullsCount;
         } else {
            if (guessedNumArr[secret.charAt(i) - '0'] > 0) {
               ++cowCount;
               guessedNumArr[secret.charAt(i) - '0'] = guessedNumArr[secret.charAt(i) - '0'] - 1;
            } else {
               secretNumArr[secret.charAt(i) - '0'] = secretNumArr[secret.charAt(i) - '0'] + 1;
            }

            if (secretNumArr[guess.charAt(i) - '0'] > 0) {
               ++cowCount;
               secretNumArr[guess.charAt(i) - '0'] = secretNumArr[guess.charAt(i) - '0'] - 1;
            } else {
               guessedNumArr[guess.charAt(i) - '0'] = guessedNumArr[guess.charAt(i) - '0'] + 1;
            }
         }
      }

      return bullsCount + "A"+cowCount+"B";
   }

   public static void main(String[] args) {
      BullsAndCows bullsAndCows = new BullsAndCows();

      System.out.println(bullsAndCows.getHint("1807","7810"));
      System.out.println(bullsAndCows.getHint("1123","0111"));
      System.out.println(bullsAndCows.getHint("2962","7236"));
   }
}
