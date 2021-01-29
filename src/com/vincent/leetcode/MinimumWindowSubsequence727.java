package com.vincent.leetcode;

import java.util.Arrays;

public class MinimumWindowSubsequence727 {

    public static void main(String[] args) {

    }

    public static int minimumWindowSubsequence(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + 1;
                }
            }
        }

        int result = 0;
        for (int n : dp[len1]) {
            result = Math.max(result, n);
        }
        return result;
    }
}
