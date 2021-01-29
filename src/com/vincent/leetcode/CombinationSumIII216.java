package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII216 {
    public static void main(String[] args) {
        List<List<Integer>> results = combinationSum3(3, 7);
        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.get(i).size(); j++) {
                System.out.print(results.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        if (n <= 0 || k <= 0 || k > n) {
            return null;
        }
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, new ArrayList<>(), n, k, 1);
        return results;
    }

    private static void dfs(List<List<Integer>> results, List<Integer> items, int n, int k, int position) {
        if (n < 0 || items.size() > k) {
            return;
        } else if (n == 0 && items.size() == k) {
            results.add(new ArrayList<>(items));
        } else {
            for (int i = position; i <= 9; i++) {
                items.add(i);
                dfs(results, items, n - i, k, i + 1);
                items.remove(items.size() - 1);
            }
        }
    }
}
