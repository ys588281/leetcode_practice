package com.vincent.leetcode;


public class LongestCommonSubsequence1143 {

    public static void main(String[] args) {

    }

    public static int longestCommonSubsequence(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return 0;
        }
        int[][] match = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    match[i][j] = match[i - 1][j - 1] + 1;
                } else {
                    match[i][j] = Math.max(match[i - 1][j], match[i][j - 1]);
                }
            }
        }

        return match[s.length()][t.length()];
    }
}
