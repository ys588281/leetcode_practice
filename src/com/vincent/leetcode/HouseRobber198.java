package com.vincent.leetcode;

public class HouseRobber198 {

    public static void main(String[] args) {
        System.out.println(houseRobber(new int[]{1,2,3,1}));
        System.out.println(houseRobber(new int[]{2,7,9,3,1}));
    }

    public static int houseRobber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            if (nums[i - 1] + dp[i - 2] > dp[i - 1]) {
                dp[i] = nums[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[nums.length];
    }
}
