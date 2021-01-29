package com.vincent.leetcode;

public class MinCostClimbingStairs746 {

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public static int minCostClimbingStairs(int[] costs) {
        if (costs.length == 2) {
            return (costs[0] > costs[1])?costs[1]:costs[0];
        }
        int[] dp = new int[costs.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 2] + costs[i - 2], dp[i - 1] + costs[i - 1]);
        }
        return dp[costs.length];
    }
}
