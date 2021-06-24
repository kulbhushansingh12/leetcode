package leetcode.challenges;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumNumberOfOperations {
    public int[] minOperations(String boxes) {
        if (boxes == null || boxes.isEmpty())
            return null;
        int[] result = new int[boxes.length()];
        Set<Integer> oneIndex = new HashSet<>();
        int index = 0;
        for (char ch : boxes.toCharArray()) {
            if (ch == '1')
                oneIndex.add(index);

            ++index;
        }

        index = 0;

        for (;index<result.length;index++) {
            int numOperation = 0;
            for (int one : oneIndex) {
                numOperation += Math.abs(one - index);
            }
            result[index] = numOperation;
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumNumberOfOperations numberOfOperations = new MinimumNumberOfOperations();
        System.out.println(Arrays.toString(numberOfOperations.minOperations("110")));
        System.out.println(Arrays.toString(numberOfOperations.minOperations("001011")));
    }
}
