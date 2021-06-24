package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

//https://leetcode.com/contest/weekly-contest-189/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/
public class PeopleIndexes {
   public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
      List<Integer> result = new ArrayList<>();

      List<Set<Integer>> list = favoriteCompanies.stream().map(
              l -> l.stream().map(String::hashCode).collect(Collectors.toSet()))
              .collect(toList());

      boolean[] resArr = new boolean[favoriteCompanies.size()];
      for (int i=0; i<favoriteCompanies.size(); i++) {
         for (int j = 0; j < favoriteCompanies.size(); j++) {
            if (j != i && list.get(j).containsAll(list.get(i))) {
               resArr[i] = true;
               break;
            }
         }
      }

      for (int i=0; i<resArr.length; i++) {
         if (!resArr[i]) result.add(i);
      }
      return result;
   }

   public static void main(String[] args) {
      test1();
   }

   private static void test1() {
      PeopleIndexes peopleIndexes = new PeopleIndexes();
      List<List<String>> request = new ArrayList<>();
      List<String> strings = new ArrayList<>();
      strings.add("leetcode");
      strings.add("google");
      strings.add("facebook");
      request.add(strings);
      List<String> strings1 = new ArrayList<>();
      strings1.add("google");
      strings1.add("microsoft");
      request.add(strings1);
      List<String> strings2 = new ArrayList<>();
      strings2.add("google");
      strings2.add("facebook");
      request.add(strings2);
      request.add(Collections.singletonList("google"));
      request.add(Collections.singletonList("amazon"));
      List<Integer> result = peopleIndexes.peopleIndexes(request);
      System.out.println(Arrays.toString(result.toArray()));
   }

   private static void test2() {
      PeopleIndexes peopleIndexes = new PeopleIndexes();
      List<List<String>> request = new ArrayList<>();
      List<String> strings = new ArrayList<>();
      strings.add("leetcode");
      strings.add("google");
      strings.add("facebook");
      request.add(strings);
      List<String> strings1 = new ArrayList<>();
      strings1.add("google");
      strings1.add("microsoft");
      request.add(strings1);
      List<String> strings2 = new ArrayList<>();
      strings2.add("google");
      strings2.add("facebook");
      request.add(strings2);
      request.add(Collections.singletonList("google"));
      request.add(Collections.singletonList("amazon"));
      List<Integer> result = peopleIndexes.peopleIndexes(request);
      System.out.println(Arrays.toString(result.toArray()));
   }
}
