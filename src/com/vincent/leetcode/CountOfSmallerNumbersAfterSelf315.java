package com.vincent.leetcode;

public class CountOfSmallerNumbersAfterSelf315 {
    public static void main(String[] args) {
        int[] results = countOfSmallerNumbersAfterSelf(new int[]{5,2,6,1});
        for (int res : results) {
            System.out.println(res);
        }
    }

    public static int[] countOfSmallerNumbersAfterSelf(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int[] results = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                results[i] = 0;
                continue;
            }
            if (nums[i] > nums[i + 1]) {
                results[i] = results[i + 1] + 1;
                continue;
            }
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count = count + 1;
                }
            }
            results[i] = count;
        }
        return results;
    }
}
