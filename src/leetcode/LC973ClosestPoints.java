package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/k-closest-points-to-origin/
public class LC973ClosestPoints {
    public int[][] kClosest(int[][] points, int k) {
        if (k >= points.length) {
            return points;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> (o[0] * o[0] + o[1] * o[1])));
        return Arrays.copyOfRange(points, 0, k);
    }

    public int[][] kClosest1(int[][] points, int k) {
        if (k >= points.length) {
            return points;
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(((o1, o2) -> Integer.compare((o1[0] * o1[0] + o1[1] * o1[1]),
                o2[0] * o2[0] + o2[1] * o2[1]) * -1));
        for (int[] point : points) {
            priorityQueue.offer(point);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int[][] res = new int[k][2];
        while (k > 0) {
            res[--k] = priorityQueue.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        LC973ClosestPoints closestPoints = new LC973ClosestPoints();
        closestPoints.kClosest(new int[][]{{1,3}, {-2,2}}, 1);
    }
}
