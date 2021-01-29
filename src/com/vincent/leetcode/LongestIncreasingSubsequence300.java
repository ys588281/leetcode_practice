package com.vincent.leetcode;

public class LongestIncreasingSubsequence300 {

    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequence(new int[]{10,9,2,5,3,7,101,18}));
    }

    public static int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 < 0) {
                dp[i + 1] = 1;
                continue;
            }
            dp[i + 1] = 1;
            for (int j = i; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i + 1] = dp[j + 1] + 1;
                    break;
                }
            }
        }
        int results = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > results) {
                results = dp[i];
            }
        }
        return results;
    }
}
