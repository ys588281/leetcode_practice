package com.vincent.leetcode;

public class DeleteOperationForTwoStrings583 {

    public static void main(String[] args) {
        System.out.println(deleteOperationForTwoStrings("sea", "eat"));
    }

    public static int deleteOperationForTwoStrings(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return -1;
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return s.length() + t.length() - 2 * dp[s.length()][t.length()];
    }
}
