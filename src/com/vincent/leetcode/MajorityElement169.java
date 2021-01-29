package com.vincent.leetcode;

import java.util.Arrays;

public class MajorityElement169 {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));

        System.out.println(majorityElement2(new int[]{3,2,3}));
        System.out.println(majorityElement2(new int[]{2,2,1,1,1,2,2}));
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int majorityElement2(int[] nums) {
        int res = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
                count = 1;
            } else if (res == num) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }
}
