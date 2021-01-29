package com.vincent.leetcode;

public class BestTimeToBuyAndSellStock121 {

    public static void main(String[] args) {
        System.out.println(bestTimeToBuyAndSellStock(new int[]{7,1,5,3,6,4}));
    }

    public static int bestTimeToBuyAndSellStock(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int res = 0;
        int lowest = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
            }
            if (prices[i] - lowest > res) {
                res = prices[i] - lowest;
            }
        }
        return res;
    }
}
