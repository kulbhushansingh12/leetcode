package geeksforgeeks.unionfind;

// https://leetcode.com/problems/number-of-provinces/
public class LC547NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        GraphUnion graphUnion = new GraphUnion(isConnected.length);
        for (int row=0; row<isConnected.length - 1; row++) {
            for (int col = row + 1; col < isConnected[row].length; col++) {
                if (isConnected[row][col] == 1) {
                    graphUnion.union(row, col);
                }
            }
        }
        return graphUnion.count;
    }


    class GraphUnion {
        int[] parent, rank;
        int count;

        // Pass Number of edges
        public GraphUnion(int E) {
            parent = new int[E];
            rank = new int[E];
            count = E;
            for (int i=0; i<E; i++) {
                parent[i] = i;
            }
        }

        // return the parent of the node
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);

            if (pRoot == qRoot)
                return;

            if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
            } else {
                parent[pRoot] = qRoot;
                if (rank[qRoot] == rank[pRoot]) {
                    qRoot++;
                }
            }
            --count;
        }
    }
    public static void main(String[] args) {
        LC547NumberOfProvinces numberOfProvinces = new LC547NumberOfProvinces();
        System.out.println(numberOfProvinces.findCircleNum(new int[][] {{1,1,1}, {1,1,1}, {1,1,1}}));//1
    }
}
