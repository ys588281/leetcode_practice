package com.vincent.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TheMazeII505 {

    public static void main(String[] args) {

    }

    public int theMazeII(int[][] maze, int[] start, int[] dest) {
        int[][] dirs = new int[][]{
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        int row = maze.length;
        int col = maze[0].length;

        int[][] distances = new int[row][col];
        for (int[] distance : distances) {
            Arrays.fill(distance, Integer.MAX_VALUE);
        }
        distances[start[0]][start[1]] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            for (int[] dir : dirs) {
                int x = position[0];
                int y = position[1];

                int count = 0;
                while (x >= 0 && y >= 0 && x < row && y < col) {
                    x = x + dir[0];
                    y = y + dir[1];
                    count++;
                }

                x -= dir[0];
                y -= dir[1];
                count--;

                if (distances[position[0]][position[1]] + count < distances[x][y]) {
                    distances[x][y] = distances[position[0]][position[1]] + count;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return distances[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distances[dest[0]][dest[1]];
    }
}
