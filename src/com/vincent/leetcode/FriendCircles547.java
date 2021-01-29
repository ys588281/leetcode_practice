package com.vincent.leetcode;

public class FriendCircles547 {

    public static void main(String[] args) {

    }

    public static int friendCircles(int[][] M) {
        if (M == null || M[0].length == 0) return 0;
        int[] visited = new int[M.length];
        int n = M.length;
        int result = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 1) continue;
            dfs(M, visited, i, n);
            result++;
        }
        return result;
    }

    private static void dfs(int[][] M, int[] visited, int current, int n) {
        if (visited[current] == 1) return;
        visited[current] = 1;
        for (int i = 0; i < n; i++) {
            if (M[current][i] == 1 && visited[i] == 0) {
                dfs(M, visited, i, n);
            }
        }
    }
}
