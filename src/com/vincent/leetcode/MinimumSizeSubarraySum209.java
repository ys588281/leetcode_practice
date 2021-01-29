package com.vincent.leetcode;

import javax.swing.plaf.FileChooserUI;

public class MinimumSizeSubarraySum209 {

    public static void main(String[] args) {
        System.out.println(minimumSizeSubarraySum(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public static int minimumSizeSubarraySum(int min, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 && nums[0] >= min) {
            return 1;
        }

        int res = Integer.MAX_VALUE;
        int start = 0;
        int current = 0;
        for (int end = 0; end < nums.length; end++) {
            current += nums[end];
            if (current >= min) {
                res = Math.min(res, end - start + 1);
            }
            while (current >= min) {
                res = Math.min(res, end - start + 1);
                current -= nums[start];
                start++;
            }
        }
        return res;
    }
}
