package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrangeWords {

   public String arrangeWords(String text) {
      List<Sorting> words = new ArrayList<>();
      String[] arr = text.split(" ");

      for (String str : arr) {
         words.add(new Sorting(str));
      }

      Collections.sort(words, new LengthSorting().comp1);

      StringBuilder sb = new StringBuilder();
      for (int i = 0; i< words.size(); i++) {
         if (i ==0) {
            String str = words.get(i).word;
            sb.append(String.valueOf(str.charAt(0)).toUpperCase()).append(str.substring(1)).append(" ");
            continue;
         }
         sb.append(words.get(i).word.toLowerCase()).append(" ");
      }

      return sb.toString().substring(0, sb.length() - 1);
   }

   class LengthSorting {
      final Comparator<Sorting> comp1 = new Comparator<Sorting>() {
         @Override
         public int compare(Sorting o1, Sorting o2) {
            if (o1.length == o2.length) {
               return 0;
            } else if (o1.length > o2.length) {
               return 1;
            }
            return -1;
         }
      };
   }

   class Sorting {
      public String word;
      public int length;
      public Sorting(String word) {
         this.word = word;
         this.length = word.length();
      }
   }

   public static void main(String[] args) {
      String str = "[a, b]";
      System.out.println(new StringBuilder(str).deleteCharAt(0).deleteCharAt(str.length()-2));
      ArrangeWords arrangeWords = new ArrangeWords();
      System.out.println(arrangeWords.arrangeWords("Leetcode is cool"));
      System.out.println(arrangeWords.arrangeWords("Keep calm and code on"));
      System.out.println(arrangeWords.arrangeWords("To be or not to be"));
   }

}
