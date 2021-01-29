package com.vincent.leetcode;

public class FindPivotIndex724 {

    public static void main(String[] args) {
        System.out.println(FindPivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(FindPivotIndex(new int[]{1}));
        System.out.println(FindPivotIndex(new int[]{}));
    }

    public static int FindPivotIndex(int[] input) {
        if (input.length == 1) {
            return 0;
        }
        if (input.length == 0 || input.length == 2) {
            return -1;
        }
        int total = 0;
        for (int i = 0; i < input.length; i++) {
            total += input[i];
        }
        int letfTotal = 0;
        for (int i = 1; i < input.length; i++) {
            letfTotal += input[i - 1];
            if (letfTotal == (total - letfTotal - input[i])) {
                return i;
            }
        }
        return -1;
    }
}
