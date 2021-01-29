package com.vincent.practice;

public class CyclicSort {
    public static void main(String[] args) {

    }

    public static void cyclicSort(int[] nums) {
        int i = 0, n = nums.length;
        while (i < n) {
            int j = nums[i];
            if (j < n && nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
