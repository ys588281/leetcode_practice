package com.vincent.leetcode;

import java.util.Arrays;

public class LongestArithmeticSubsequenceOfGivenDifference1218 {

    public static void main(String[] args) {
        System.out.println(longestArithmeticSubsequenceOfGivenDifference(new int[]{1,2,3,4}, 1));
        System.out.println(longestArithmeticSubsequenceOfGivenDifference(new int[]{1,3,5,7}, 1));
        System.out.println(longestArithmeticSubsequenceOfGivenDifference(new int[]{1,5,7,8,5,3,4,2,1}, -2));
    }

    public static int longestArithmeticSubsequenceOfGivenDifference(int[] nums, int difference) {
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min,num);
        }
        Arrays.sort(nums);
        int[] dp = new int[max + 1];
        for (int num : nums) {
            dp[num] = 1;
        }
        if (difference > 0) {
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] == 0) continue;
                if (i + difference < dp.length && dp[i + difference] != 0) {
                    dp[i + difference] = dp[i] + 1;
                }
            }
            return dp[max] == 1 ? 0 : dp[max];
        }
        if (difference < 0) {
            for (int i = dp.length - 1; i >= 0; i--) {
                if (dp[i] == 0) continue;
                if (i + difference >= 0 && dp[i + difference] != 0) {
                    dp[i + difference] = dp[i] + 1;
                }
            }
            return dp[min];
        }
        return 0;
    }
}
