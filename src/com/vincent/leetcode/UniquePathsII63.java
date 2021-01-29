package com.vincent.leetcode;

public class UniquePathsII63 {

    public static void main(String[] args) {
        int[][] grids = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePaths(grids));
    }

    public static int uniquePaths(int[][] grids) {
        if (grids.length == 0) {
            return 0;
        }
        int[][] maze = new int[grids.length][grids[0].length];
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++ ) {
                if (grids[i][j] == 1) {
                    maze[i][j] = 0;
                } else if (i == 0) {
                    maze[i][j] = 1;
                } else if (j == 0) {
                    maze[i][j] = 1;
                } else {
                    maze[i][j] = maze[i - 1][j] + maze[i][j - 1];
                }
            }
        }
        return maze[grids.length - 1][grids[0].length - 1];
    }
}
