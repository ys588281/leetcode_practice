package com.vincent.leetcode;

import java.util.Arrays;

public class GreatestSumDivisibleByThree1262 {

    public static void main(String[] args) {
//        System.out.println(greatestSumDivisibleByThree(new int[]{4}));
        System.out.println(greatestSumDivisibleByThree(new int[]{3,6,5,1,8}));
//        System.out.println(greatestSumDivisibleByThree(new int[]{1,2,3,4,4}));
    }

    public static int greatestSumDivisibleByThree(int[] nums) {
        int[][] dp = new int[nums.length][3];
        dp[0][nums[0]%3] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < 3; j++) {
                int num = dp[i - 1][j] + nums[i];
                int mod = num % 3;
                dp[i][mod] = Math.max(dp[i][mod], num);
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i][0]);
        }
        return dp[nums.length - 1][0];
        //dp[i][j]代表到第i位数字（num[i-1]）模3的余数为j的最大累加和
        //i=0时的初始值为{0,-INT,-INT}，若第1位数字num是3的倍数，则dp={num,-INT,-INT}；若不是，则dp={0,num,-INT}/{0,-INT,num}
//        int[][] dp = new int[nums.length + 1][3];
//        for(int[] list : dp){
//            Arrays.fill(list, Integer.MIN_VALUE);
//        }
//        dp[0][0] = 0;
//
//        for(int i = 1; i <= nums.length; i++){
            //利用第i位数字（num[i-1]），计算与上一轮累加和的新模值newmod=(oldmod+num[i-1])%3
            //最新累加和可以通过01背包思路建立动态转移方程
            //dp[i][newmod] = Math.max(dp[i-1][newmod], dp[i-1][oldmod] + nums[i-1]);
//            for(int j = 0; j < 3; j++){
////                int mod = (j + nums[i - 1]) % 3;
////                dp[i][mod] = Math.max(dp[i - 1][mod], dp[i - 1][j] + nums[i - 1]);
////            }
////        }
////        return dp[nums.length][0];
    }
}
