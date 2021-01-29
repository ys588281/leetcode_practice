package com.vincent.leetcode;

public class MinimumASCIIDeleteSumForTwoStrings712 {

    public static void main(String[] args) {
        System.out.println(minimumASCIIDeleteSumForTwoStrings("sea", "eat"));
        System.out.println(minimumASCIIDeleteSumForTwoStrings("delete", "leet"));
    }

    public static int minimumASCIIDeleteSumForTwoStrings(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = dp[i - 1][0] + s.charAt(i - 1);
        }
        for (int j = 1; j <= t.length(); j++) {
            dp[0][j] = dp[0][j - 1] + t.charAt(j - 1);
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s.charAt(i - 1), dp[i][j - 1] + t.charAt(j - 1));
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
