package com.vincent.leetcode;

import java.util.Arrays;

public class ThreeSumSmaller {

    public static void main(String[] args) {
        System.out.println(threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));
    }

    public static int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            res = res + helper(nums, left, right, nums[i], target);
        }
        return res;
    }

    private static int helper(int[] nums, int left, int right, int current, int target) {
        int res = 0;
        while (left < right) {
            int tempSum = nums[left] + nums[right] + current;
            if (tempSum < target) {
                res = res + right - left;// important point
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                left++;
            }
            if (tempSum >= target) {
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
                right--;
            }
        }
        return res;
    }
}
