package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInANetwork1192 {

    public static void main(String[] args) {
        List<List<Integer>> results = criticalConnectionsInANetwork(4, new int[][]{
                {0, 1},
                {1, 2},
                {2, 0},
                {1, 3},
        });
        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.get(i).size(); j++) {
                System.out.print(results.get(i).get(j) + "  ");
            }
            System.out.println();
        }
    }

    public static int time = 0;

    public static List<List<Integer>> criticalConnectionsInANetwork(int n, int[][] connections) {
        if (connections == null || connections.length == 0) {
            return null;
        }
        int[] lows = new int[n];
        int[] discovers = new int[n];
        Arrays.fill(lows, -1);
        Arrays.fill(discovers, -1);
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(connection[0]);
        }
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (discovers[i] == -1) {
                dfs(i, graph, lows, discovers, results, i);
            }
        }

        return results;
    }

    private static void dfs(int current, List<Integer>[] graph, int[] lows, int[] discovers, List<List<Integer>> results, int pre) {
        if (discovers[current] != -1) {
            return;
        }
        discovers[current] = lows[current] = time++;
        List<Integer> neighbors = graph[current];
        for (int neighbor : neighbors) {
            if (neighbor == pre) {
                continue;
            }
            if (discovers[neighbor] == -1) {
                dfs(neighbor, graph, lows, discovers, results, current);
                lows[current] = Math.min(lows[current], lows[neighbor]);
                if (lows[neighbor] > discovers[current]) {
                    results.add(Arrays.asList(current, neighbor));
                }
            } else {
                lows[current] = Math.min(lows[current], discovers[neighbor]);
            }
        }
    }
}
