package com.vincent.leetcode;

import java.util.Arrays;

public class ThreeSumClosest16 {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            res = helper(nums, left, right, nums[i], target, res);
            if (res == target) {
                break;
            }
        }
        return res;
    }

    private static int helper(int[] nums, int left, int right, int current, int target, int res) {
        int newRes = res;
        while (left < right) {
            int tempSum = nums[left] + nums[right] + current;
            if (tempSum == target) {
                return target;
            } else {
                if (Math.abs(tempSum - target) < newRes) {
                    newRes = Math.abs(tempSum - target);
                }
                if (tempSum < target) {
                    left++;
                }
                if (tempSum > target) {
                    right--;
                }
            }
        }
        return newRes;
    }
}
