package com.vincent.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class NetworkDelayTime743 {
    public static void main(String[] args) {

    }

    public static int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Set<Dijkstra>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashSet<>());
            map.get(time[0]).add(new Dijkstra(time[1], time[2]));
        }

        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0;


        PriorityQueue<Dijkstra> queue = new PriorityQueue<>((a, b) -> {
            return a.value - b.value;
        });
        queue.add(new Dijkstra(K, 0));
        Set<Integer> visited = new HashSet<>();
        visited.add(K);

        while (!queue.isEmpty()) {
            Dijkstra node = queue.poll();
            if (distance[node.index] < node.value) {
                continue;
            }
            distance[node.index] = node.index;
            visited.add(node.index);
            Set<Dijkstra> set = map.get(node.index);
            if (set == null) continue;
            for (Dijkstra neighbor : set) {
                if (distance[neighbor.index] > neighbor.value + node.value && !visited.contains(neighbor.index)) {
                    distance[neighbor.index] = neighbor.value + node.value;
                    queue.add(new Dijkstra(neighbor.index, distance[neighbor.index]));
                }
            }
        }

        int res = -1;
        for (int dist : distance) {
            res = Math.max(res, dist);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }


}

