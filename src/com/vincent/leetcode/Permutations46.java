package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {
    public static void main(String[] args) {
        List<List<Integer>> results =  permutations(new int[]{0, 1, 2});
        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.get(i).size(); j++) {
                System.out.print(results.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permutations(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, new ArrayList<>(), nums);
        return results;
    }

    private static void dfs(List<List<Integer>> result, List<Integer> items, int[] nums) {
        if (items.size() == nums.length) {
            result.add(new ArrayList<>(items));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
//                System.out.println(i + "-----");
//                for (int j = 0; j < items.size(); j++) {
//                    System.out.print(items.get(j) +  " ");
//                }
//                System.out.println();
//                System.out.println("~~~~");
                if (items.contains(nums[i])) continue;
                items.add(nums[i]);
                dfs(result, items, nums);
//                System.out.print(i + ", ");
//                for (int j = 0; j < items.size(); j++) {
//                    System.out.print(items.get(j) +  " ");
//                }
//                System.out.println();
                items.remove(items.size() - 1);
            }
        }
    }
}
