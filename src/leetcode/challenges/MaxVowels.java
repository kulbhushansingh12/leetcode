package leetcode.challenges;

//https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
public class MaxVowels {
   public int maxVowels(String s, int k) {
      int maxCount = 0;
      String vowelStr = "a e i o u";
      if (k>s.length())
         return 0;
      for (int i=0; i<= s.length() - k && maxCount < k; i++) {
         int currentCount = 0;
         for (int j=i; j<k + i; j++) {
            if (vowelStr.contains("" +s.charAt(j)))
               ++currentCount;
         }

         if (currentCount > maxCount)
            maxCount = currentCount;
      }
      return maxCount;
   }

   public int maxVowels1(String s, int k) {
      if (k > s.length())
         return 0;

      String vowelStr = "a e i o u";
      int[] countArr = new int[s.length()];
      int startIndex = 0;
      int maxCount = 0;
      int currentCount = 1;
      int currentSum = 0;
      if (vowelStr.contains(""+s.charAt(0))) {
         countArr[0] = 1;
         currentSum = 1;
      }

      for (int i=1;i<s.length() && maxCount < k; i++) {
         if (k==currentCount) {
            --currentCount;
            if (currentSum > maxCount) {
               maxCount = currentSum;
            }
            if (vowelStr.contains(""+s.charAt(startIndex))) {
               --currentSum;
            }
            ++startIndex;
         }
         if (vowelStr.contains(""+s.charAt(i))) {
            currentSum = currentSum + 1;
         }
         countArr[i] = currentSum;
         ++currentCount;
      }

      return maxCount < countArr[countArr.length - 1]? countArr[countArr.length - 1]: maxCount;
   }

   public int maxVowels2(String s, int k) {
      if (k > s.length())
         return 0;
      int currentIndex = 0,k_1Index = 0, maxCount=0, currentCount = 0;

      for (int i=0; i<k; i++) {
         if (isVowel(s.charAt(i))) {
            ++currentCount;
         }
      }
      maxCount = Math.max(maxCount, currentCount);
      for (int i=k; i<s.length() && maxCount < k; i++) {
         if (isVowel(s.charAt(i))) ++currentCount;
         if(isVowel(s.charAt(k_1Index))) --currentCount;
         maxCount = Math.max(maxCount, currentCount);
         ++k_1Index;
      }
      return maxCount;
   }

   private boolean isVowel(char ch) {
      return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
   }

   public static void main(String[] args) {
      MaxVowels maxVowels = new MaxVowels();
      System.out.println(maxVowels.maxVowels2("abciiidef", 3)); // 3
      System.out.println(maxVowels.maxVowels2("aeiou", 2)); //2
      System.out.println(maxVowels.maxVowels2("leetcode", 3)); //2
      System.out.println(maxVowels.maxVowels2("rhythms", 4));//0
      System.out.println(maxVowels.maxVowels2("tryhard", 4));//1
      System.out.println(maxVowels.maxVowels2("weallloveyou", 7));//4

   }
}
