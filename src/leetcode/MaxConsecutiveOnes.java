package leetcode;

//https://leetcode.com/problems/max-consecutive-ones-iii/
// 1,1,1,0,0,1,1, K=1
public class MaxConsecutiveOnes {
    public int longestOnes(int[] A, int K) {
        if (A.length <= K) {
            return A.length;
        }
        int startIndex = 0, endIndex = 0;
        int max = 0, currentConverted = 0;
        while (startIndex <= endIndex && endIndex < A.length) {
            if (A[endIndex] == 0) {
                if (currentConverted < K) {
                    ++currentConverted;
                } else {
                    ++currentConverted;
                    while (currentConverted > K) {
                        if (A[startIndex] == 0) {
                            --currentConverted;
                        }
                        if (startIndex == endIndex) {
                            endIndex = startIndex;
                        }
                        ++startIndex;
                    }
                }
            }
            ++endIndex;
            max = Math.max(endIndex - startIndex, max);
        }
        return max;
    }


    public int longestOnes1(int[] A, int K) {
        if (A.length <= K) {
            return A.length;
        }

        int max = 0;
        int left=0, right=0, convertedZeroes = 0;

        while (right < A.length) {
            if (A[right] == 0) {
                ++convertedZeroes;
            }

            while (convertedZeroes > K) {
                if (A[left] == 0)
                    --convertedZeroes;

                ++left;
            }
            ++right;
            max = Math.max(max, right - left);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        System.out.println(maxConsecutiveOnes.longestOnes1(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2)); //6
        System.out.println(maxConsecutiveOnes.longestOnes1(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3)); //10
        System.out.println(maxConsecutiveOnes.longestOnes1(new int[]{1,1,1,1,1}, 3));
        System.out.println(maxConsecutiveOnes.longestOnes1(new int[]{0,0,1,1,1,0}, 0));//3
    }
}
