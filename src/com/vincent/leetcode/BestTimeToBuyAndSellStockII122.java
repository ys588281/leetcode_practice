package com.vincent.leetcode;

public class BestTimeToBuyAndSellStockII122 {

    public static void main(String[] args) {
        System.out.println(bestTimeToBuyAndSellStock(new int[]{7,1,5,3,6,4}));
        System.out.println(bestTimeToBuyAndSellStock(new int[]{1,2,3,4,5}));
        System.out.println(bestTimeToBuyAndSellStock(new int[]{7,6,4,3,1}));
    }

    public static int bestTimeToBuyAndSellStock(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 0) {
                res = res + (nums[i] - nums[i - 1]);
            }
        }
        return res;
    }


}
