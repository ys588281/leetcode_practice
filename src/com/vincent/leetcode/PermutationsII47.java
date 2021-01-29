package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII47 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> permutationsII(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, results, isVisited, new ArrayList<>());
        return results;
    }

    public static void helper(int[] nums, List<List<Integer>> results, boolean[] isVisited, List<Integer> res) {
        if (res.size() == nums.length) {
            results.add(new ArrayList<>(res));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i - 1] == nums[i] && !isVisited[i - 1]) {
                    continue;
                }
                if (!isVisited[i]) {
                    res.add(nums[i]);
                    isVisited[i] = true;
                    helper(nums, results, isVisited, res);
                    res.remove(res.size() - 1);
                    isVisited[i] = false;
                }
            }
        }
    }
}
