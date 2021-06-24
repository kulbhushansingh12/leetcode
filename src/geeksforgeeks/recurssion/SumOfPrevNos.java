package geeksforgeeks.recurssion;

import java.util.Arrays;

// i/p -> {1,2,3,4,5}
// o/p -> {1,3,6,10,15}
public class SumOfPrevNos {

    public int[] sumOfPrevIndexNos(int[] nums) {
        // iterative
        for (int i=1; i<nums.length; i++) {
            nums[i] = nums[i-1] + nums[i];
        }
        return nums;
    }

    public int[] sumOfPrevIndexNos1(int[] nums) {
        sumHelper1(nums, 0, 0);
        return nums;
    }

    public void sumHelper(int[] nums, int index) {
        if (index >= (nums.length)){
            return;
        }
        nums[index] = nums[index] + nums[index-1];
        sumHelper(nums, ++index);
    }

    public int sumHelper1(int[] nums, int index, int prevSum) {
        if (index >= (nums.length -1))
            return prevSum;
        int currSum = sumHelper1(nums, ++index, prevSum + nums[index-1]);
        nums[index] += currSum;
        return prevSum;
    }

    public int sumHelper2(int[] nums, int index) {
        if (index == 0)
            return nums[index];
        if (index>nums.length-1) return 0;
        nums[index] += sumHelper2(nums, --index);
        return nums[index];
    }

    public static void main(String[] args) {
        SumOfPrevNos prevNos = new SumOfPrevNos();
        System.out.println(Arrays.toString(prevNos.sumOfPrevIndexNos1(new int[]{1,2,3,4,5})));
    }

}
