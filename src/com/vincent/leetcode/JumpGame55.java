package com.vincent.leetcode;

public class JumpGame55 {

    public static void main(String[] args) {
        System.out.println(jumpGame(new int[]{2,3,1,1,4}));
        System.out.println(jumpGame(new int[]{3,2,1,0,4}));
    }

    public static boolean jumpGame(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = false;
        }
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= nums[i]; j++) {
                if (i + j < nums.length && dp[i] == true) {
                    dp[i + j] = true;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
