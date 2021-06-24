package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/perfect-squares/
public class PerfectSquares {
    public int numSquares(int n) {
        // find perfect square less than sqrt of n;
        // floor of number is equal to sqrt of number -> add that to list
        // list of coins, target sum is n
        // dp[n+1], dp[0]
        // every index calculate the min
        // dp[i] = Math.min(dp[i], dp[i-coin])

        double numSqrt = Math.sqrt(n);
        if (Math.floor(numSqrt) == numSqrt) {
            return 1;
        }

        List<Integer> validPerfectSquareFactors =  new ArrayList<>();
        validPerfectSquareFactors.add(1);
        for (int i=2; i<=n; i++) {
            // validate if it perfect square
            double sqrt = Math.sqrt(i);
            if (sqrt == Math.floor(sqrt) && i % (int)sqrt == 0) {
                validPerfectSquareFactors.add(i);
            }
        }

        return getMinFactorsForSum(validPerfectSquareFactors, n);
    }

    private int getMinFactorsForSum(List<Integer> validFactors, int target) {
        int[] dp = new int[target+1];
        // fill array with indexes as 1 is  always there
        for (int i=1; i<dp.length; i++) {
            dp[i] = i;
        }
        dp[0] = 0;
        for (int i=1;i<=target; i++) {
            for (Integer factor : validFactors) {
                if (factor <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - factor]);
                }
            }
        }
        return dp[target];
    }

    public int numSquares1(int n) {
        double sqrt = Math.sqrt(n);
        if (Math.floor(sqrt) == sqrt) {
            return 1;
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, n+1);
        dp[0] = 0;

        for (int i=1;i<=n;i++) {
            for (int j=1; j*j <=n; j++) {
                if (j*j <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i- (j*j)]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();
        System.out.println(perfectSquares.numSquares(12));
        System.out.println(perfectSquares.numSquares(13));
    }
}
