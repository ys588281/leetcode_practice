package com.vincent.leetcode;

public class FactorialTrailingZeroes172 {

    public static void main(String[] args) {
        System.out.println(factorialTrailingZeroes(5));
        System.out.println(factorialTrailingZeroes(25));
    }

    public static int factorialTrailingZeroes(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int r = i % 5;
            if (r == 0) {
                int temp = i;
                while (temp >= 5) {
                    temp = temp / 5;
                    result++;
                }
            }
        }
        return result;
    }
}
