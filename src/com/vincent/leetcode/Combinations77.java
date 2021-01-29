package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations77 {
    public static void main(String[] args) {
        List<List<Integer>> results = combinations(4, 2);
        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.get(i).size(); j++) {
                System.out.print(results.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinations(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return null;
        }
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, n, k, 1, new ArrayList<>());
        return results;
    }

    private static void dfs(List<List<Integer>> results, int n, int k, int position, List<Integer> items) {
        if (items.size() == k) {
            results.add(new ArrayList<>(items));
        } else {
            for (int i = position; i <= n; i++) {
                items.add(i);
                dfs(results, n, k, i + 1, items);
                items.remove(items.size() - 1);
            }
        }
    }
}
