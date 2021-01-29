package com.vincent.leetcode;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray581 {

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }

    public static int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i];
        }
        Arrays.sort(nums2);
        int start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums2[i]) {
                start = i;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != nums2[i]) {
                end = i;
            }
        }
        return start - end + 1;
    }

    public static int findUnsortedSubarray2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int start = -1;
        int end = -1;
        int max = nums[0];
        int min = nums[nums.length - 1];
        for (int i = 1; i < nums.length - 1; i++) {
            max = (nums[i] > max) ? nums[i] : max;
            min = (nums[nums.length - i - 1] < min) ? nums[nums.length - i - 1] : min;
            if (nums[i] < max) {
                start = i - 1;
            }

            if (nums[i] > min) {
                end = i;
            }
        }
        return start - end;
    }
}
