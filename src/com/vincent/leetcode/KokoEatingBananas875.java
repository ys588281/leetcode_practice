package com.vincent.leetcode;

public class KokoEatingBananas875 {

    public static void main(String[] args) {
        System.out.println(kokoEatingBananas(new int[]{3,6,7,11}, 8));
        System.out.println(kokoEatingBananas(new int[]{30,11,23,4,20}, 5));
        System.out.println(kokoEatingBananas(new int[]{30,11,23,4,20}, 6));
    }

    public static int kokoEatingBananas(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            if (pile > right) right = pile;
        }

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (helper(piles, middle) > h) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }

    private static int helper(int[] piles, int k) {
        int sum = 0;
        for (int pile : piles) {
            sum = sum + (pile / k) + 1;
        }
        return sum;
    }


}