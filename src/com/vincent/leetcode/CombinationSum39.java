package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {

    public static void main(String[] args) {
        List<List<Integer>> results = combinationSum(new int[]{2,3,6,7}, 7);
        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.get(i).size(); j++) {
                System.out.print(results.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return null;
        }
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, candidates, target, new ArrayList<>(), 0);
        return results;
    }

    private static void dfs(List<List<Integer>> results, int[] candidates, int target, List<Integer> items, int position) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            results.add(new ArrayList<>(items));
        } else {
            for (int i = position; i < candidates.length; i++) {
                items.add(candidates[i]);
                dfs(results, candidates, target - candidates[i], items, i);
                items.remove(items.size() - 1);
            }
        }
    }
}
