package com.vincent.leetcode;

public class TargetSum494 {

    public static void main(String[] args) {

    }

    public static int targetSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        return helper(nums, 0, target);
    }

    private static int helper(int[] nums, int pos, int target) {
        if (pos == nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        return helper(nums, pos + 1, target - nums[pos]) + helper(nums, pos + 1, target + nums[pos]);
    }
}
