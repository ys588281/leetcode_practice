package com.vincent.leetcode;

import java.util.EnumSet;

public class SquaresOfASortedArray977 {

    public static void main(String[] args) {
        int[] res = squaresOfASortedArray(new int[]{-4,-1,0,3,10});
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ", ");
        }
        System.out.println();
        res = squaresOfASortedArray(new int[]{-7,-3,2,3,11});
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ", ");
        }
    }

    public static int[] squaresOfASortedArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new int[]{nums[0] * nums[0]};
        }
        int left = nums.length / 2;
        int right = (nums.length / 2) + 1;
        int[] res = new int[nums.length];
        int i = 0;
        while (left >= 0 || right <= nums.length - 1) {
            if (i == nums.length) {
                break;
            }
            int leftValue = (left < 0) ? Integer.MAX_VALUE : (nums[left] * nums[left]);
            int rightValue = (right >= nums.length) ? Integer.MAX_VALUE : (nums[right] * nums[right]);
            if (leftValue <= rightValue) {
                res[i] = leftValue;
                left--;
            } else {
                res[i] = rightValue;
                right++;
            }
            i++;
        }
        return res;
    }
}
