package geeksforgeeks.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/all-paths-from-source-to-target/
public class LC797AllPathToSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currCombs = new ArrayList<>();
        currCombs.add(0);
        //allPaths(graph, graph[0], currCombs, result);
        dfs(graph, 0, currCombs, result);
        return result;
    }

    private void allPaths(int[][] graph, int[] pointsToTraverse, List<Integer> currCombs, List<List<Integer>> result) {
        if (currCombs.size() > 1 && currCombs.get(currCombs.size() - 1) == graph.length - 1) {
            result.add(new ArrayList<>(currCombs));
            return;
        } else {
            for (int point : pointsToTraverse) {
                if (currCombs.contains(point)) continue;
                currCombs.add(point);
                allPaths(graph, graph[point], currCombs, result);
                currCombs.remove(currCombs.size() - 1);
            }
        }
    }

    private void dfs(int[][] graph, int point, List<Integer> currPath, List<List<Integer>> result) {
        if (currPath.get(currPath.size() - 1) == graph.length - 1) {
            result.add(new ArrayList<>(currPath));
            return;
        }

        for (int i=0; i<graph[point].length; i++) {
            currPath.add(graph[point][i]);
            dfs(graph, graph[point][i], currPath, result);
            currPath.remove(currPath.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC797AllPathToSourceTarget pathToSourceTarget = new LC797AllPathToSourceTarget();
        //pathToSourceTarget.allPathsSourceTarget(new int[][]{{1,2}, {3}, {3}, {}});
        pathToSourceTarget.allPathsSourceTarget(new int[][] {{4,3,1},{3,2,4},{3},{4},{}});
    }
}
