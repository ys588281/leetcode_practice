package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII90 {
    public static void main(String[] args) {
        List<List<Integer>> results = subsetsII(new int[]{1, 2, 2});
        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.get(i).size(); j++) {
                System.out.print(results.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsetsII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return  null;
        }
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, nums, new ArrayList<>(), 0);
        return results;
    }

    private static void dfs(List<List<Integer>> results, int[] nums, List<Integer> items, int position) {
        results.add(new ArrayList<>(items));
        for (int i = position; i < nums.length; i++) {
            if (i > position && nums[i] == nums[i - 1]) {
                continue;
            }
            items.add(nums[i]);
            dfs(results, nums, items, i + 1);
            items.remove(items.size() - 1);
        }
    }
}
