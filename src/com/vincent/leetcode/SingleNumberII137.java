package com.vincent.leetcode;

public class SingleNumberII137 {

    public static void main(String[] args) {

    }

    public static int singleNumberII(int[] nums) {
        int single = 0;
        int BITS = 32;
        for (int i = 0; i < BITS; i++) {
            int bitSum = 0;
            for (int num : nums) {
                bitSum += ((num >>> i) & 1);
            }
            single |= ((bitSum % 3) << i);
        }
        return single;
    }
}
