package leetcode;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

//https://leetcode.com/problems/possible-bipartition/
public class PossibleBipartition {
   public boolean possibleBipartition(int N, int[][] dislikes) {
      TreeMap<Integer, TreeSet<Integer>> partitionMap = new TreeMap<>();
      for (int i=0; i<dislikes.length; i++) {
         TreeSet<Integer> dislikeSet = partitionMap.getOrDefault(dislikes[i][0], new TreeSet<>());
         dislikeSet.add(dislikes[i][1]);
         partitionMap.put(dislikes[i][0], dislikeSet);
      }

      for (Map.Entry<Integer, TreeSet<Integer>> entry : partitionMap.entrySet()) {
         System.out.println(entry.getKey());

      }
      return false;
   }

   public static void main(String[] args) {
      PossibleBipartition possibleBipartition = new PossibleBipartition();
      possibleBipartition.possibleBipartition(4, new int[][]{{1,2}, {1,3}, {2,4}});
   }
}
