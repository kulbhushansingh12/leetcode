package geeksforgeeks.unionfind;

import java.util.Arrays;

// https://leetcode.com/problems/redundant-connection/
public class LC684RedundantConnection {

    public static void main(String[] args) {
        LC684RedundantConnection redundantConnection = new LC684RedundantConnection();
        System.out.println(Arrays.toString(redundantConnection.findRedundantConnection(new int[][]{{1,2}, {1,3}, {2,3}})));
    }

    public int[] findRedundantConnection(int[][] edges) {
        GraphUnion graphUnion = new GraphUnion(edges.length);
        for (int[] edge : edges) {
            if (graphUnion.union(edge[0]-1, edge[1]-1)) {
                return edge;
            }
        }
        return null;
    }

    // Not writing to different class for practice
    class GraphUnion {
        int[] parents, rank;

        public GraphUnion(int E) {
            parents = new int[E];
            rank = new int[E];

            for (int i=0; i<E; i++) {
                parents[i] = i;
            }
        }
        public int findParent(int p) {
            while(parents[p] != p) {
                parents[p] = parents[parents[p]];
                p = parents[p];
            }
            return p;
        }

        public boolean union(int p, int q) {
            int pRoot = findParent(p);
            int qRoot = findParent(q);

            if (pRoot == qRoot)
                return true;

            if (rank[pRoot] > rank[qRoot]) {
                parents[qRoot] = pRoot;
            } else {
                parents[pRoot] = qRoot;
                if (rank[pRoot] == rank[qRoot]) {
                    rank[pRoot]++;
                }
            }
            return false;
        }
    }
}
