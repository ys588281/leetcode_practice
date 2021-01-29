package com.vincent.leetcode;

public class MergeSortedArray88 {
    public static void main(String[] args) {

    }

    public static void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        while (m > 0 || n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            } else {
                nums1[m + n - 1] = nums1[n - 1];
                n--;
            }
        }
        while (n > 0) {
            nums1[m + n - 1] = nums1[n - 1];
            n--;
        }
        while (m > 0) {
            nums1[m + n - 1] = nums1[m - 1];
            m--;
        }
    }
}
