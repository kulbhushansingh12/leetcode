package geeksforgeeks.matrix;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/shortest-path-in-binary-matrix/
public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1)
            return -1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Coordinates> queue = new LinkedList<>();
        queue.add(new Coordinates(0, 0));
        visited[0][0] = true;
        int level = 1;

        int[][] directions = new int[][]{{-1,-1}, {-1,0}, {-1,1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1,1}};

        while (!queue.isEmpty()) {
            for (int index=queue.size(); index>0; index--) {
                Coordinates visitingCoordinate = queue.poll();
                // If we have reached to the end
                if (visitingCoordinate.x == grid.length - 1 && visitingCoordinate.y == grid[0].length - 1) {
                    return level;
                }
                // iterate all directions
                for (int i = 0; i < directions.length; i++) {
                    int dx = visitingCoordinate.x + directions[i][0];
                    int dy = visitingCoordinate.y + directions[i][1];

                    // before adding it to queue check if the next coordinate
                    if (dx >= 0 && dy >= 0 && dx < grid.length && dy < grid[0].length && grid[dx][dy] != 1 && !visited[dx][dy]) {
                        queue.add(new Coordinates(dx, dy));
                        visited[dx][dy] = true;
                    }
                }
            }

            ++level;
        }

        return -1;
    }

    class Coordinates {
        public int x;
        public int y;
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix shortestPathInBinaryMatrix = new ShortestPathInBinaryMatrix();
        System.out.println(shortestPathInBinaryMatrix.shortestPathBinaryMatrix(new int[][]{{0,1}, {1,0}})); // 2
        System.out.println(shortestPathInBinaryMatrix.shortestPathBinaryMatrix(new int[][]{{0,0,0}, {1,1,0}, {1,1,0}}));// 4
        System.out.println(shortestPathInBinaryMatrix.shortestPathBinaryMatrix(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}));//3
    }
}
