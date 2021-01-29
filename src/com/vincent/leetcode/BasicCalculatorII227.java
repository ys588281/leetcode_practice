package com.vincent.leetcode;

import java.util.Stack;

public class BasicCalculatorII227 {
    public static void main(String[] args) {

    }

    public static int basicCalculatorII(String s) {
        if (s == null || s.length() == 0) return 0;

        int result = 0;
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            }
            if ((c != ' ' && (c < '0' || c > '9')) || i == chars.length - 1) {
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '*') {
                    result = result - stack.peek();
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    result = result - stack.peek();
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
                result += stack.peek();
            }
        }
        return result;
    }
}
