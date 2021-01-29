package com.vincent.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class RedundantConnection684 {

    public static void main(String[] args) {
    }

    public static int[] redundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0) return null;
        Map<Integer, Set<Integer>> connections = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            queue.offer(x);
            Set<Integer> visited = new HashSet<>();
            while (!queue.isEmpty()) {
                int node = queue.poll();
                if (!connections.containsKey(node)) continue;
                if (connections.get(node).contains(y)) return edge;
                for (int num : connections.get(node)) {
                    if (visited.contains(num)) continue;
                    queue.offer(num);
                    visited.add(num);
                }
            }

            connections.putIfAbsent(x, new HashSet<>());
            connections.putIfAbsent(y, new HashSet<>());
            connections.get(x).add(y);
            connections.get(y).add(x);

        }
        return new int[]{-1, -1};
    }
}
