package com.vincent.leetcode;

public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeros(nums);
        nums = new int[]{1,0,0,3,12};
        moveZeros(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    public static void moveZeros(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return;
        int lastNonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, lastNonZero, i);
                lastNonZero++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
