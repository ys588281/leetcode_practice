package com.vincent.leetcode;

public class RemoveDuplicatesFromSortedArray26 {

    public static void main(String[] args) {
        System.out.println(removeDuplicatesFromSortedArray(new int[]{1,1,2}));
        System.out.println(removeDuplicatesFromSortedArray(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicatesFromSortedArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int left = 0;
        int right = 1;
        for (right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }
}
