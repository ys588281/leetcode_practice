package com.vincent.leetcode;

import java.util.Stack;

public class BasicCalculator224 {

    public static void main(String[] args) {
        System.out.println(basicCalculator("1 + 1"));
        System.out.println(basicCalculator(" 2-1 + 2 "));
        System.out.println(basicCalculator("(1+(4+5+2)-3)+(6+8)"));
    }

    public static int basicCalculator(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char[] chars = input.toCharArray();


        int result = 0;
        int num = 0;
        int sign = 1;
        stack.push(sign);

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                continue;
            }
            if (chars[i] >= '0' && chars[i] <= '9') {
                num = num * 10 + (chars[i] - '0');
            }
            if (chars[i] == '+' || chars[i] == '-') {
                result += sign * num;
                num = 0;
                sign = stack.peek() * ((chars[i] == '+' ) ? 1 : -1);
            }
            if (chars[i] == '(') {
                stack.push(sign);
            }
            if (chars[i] == ')') {
                stack.pop();
            }
        }
        result += sign * num;
        return result;
    }
}
