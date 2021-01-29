package com.vincent.leetcode;

public class SingleNumber136 {

    public static void main(String[] args) {

    }

    public static int singleNumber(int[] inputs) {
        int res = 0;
        for (int i = 0; i < inputs.length; i++) {
            res = res ^ inputs[i];
        }
        return res;
    }
}
