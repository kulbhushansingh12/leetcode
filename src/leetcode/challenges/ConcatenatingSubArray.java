package leetcode.challenges;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/contest/biweekly-contest-46/problems/form-array-by-concatenating-subarrays-of-another-array/
public class ConcatenatingSubArray {
    public boolean canChoose(int[][] groups, int[] nums) {
        // row index and subarray strat end index
        Map<Integer, Index> startEndIndexMapping = new HashMap<>();
        for (int i=0; i < groups.length ; i++) {
            Index index = isGroupPresent(groups[i], nums);
            if (index.startIndex == -1) {
                return false;
            }
            startEndIndexMapping.put(i, index);
        }

        int prevEndIndex = -1, startIndex = -1;
        for (Map.Entry<Integer, Index> entrySet : startEndIndexMapping.entrySet()) {
            Index index = entrySet.getValue();
            if (!(index.startIndex > prevEndIndex)) {
                return false;
            }
            prevEndIndex = index.endIndex;
        }
        return true;
    }

    private Index isGroupPresent (int[] groupArr, int[] nums) {
        // Two pointers to traverse the arrays
        for (int i = 0; i<(nums.length - groupArr.length + 1); i++) {
            int j=0;
            for (; j<groupArr.length; j++) {
                if (nums[i+j] != groupArr[j]) {
                    break;
                }
            }
            if (j == groupArr.length) {
                return new Index(i, i + j - 1);
            }
        }
        return new Index();
    }


    class Index {
        public int startIndex;
        public int endIndex;
        public Index() {
            this.startIndex = -1;
            this.endIndex = -1;
        }
        public Index(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }

    public static void main(String[] args) {
        ConcatenatingSubArray subArray = new ConcatenatingSubArray();
        System.out.println(subArray.canChoose(new int[][]{{1,2,3}, {3,4}}, new int[]{7,7,1,2,3,4,7,7}));
        System.out.println(subArray.canChoose(new int[][]{{1,2,3}, {3,4}}, new int[]{7,7,1,2,3,4,7,7}));
    }
}
