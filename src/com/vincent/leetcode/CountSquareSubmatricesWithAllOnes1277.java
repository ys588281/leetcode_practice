package com.vincent.leetcode;

public class CountSquareSubmatricesWithAllOnes1277 {
    public static void main(String[] args) {
        int result = countSquareSubmatricesWithAllOnes(new int[][]{
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        });
        System.out.println(result);
    }

    public static int countSquareSubmatricesWithAllOnes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i][j] = matrix[i][j];
                if (dp[i][j] == 0) {
                    continue;
                }
                if (i >= 1 && j >= 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                result += dp[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return result;
    }
}
