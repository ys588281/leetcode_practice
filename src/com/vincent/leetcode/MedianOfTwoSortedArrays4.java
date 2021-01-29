package com.vincent.leetcode;

public class MedianOfTwoSortedArrays4 {

    public static void main(String[] args) {
        System.out.println(medianOfTwoSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(medianOfTwoSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public static double medianOfTwoSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];
        int idx = 0, idx1 = 0, idx2 = 0;
        while (idx1 < nums1.length || idx2 < nums2.length) {
            int num1 = (idx1 < nums1.length) ? nums1[idx1] : Integer.MAX_VALUE;
            int num2 = (idx2 < nums2.length) ? nums2[idx2] : Integer.MAX_VALUE;
            if (num1 < num2) {
                nums3[idx] = num1;
                idx1++;
            } else {
                nums3[idx] = num2;
                idx2++;
            }
            idx++;
        }
        int totalLength = nums1.length + nums2.length;
        boolean isEven = totalLength % 2 == 0;
        if (isEven) {
            return (Double.valueOf(nums3[totalLength/2]) + Double.valueOf(nums3[totalLength/2 - 1]))/2;
        } else {
            return nums3[totalLength/2];
        }
    }
}
