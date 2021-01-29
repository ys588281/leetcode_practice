package com.vincent.leetcode;

public class NumberOfIslands200 {

    public static void main(String[] args) {
        char[][] grids = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numberOfIslands(grids));
        grids = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };
        System.out.println(numberOfIslands(grids));
    }

    public static int numberOfIslands(char[][] grids) {
        if (grids == null || grids.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (grids[i][j] == '1') {
                    helper(grids, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private static void helper(char[][] grids, int i, int j) {
        grids[i][j] = '0';
        if (i - 1 >= 0 && grids[i - 1][j] == '1') helper(grids, i - 1, j);
        if (i + 1 < grids.length && grids[i + 1][j] == '1') helper(grids, i + 1, j);
        if (j + 1 < grids[0].length && grids[i][j + 1] == '1') helper(grids, i, j + 1);
        if (j - 1 >= 0 && grids[i][j - 1] == '1') helper(grids, i, j - 1);
    }
}
