package com.vincent.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin973 {

    public static void main(String[] args) {
        System.out.println();
    }

    public static int[][] kClosestPointsToOrigin(int[][] points, int k) {
        if (points == null || points.length == 0 || k == 0) {
            return null;
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return (p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] * p2[1]);
            }
        });

        for (int[] point : points) {
            priorityQueue.offer(point);
        }

        int[][] results = new int[k][2];
        int i = 0;
        while (priorityQueue.size() != 0) {
            int[] p = priorityQueue.poll();
            results[i]  = new int[]{p[0], p[2]};
            i++;
        }
        return results;
    }
}
