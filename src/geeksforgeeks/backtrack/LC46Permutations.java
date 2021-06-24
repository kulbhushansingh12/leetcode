package geeksforgeeks.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/permutations/
public class LC46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        /*result.add(new ArrayList<>());
        permuteHelper(nums, result, 0);*/
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currComb, int[] nums) {
        if (currComb.size() == nums.length) {
            result.add(new ArrayList(currComb));
        } else {
            for (int i=0; i<nums.length; i++) {
                if (currComb.contains(nums[i])) continue;
                currComb.add(nums[i]);
                backtrack(result, currComb, nums);
                currComb.remove(currComb.size() - 1);
            }
        }
    }

    public void permuteHelper(int[] nums, List<List<Integer>> result, int currIndex) {
        if (currIndex == nums.length) {
            return;
        }

        int currElement = nums[currIndex];
        List<List<Integer>> currCombs = new ArrayList<>();
        for (List<Integer> combs : result){
            currCombs.addAll(addToEveryIndex(combs, currElement));
        }
        result.clear();
        result.addAll(currCombs);
        permuteHelper(nums, result, ++currIndex);
    }

    private List<List<Integer>> addToEveryIndex(List<Integer> combs, int currElement) {
        List<List<Integer>> combinations = new ArrayList<>();
        for (int i=0; i<= combs.size(); i++) {
            List<Integer> currComb = new ArrayList<>(combs);
            currComb.add(i, currElement);
            combinations.add(currComb);
        }
        return combinations;
    }

    public static void main(String[] args) {
        LC46Permutations permutations = new LC46Permutations();
        List<List<Integer>> result = permutations.permute(new int[]{1,2,3});
        System.out.println(result.size());
    }
}
