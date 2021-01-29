package com.vincent.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray679 {

    public static void main(String[] args) {

    }

    public static int degreeOfAnArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!frequency.containsKey(nums[i])) {
                frequency.put(nums[i], 1);
            } else {
                frequency.put(nums[i], frequency.get(nums[i]) + 1);
            }
        }
        int degree = 0;
        for (Integer value : frequency.values()) {
            if (value > degree) {
                degree = value;
            }
        }

        int res = 0;
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {

            }
        }
        return res;
    }
}
