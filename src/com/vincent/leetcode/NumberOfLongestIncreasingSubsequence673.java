package com.vincent.leetcode;

public class NumberOfLongestIncreasingSubsequence673 {

    public static void main(String[] args) {

    }

    public static int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        int[] counts = new int[nums.length];
        dp[0] = 1;
        counts[0] = 1;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        counts[i] = counts[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        counts[i] += counts[j];
                    }
                }
                if (dp[i] == 0) {
                    dp[i] = 1;
                    counts[i] = 1;
                }
                max = Math.max(max, dp[i]);
            }
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == max) {
                result += counts[i];
            }
        }
        return result;
    }
}
