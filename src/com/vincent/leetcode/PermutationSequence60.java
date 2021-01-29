package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PermutationSequence60 {

    public static void main(String[] args) {
        System.out.println(permutationSequence(3, 3));
    }

    public static String permutationSequence(int n, int k) {
        List<List<Integer>> results =  new ArrayList<>();
        helper(n, results, new ArrayList<>());
        results.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                for (int i = 0; i < n; i++) {
                    if (o1.get(i) == o2.get(i)) {
                        continue;
                    }
                    return o1.get(i) - o2.get(i);
                }
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(results.get(2).get(i));
        }
        return sb.toString();
    }

    private static void helper(int n, List<List<Integer>> results, List<Integer> items) {
        if (items.size() == 3) {
            results.add(new ArrayList<>(items));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (items.contains(i)) {
                continue;
            }
            items.add(i);
            helper(n, results, items);
            items.remove(items.size() - 1);
        }
    }

}
