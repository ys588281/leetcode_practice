package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
    public static void main(String[] args) {
        List<String> results = generateParentheses(3);
        for (String result : results) {
            System.out.println(result);
        }
    }

    public static List<String> generateParentheses(int n) {
        if (n <= 0) {
            return null;
        }
        List<String> results = new ArrayList<>();
        String item  = "";
        dfs(results, item, n, n);
        return results;
    }

    private static void dfs(List<String> results, String item, int left, int right) {
        System.out.println(item + "  " + left + "  " + right);
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            results.add(new String(item));
            return;
        }
        if (left > 0) {
            dfs(results, item+"(", left - 1, right);
        }
        if (right > 0) {
            dfs(results, item+")", left, right - 1);
        }
    }
}
