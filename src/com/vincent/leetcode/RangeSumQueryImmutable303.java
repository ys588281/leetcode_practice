package com.vincent.leetcode;

public class RangeSumQueryImmutable303 {

    public static void main(String[] args) {

    }
}
class NumArray {

    private int[] nums;
    private int[] dp;

    public NumArray(int[] nums) {
        this.nums = nums;
        dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return dp[j];
        return dp[j] - dp[i - 1];
    }
}
