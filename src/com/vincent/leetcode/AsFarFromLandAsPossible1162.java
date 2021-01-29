package com.vincent.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible1162 {

    public static void main(String[] args) {

    }

    public static int asFarFromLandAsPossible(int[][] grids) {
        if (grids == null || grids.length == 0) return 0;
        boolean[][] visisted = new boolean[grids.length][grids[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] == 1) {
                    visisted[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = new int[][]{
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        int result = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                int[] point = queue.poll();
                int curX = point[0];
                int curY = point[1];
                result = Math.max(result, grids[curX][curY] - 1);
                for (int[] direction : directions) {
                    int x = curX + direction[0];
                    int y = curY + direction[1];
                    if (x >= 0 && x < grids.length && y >= 0 && y < grids[0].length && visisted[x][y] == false) {
                        visisted[x][y] = true;
                        grids[x][y] = grids[curX][curY] + 1;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }

        return result == -1 ? 0 : result;

    }
}
