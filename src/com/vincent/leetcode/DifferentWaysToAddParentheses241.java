package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses241 {

    public static void main(String[] args) {
        List<Integer> results = differentWaysToAddParentheses("2-1-1");
//        for (Integer r : results) {
//            System.out.println(r);
//        }
//        results = differentWaysToAddParentheses("2*3-4*5");
//        for (Integer r : results) {
//            System.out.println(r);
//        }
    }

    public static List<Integer> differentWaysToAddParentheses(String input) {
        System.out.println(input);
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = differentWaysToAddParentheses(input.substring(0, i));
                List<Integer> right = differentWaysToAddParentheses(input.substring(i + 1));
                for (Integer l : left) {
                    for (Integer r : right) {
                        switch (c) {
                            case '+': {
                                results.add(l + r);
                                break;
                            }
                            case '-': {
                                results.add(l - r);
                                break;
                            }
                            case '*': {
                                results.add(l * r);
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (results.size() == 0) results.add(Integer.valueOf(input));
        return results;
    }
}
