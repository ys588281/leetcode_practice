package com.vincent.leetcode;

import java.util.Arrays;

public class ValidTriangleNumber611 {

    public static void main(String[] args) {

    }

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                result += k - j - 1;
            }
        }
        return result;
    }
}
