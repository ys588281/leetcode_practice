package com.vincent.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance1334 {

    public static void main(String[] args) {
        System.out.println(
                findTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance(4,
                        new int[][]{
                                {0,1,3},
                                {1,2,1},
                                {1,3,4},
                                {2,3,1}
                        }
                        , 4)
        );
        System.out.println(
                findTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance2(4,
                        new int[][]{
                                {0,1,3},
                                {1,2,1},
                                {1,3,4},
                                {2,3,1}
                        }
                        , 4)
        );
    }

    public static int findTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance2(int n, int[][] edges, int distanceThreshold) {
        int[][] distances = new int[n][n];
        for (int[] distance : distances) {
            Arrays.fill(distance, Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            distances[i][i] = 0;
        }
        for (int[] edge : edges) {
            distances[edge[0]][edge[1]] = edge[2];
            distances[edge[1]][edge[0]] = edge[2];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                }
            }
        }

        int res = -1;
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if (distances[i][j] <= distanceThreshold) temp++;
            }
            if (temp != 0 && temp <= count) {
                count = temp;
                res = i;
            }
        }
        return res;
    }

    public static int findTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, Set<Dijkstra>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new HashSet<>());
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[0]).add(new Dijkstra(edge[1], edge[2]));
            map.get(edge[1]).add(new Dijkstra(edge[0], edge[2]));
        }

        int res = -1;
        int tempCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] distance = new int[n];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[i] = 0;
            PriorityQueue<Dijkstra> queue = new PriorityQueue<>((a, b) -> {
                return a.value - b.value;
            });
            queue.offer(new Dijkstra(i, 0));
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            while (!queue.isEmpty()) {
                Dijkstra node = queue.poll();
                if (distance[node.index] < node.value) {
                    continue;
                }
                distance[node.index] = node.value;
                visited.add(node.index);

                Set<Dijkstra> neighbors = map.get(node.index);
                if (neighbors == null) {
                    continue;
                }

                for (Dijkstra neighbor : neighbors) {
                    if (distance[neighbor.index] > neighbor.value + node.value && !visited.contains(neighbor.index)) {
                        distance[neighbor.index] = neighbor.value + node.value;
                        queue.add(new Dijkstra(neighbor.index, distance[neighbor.index]));
                    }
                }

            }

            int count = 0;
            for (int dist : distance) {
                if (dist <= distanceThreshold) {
                    count++;
                }
            }
            if (count != 0 && count <= tempCount) {
                tempCount = count;
                res = i;
            }

        }
        return res == -1 ? -1 : res;
    }
}
