package com.vincent.leetcode;

public class SortColors75 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    // 三指針
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        int idx = 0, left = 0, right = nums.length - 1;
        while (idx < right) {
            if (nums[idx] == 0) {
                swap(nums, idx, left);
                idx++;
                left++;
            }
            else if (nums[idx] == 1) {
                idx++;
            }
            else  {
                swap(nums, idx, right);
                idx++;
                right--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
