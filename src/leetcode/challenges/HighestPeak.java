package leetcode.challenges;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/contest/biweekly-contest-46/problems/map-of-highest-peak/
public class HighestPeak {
    // constraint is there is always at least 1 water cell
    public int[][] highestPeak(int[][] isWater) {
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{1, -1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();
        // fill water cells with 0 and others with -1
        for (int row=0; row<isWater.length; row++) {
            for (int col=0; col < isWater[row].length; col++) {
                if (isWater[row][col] == 1) {
                    queue.add(new int[]{row, col});
                    isWater[row][col] = 0;
                    continue;
                }
                isWater[row][col] = -1;
            }
        }

        while (!queue.isEmpty()) {
            int[] indices = queue.poll();
            int row = indices[0];
            int col = indices[1];

            // traverse all possible direction
            for (int i=0; i<4; i++) {
                int currRow = row + dx[i];
                int currCol = col + dy[i];
                // before adding it to queue, validate the boundary condition
                if (currRow < 0 || currRow >= isWater.length || currCol <0 || currCol >= isWater[0].length || isWater[currRow][currCol] != -1) continue;
                isWater[currRow][currCol] = isWater[row][col] + 1;
                queue.offer(new int[]{currRow, currCol});
            }
        }
        return isWater;
    }

    public static void main(String[] args) {
        HighestPeak highestPeak = new HighestPeak();
        print2DArray(highestPeak.highestPeak(new int[][]{{0,0,1}, {1,0,0}, {0,0,0}}));
    }

    private static void print2DArray(int[][] highestPeak) {
        for (int[] arr : highestPeak) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
