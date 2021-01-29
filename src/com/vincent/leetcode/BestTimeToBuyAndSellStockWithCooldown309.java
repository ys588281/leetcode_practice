package com.vincent.leetcode;

public class BestTimeToBuyAndSellStockWithCooldown309 {

    public static void main(String[] args) {
        System.out.println(bestTimeToBuyAndSellStockWithCooldown(new int[]{1,2,3,0,2}));
    }

    public static int bestTimeToBuyAndSellStockWithCooldown(int[] nums) {
        int[] holds = new int[nums.length + 1];
        int[] solds = new int[nums.length + 1];
        int[] rests = new int[nums.length + 1];
        holds[0] = -nums[0];
        rests[0] = 0;
        solds[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            holds[i] = Math.max(holds[i - 1], rests[i - 1] - nums[i - 1]);
            solds[i] = holds[i - 1] + nums[i - 1];
            rests[i] = Math.max(rests[i - 1], solds[i - 1]);
        }
        return Math.max(rests[nums.length], solds[nums.length]);
    }
}
