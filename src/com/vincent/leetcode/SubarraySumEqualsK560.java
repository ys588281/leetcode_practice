package com.vincent.leetcode;

public class SubarraySumEqualsK560 {
    public static void main(String[] args) {
        int[] input = new int[]{1,1,1};
        System.out.println(SubarraySumEqualsK(input, 2));
        System.out.println(SubarraySumEqualsK2(input, 2));
    }

    public static int SubarraySumEqualsK(int[] nums, int k) {
        int result = 0;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum[i] == k) {
                result++;
            }
            for (int j = 0; j < i; j++) {
                if (sum[i] - sum[j] == k) {
                    result++;
                }
            }
        }
        return result;
    }

    public static int SubarraySumEqualsK2(int[] input, int kk) {
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            int prefixSum = 0;
            for (int j = i; j < input.length; j++) {
                prefixSum += input[j];
                if (prefixSum == kk) {
                    count++;
                }
            }
        }
        return count;
    }
}
