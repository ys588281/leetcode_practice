package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {

    public static void main(String[] args) {
        List<List<Integer>> results = subsets(new int[]{1, 2, 3});
        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.get(i).size(); j++) {
                System.out.print(results.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<List<Integer>> results = new ArrayList<>();
        dfs(nums, results, new ArrayList<>(), 0);
        return results;
    }

    private static void dfs(int[] nums, List<List<Integer>> results, List<Integer> items, int position) {
        results.add(new ArrayList<>(items));
        for (int i = position; i < nums.length; i++) {
            items.add(nums[i]);
            dfs(nums, results, items, i + 1);
            items.remove(items.size() - 1);
        }
    }
}
