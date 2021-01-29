package com.vincent.leetcode;

public class MaxAreaOfIsland695 {

    public static void main() {

    }

    public static int maxAreaOfIsland(char[][] grids) {
        if (grids == null && grids.length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                int area = helper(grids, i, j);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    private static int helper(char[][] grids, int i, int j) {
        if (grids[i][j] == '0') {
            return 0;
        }
        int area = 1;
        grids[i][j] = '0';
        if (i > 0) area += helper(grids, i - 1, j);
        if (j > 0) area += helper(grids, i, j - 1);
        if (i < grids.length - 1) area += helper(grids, i + 1, j);
        if (j < grids[0].length - 1) area += helper(grids, i, j + 1);
        return area;
    }
}
