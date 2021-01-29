package com.vincent.leetcode;

import java.util.Random;

public class RandomPickWithWeight528 {

    public static void main(String[] args) {

    }
}

class RandomPickWithWeight{
    private int[] accum;
    private int total;
    private Random rand;
    public RandomPickWithWeight(int[] w) {
        this.rand = new Random();
        this.total = 0;
        this.accum = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            accum[i] = total;
        }
    }

    // search insertion index
    public int pickIndex() {
        int r = rand.nextInt(total) + 1;
        int left = 0, right = accum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (accum[mid] == r) {
                return mid;
            } else if (accum[mid] < r) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
