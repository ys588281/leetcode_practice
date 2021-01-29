package com.vincent.leetcode;

public class NondecreasingArray665 {

    public static void main(String[] args) {
        System.out.println(nondecreasingArray(new int[]{4,2,3}));
        System.out.println(nondecreasingArray(new int[]{4,2,1}));
    }

    public static boolean nondecreasingArray(int[] nums) {
        boolean isModify = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                continue;
            }
            if (isModify) {
                return false;
            }
            isModify = true;
        }
        return true;
    }
}
