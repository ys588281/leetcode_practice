package com.vincent.leetcode;

import java.util.LinkedList;
import java.util.List;

public class PrimeFactors {

    public static void main(String[] args) {
        int number = 29;
        List<Integer> results = new LinkedList<>();
        for (int i = 2; i < number; i++) {
            while (number % i == 0) {
                results.add(i);
                number = number / i;
            }
        }
        if (number > 2) {
            results.add(number);
        }

        for (int i : results) {
            System.out.println(i);
        }
    }
}
