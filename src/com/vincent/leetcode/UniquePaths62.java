package com.vincent.leetcode;

public class UniquePaths62 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }

    public static int uniquePaths(int m, int n) {
        int[][] maze = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    maze[i][j] = 1;
                } else if (j == 0) {
                    maze[i][j] = 1;
                } else {
                    maze[i][j] = maze[i - 1][j] + maze[i][j - 1];
                }
            }
        }
        return maze[m - 1][n - 1];
    }
}
