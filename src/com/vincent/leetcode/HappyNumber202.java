package com.vincent.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber202 {

    public static void main(String[] args) {
        System.out.println(happyNumber(19));
        System.out.println(happyNumber(4));
    }

    public static boolean happyNumber(int input) {
        Set<Integer> set = new HashSet<>();
        int sum = input;
        while (sum != 1) {
            if (set.contains(sum)) return false;
            set.add(sum);
            sum = getSquareDigits(sum);
        }
        return true;
    }

    private static int getSquareDigits(int input) {
        int sum = 0;
        while (input > 0) {
            int rest = input % 10;
            sum += rest * rest;
            input = input / 10;
        }
        return sum;
    }


}
