package com.vincent.leetcode;

public class NThTribonacciNumber1137 {
    public static void main(String[] args) {
        System.out.println(nThTribonacciNumber(4));
        System.out.println(nThTribonacciNumber(25));
    }

    public static int nThTribonacciNumber(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int t0 = 0, t1 = 1, t2 = 1;
        int result = t0 + t1 + t2;
        for (int i = 3; i <= n; i++) {
            result = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = result;
        }
        return result;
    }
}
