package com.vincent.leetcode;

public class FloodFill733 {

    public static void main(String[] args) {

    }

    public static int[][] floodFill(int[][] images, int sr, int sc, int newColor) {
        int oldColor = images[sr][sc];
        dfs(images, sr, sc, oldColor, newColor);
        return images;
    }

    private static void dfs(int[][] images, int i, int j, int oldColor, int newColor) {
        if (i < 0 || j < 0 || i >= images.length || j >= images[0].length) return;
        if (images[i][j] != oldColor) return;

        images[i][j] = newColor;

        if (i > 0) dfs(images, i - 1, j, oldColor, newColor);
        if (i < images.length - 1) dfs(images, i + 1, j, oldColor, newColor);
        if (j > 0) dfs(images, i, j - 1, oldColor, newColor);
        if (j < images[0].length - 1) dfs(images, i, j + 1, oldColor, newColor);

    }
}
