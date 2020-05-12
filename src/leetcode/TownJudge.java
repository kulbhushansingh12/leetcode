package leetcode;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/find-the-town-judge/
public class TownJudge {
   public int findJudge(int N, int[][] trust) {
      int[] personsCount = new int[N];

      for (int[] persons : trust) {
         --personsCount[persons[0] - 1];
         ++personsCount[persons[1] - 1];
      }

      for (int i=0; i<N; i++) {
         if (personsCount[i] == N-1)
            return i+1;
      }
      return -1;
   }

   public static void main(String[] args) {
      TownJudge townJudge = new TownJudge();
      System.out.println(townJudge.findJudge(2, new int[][]{{1,2}}));
      System.out.println(townJudge.findJudge(3, new int[][]{{1,3}, {2,3}}));
      System.out.println(townJudge.findJudge(3, new int[][]{{1,3},{2,3},{3,1}}));
      System.out.println(townJudge.findJudge(3, new int[][]{{1,2},{2,3}}));
      System.out.println(townJudge.findJudge(4, new int[][]{{1,3},{1,4}, {2,3}, {2,4}, {4,3}}));
   }
}
