package com.vincent.leetcode;

public class SearchInsertPosition35 {

    public static void main(String[] args) {
        System.out.println(searchInsertPosition(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsertPosition(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsertPosition(new int[]{1,3,5,6}, 7));
        System.out.println(searchInsertPosition(new int[]{1,3,5,6}, 0));
    }

    public static int searchInsertPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
}
