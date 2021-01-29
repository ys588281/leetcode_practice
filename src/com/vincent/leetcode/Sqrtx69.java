package com.vincent.leetcode;

public class Sqrtx69 {

    public static void main(String[] args) {
        System.out.println(sqrtx(8));
        System.out.println(sqrtx(4));
    }

    public static int sqrtx(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int left = 1;
        int right = x;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (middle * middle == x) return middle;
            if (middle * middle > x) {
                right = middle - 1; // important. It is different from other binary search
            } else {
                left = middle + 1; // important. It is different from other binary search
            }
        }
        return right;
    }
}
