package com.vincent.leetcode;

public class CoinChangeII518 {

    public static void main(String[] args) {
        System.out.println(coinChange(5, new int[]{1, 2, 5}));
        System.out.println(coinChange(2, new int[]{3}));
        System.out.println(coinChange(10, new int[]{10}));
    }

    public static int coinChange(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = 0; j <= amount; j++) {
                if (j + coin <= amount) {
                    dp[j + coin] = dp[j + coin] + dp[j];
                }
            }
        }
        return dp[amount];
    }
}
