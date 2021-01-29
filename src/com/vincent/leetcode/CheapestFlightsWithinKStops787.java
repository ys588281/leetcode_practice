package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CheapestFlightsWithinKStops787 {

    public static void main(String[] args) {

    }

    public static int cheapestFlightsWithinKStopsBFS(int n, int[][] flights, int src, int dst, int K) {
        if (n <= 0 || K < 0) return -1;
        if (src == dst) return 0;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] flight : flights) {
            map.computeIfAbsent(flight[0], x -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0});
        int step = 0;
        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                int[] temp = queue.poll();
                if (temp[0] == dst) {
                    result = Math.min(temp[1], result);
                }
                List<int[]> nexts = map.get(temp[0]);
                if (nexts == null || nexts.size() == 0) continue;
                for (int[] next : nexts) {
                    int current = temp[1] + next[1];
                    if (current < result) {
                        queue.offer(new int[]{next[0], current});
                    }
                }
            }
            if (step++ > K) {
                break;
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static int dfsResult = Integer.MAX_VALUE;
    public static int cheapestFlightsWithinKStopsDFS(int n, int[][] flights, int src, int dst, int K) {
        if (n <= 0 || K < 0) return -1;
        if (src == dst) return 0;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] flight : flights) {
            map.computeIfAbsent(flight[0], x -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }
        boolean[] visited = new boolean[n];
        helper(map, visited, src, 0, dst, K);
        return dfsResult;
    }

    public static void helper(Map<Integer, List<int[]>> map, boolean[] visited, int current, int cost, int dst, int K) {
        if (current == dst) {
            dfsResult = Math.min(cost, dfsResult);
        }
        if (K < 0) return;
        List<int[]> nexts = map.get(current);
        if (nexts == null || nexts.size() == 0) return;
        for (int[] next : nexts) {
            if (visited[next[0]] == false && cost + next[1] < dfsResult) {
                visited[next[0]] = true;
                cost = cost + next[1];
                helper(map, visited, next[0], cost, dst, K-1);
                visited[next[0]] = true;
            }
        }
    }
}
