package com.vincent.leetcode;

import java.util.Arrays;

public class Matrix542 {
    public static void main(String[] args) {

    }

    public static int[][] matrix(int[][] nums) {
        int[][] dp = new int[nums.length][nums[0].length];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    if (nums[i][j] == 0) {
                        dp[i][j] = 0;
                        continue;
                    }
                }
                if (i == 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    continue;
                }
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums[0].length - 1; j >= 0; j--) {
                if (nums[i][j] == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == nums.length - 1 && j == nums[0].length - 1) {
                    if (nums[i][j] == 0) {
                        dp[i][j] = 0;
                        continue;
                    }
                    dp[i][j] = 0;
                }
                if (i == nums.length - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                    continue;
                }
                if (j == nums[0].length - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    continue;
                }
                if (i < nums.length - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j < nums[0].length - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }
}
