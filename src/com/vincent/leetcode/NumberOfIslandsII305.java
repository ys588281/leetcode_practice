package com.vincent.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NumberOfIslandsII305 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> res = NumberOfIslandsII(3,3, new int[][]{
                {0, 0},
                {0, 1},
                {1, 2},
                {2, 1},
        });
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static List<Integer> NumberOfIslandsII(int m, int n, int[][] positions) {
        int[] map = new int[m * n];
        int[][] directions = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };
        Arrays.fill(map, -1);
        List<Integer> results = new LinkedList<>();
        int result = 0;
        for (int[] position : positions) {
            int x = position[0];
            int y = position[1];
            int idx = n * x + y;
            if (map[idx] != -1) continue;
            result++;
            map[idx] = idx;
            for (int[] direction : directions) {
                int cx = x + direction[0];
                int cy = y + direction[1];
                if (cx >= 0 && cx < m && cy >= 0 && cy < n && map[cx * n + cy] != -1) {
                    int ux = find(map, idx);
                    int uc = find(map, cx * n + cy);
                    if (ux != uc) {
                        result--;
                        map[idx] = uc;
                    }
                }
            }
            results.add(result);
        }
        return results;
    }

    public static int find(int[] map, int input) {
        while (input != map[input]) {
            input = map[input];
        }
        return input;
    }
}
