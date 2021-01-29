package com.vincent.leetcode;

public class PeakIndexInAMountainArray852 {
    public static void main(String[] args) {
        System.out.println(peakIndexInAMountainArray(new int[]{0, 1, 0}));
        System.out.println(peakIndexInAMountainArray(new int[]{0, 2, 1, 0}));

        System.out.println(peakIndexInAMountainArray2(new int[]{0, 1, 0}));
        System.out.println(peakIndexInAMountainArray2(new int[]{0, 2, 1, 0}));
    }

    public static int peakIndexInAMountainArray(int[] A) {
        int peek = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                peek = i;
            }
            if (A[i] < A[i - 1]) {
                break;
            }
        }
        return peek;
    }

    public static int peakIndexInAMountainArray2(int[] A) {
        int left = 0, right = A.length - 1;
        int peek = 0;
        while (peek <= right) {
            peek = (left + right) / 2;
            if (A[peek - 1] > A[peek]) {
                right = peek - 1;
            } else if (A[peek + 1] > A[peek]) {
                left = peek + 1;
            } else {
                break;
            }
        }
        return peek;
    }
}
