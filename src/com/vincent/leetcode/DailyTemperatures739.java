package com.vincent.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DailyTemperatures739 {

    public static void main(String[] args) {
        int[] results = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }

    public static int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return T;
        }
        if (T.length == 1) {
            return new int[]{0};
        }

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> records = new HashMap<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int temp = stack.pop();
                records.put(temp, i - temp);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            records.put(temp, 0);
        }

        int[] results = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            results[i] = records.get(i);
        }
        return results;
    }
}
