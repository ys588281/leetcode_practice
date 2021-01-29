package com.vincent.leetcode;

public class MaximumSubarray53 {

    public static void main(String[] args) {
        System.out.println(maximumSubarray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maximumSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            current = current + nums[i];
            if (current < nums[i]) {
                current = nums[i];
            }
            if (current > max) {
                max = current;
            }
        }
        return max;
    }
}
