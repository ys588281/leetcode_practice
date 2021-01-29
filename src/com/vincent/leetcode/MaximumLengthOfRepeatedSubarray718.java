package com.vincent.leetcode;

public class MaximumLengthOfRepeatedSubarray718 {

    public static void main(String[] args) {
        System.out.println(maximumLengthOfRepeatedSubarray(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
    }

    public static int maximumLengthOfRepeatedSubarray(int[] nums1, int[] nums2) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    int count = 1;
                    while (j + count < nums2.length && i + count < nums1.length) {
                        if (nums1[i + count] == nums2[j + count]) {
                            count++;
                            continue;
                        }
                        break;
                    }
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }
}
