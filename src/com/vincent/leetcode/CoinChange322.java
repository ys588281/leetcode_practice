package com.vincent.leetcode;

public class CoinChange322 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            dp[coins[i]] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if (i - coin < 0) {
                    continue;
                }
                if (dp[i - coin] == -1) {
                    continue;
                }
                if (dp[i] == -1) {
                    dp[i] = dp[i - coin] + 1;
                } else {
                    dp[i] = ((dp[i - coin] + 1 < dp[i]) ? dp[i - coin] + 1 : dp[i]);
                }
            }
        }
        return dp[amount];
    }

}
