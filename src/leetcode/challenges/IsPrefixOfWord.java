package leetcode.challenges;

//https://leetcode.com/contest/weekly-contest-190/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
public class IsPrefixOfWord {
   public int isPrefixOfWord(String sentence, String searchWord) {
      if (sentence.length() < searchWord.length())
         return -1;

      String[] strArr = sentence.split(" ");

      int index = 1;
      for (String str : strArr) {
         if (str.length()>= searchWord.length() && str.substring(0, searchWord.length()).equals(searchWord))
            return index;
         ++index;
      }

      return -1;
   }

   public static void main(String[] args) {
      IsPrefixOfWord isPrefixOfWord = new IsPrefixOfWord();
      System.out.println(isPrefixOfWord.isPrefixOfWord("i love eating burger", "burg"));
      System.out.println(isPrefixOfWord.isPrefixOfWord("this problem is an easy problem", "pro"));
      System.out.println(isPrefixOfWord.isPrefixOfWord("i am tired", "you"));
      System.out.println(isPrefixOfWord.isPrefixOfWord("i use triple pillow", "pill"));
      System.out.println(isPrefixOfWord.isPrefixOfWord("hello from the other side", "they"));
      System.out.println(isPrefixOfWord.isPrefixOfWord("hello", "ell"));
   }
}
