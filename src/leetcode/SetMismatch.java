package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/set-mismatch/
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int[] occurrences = new int[nums.length];
        for (int num : nums) {
            occurrences[num-1] = occurrences[num-1] + 1;
        }

        for (int i=0; i< occurrences.length; i++) {
            if (occurrences[i] > 1) {
                res[0] = i+1;
            }

            if (occurrences[i] == 0) {
                res[1] = i+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SetMismatch setMismatch = new SetMismatch();
        System.out.println(Arrays.toString(setMismatch.findErrorNums(new int[]{1, 1})));
        System.out.println(Arrays.toString(setMismatch.findErrorNums(new int[]{1,2,2,4})));
        System.out.println(Arrays.toString(setMismatch.findErrorNums(new int[]{1,5,3,2,2,7,6,4,8,9})));
    }
}
