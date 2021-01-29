package com.vincent.leetcode;

import java.util.Stack;

public class MaximalRectangle85 {

    public static void main(String[] args) {

    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] heights = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    heights[i][j] = 0;
                } else {
                    if (i == 0) {
                        heights[i][j] = 1;
                    } else {
                        heights[i][j] = heights[i - 1][j] + 1;
                    }
                }
            }
        }
        int results = Integer.MIN_VALUE;
        for (int[] height : heights) {
            results = Math.max(results, getMax(height));
        }
        return results;
    }

    private static int getMax(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= heights.length; i++) {
            int currentHeight = (i == heights.length) ? -1 : heights[i];
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int peekHeight = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(peekHeight * width, max);
            }
            stack.push(i);
        }
        return max;
    }
}
