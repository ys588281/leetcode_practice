package com.vincent.leetcode;

public class HouseRobberII213 {

    public static void main(String[] args) {
        System.out.println(houseRobber(new int[]{2,3,2}));
        System.out.println(houseRobber(new int[]{1,2,3,1}));
    }

    public static int houseRobber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp1 = new int[nums.length + 1];
        dp1[0] = 0;
        dp1[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 1] + dp1[i - 2] > dp1[i - 1]) {
                dp1[i] = nums[i - 1] + dp1[i - 2];
            } else {
                dp1[i] = dp1[i - 1];
            }
        }
        int[] dp2 = new int[nums.length + 1];
        dp2[0] = dp2[1] = 0;
        for (int i = 2; i <= nums.length; i++) {
            if (nums[i - 1] + dp2[i - 2] > dp2[i - 1]) {
                dp2[i] = nums[i - 1] + dp2[i - 2];
            } else {
                dp2[i] = dp2[i - 1];
            }
        }
        return Math.max(dp1[nums.length - 1], dp2[nums.length]);
    }
}
