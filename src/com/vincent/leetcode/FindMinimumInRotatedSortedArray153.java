package com.vincent.leetcode;

public class FindMinimumInRotatedSortedArray153 {
    public static void main(String[] args) {
        System.out.println(findMinimumInRotatedSortedArray(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findMinimumInRotatedSortedArray2(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    public static int findMinimumInRotatedSortedArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static int helper(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        if (right - left == 1) return Math.min(nums[left], nums[right]);

        if (nums[right] > nums[left]) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;

        if (nums[mid] <= nums[left]) {
            return helper(nums, left, mid);
        } else {
            return helper(nums, mid, right);
        }
    }

    public static int findMinimumInRotatedSortedArray2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        while (left <= right) {
            if (left == right) return nums[left];
            if (right - left == 1) return Math.min(nums[left], nums[right]);
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[left]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return -1;
    }
}
