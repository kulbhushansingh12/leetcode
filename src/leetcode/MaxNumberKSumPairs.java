package leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/max-number-of-k-sum-pairs/
public class MaxNumberKSumPairs {
    public int maxOperations(int[] nums, int k) {
        int maxOperationCount = 0;
        Map<Integer, Integer> remainingPair = new HashMap<>();
        for (int num: nums) {
            int count = remainingPair.getOrDefault(num, 0);
            if (count > 0) {
                ++maxOperationCount;
                remainingPair.put(num, --count);
            } else {
                remainingPair.put(k - num, remainingPair.getOrDefault(k - num, 0) + 1);
            }
        }
        return maxOperationCount;
    }

    public static void main(String[] args) {
        MaxNumberKSumPairs sumPairs = new MaxNumberKSumPairs();
        System.out.println(sumPairs.maxOperations(new int[] {1,2,3,4}, 5));
        System.out.println(sumPairs.maxOperations(new int[] {3,1,3,4,3}, 6));
        System.out.println(sumPairs.maxOperations(new int[] {2,6}, 6));
    }
}
