package com.vincent.leetcode;

public class MaximumProductSubarray152 {

    public static void main(String[] args) {
        System.out.println(maximumProductSubarray(new int[]{2,3,-2,4}));
    }

    public static int maximumProductSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int res = Integer.MIN_VALUE;
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]);
            min[i] = Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]);
            res = Math.max(max[i], res);
        }
        return res;
    }
}
