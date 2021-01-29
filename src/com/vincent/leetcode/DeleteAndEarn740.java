package com.vincent.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

public class DeleteAndEarn740 {

    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }

    public static int deleteAndEarn(int[] nums) {
        int[] counts = new int[10002];
        for (int num : nums) {
            counts[num] += num;
        }
        int[] dp = new int[10002];
        dp[0] = 0;
        dp[1] = counts[1];
        for (int i = 2; i < 10002; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + counts[i]);
        }
        return dp[10001];
    }
}
