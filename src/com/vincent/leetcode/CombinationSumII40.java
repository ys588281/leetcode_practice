package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII40 {
    public static void main(String[] args) {
        List<List<Integer>> results = combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.get(i).size(); j++) {
                System.out.print(results.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return null;
        }
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, candidates, new ArrayList<>(), target, 0);
        return results;
    }

    private static void dfs(List<List<Integer>> results, int[] candidates, List<Integer> items, int target, int position) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            results.add(new ArrayList<>(items));
        } else {
            for (int i = position; i < candidates.length; i++) {
                if (i > position && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                items.add(candidates[i]);
                dfs(results, candidates, items, target - candidates[i], i + 1);
                items.remove(items.size() - 1);
            }
        }
    }

}
