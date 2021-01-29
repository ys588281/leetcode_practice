package com.vincent.leetcode;

import java.util.PriorityQueue;

public class CampusBikes1057 {

    public static void main(String[] args) {

    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int ws = workers.length;
        int bs = bikes.length;
        int[] results = new int[ws];
        boolean[] wOccupied = new boolean[ws];
        boolean[] bOccupied = new boolean[bs];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) {
                return a[2] - b[2];
            }
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                priorityQueue.add(new int[]{i, j, distance(workers[i], bikes[j])});
            }
        }

        while (!priorityQueue.isEmpty()) {
            int[] r = priorityQueue.poll();
            if (wOccupied[r[0]] || bOccupied[r[1]]) continue;

            results[r[0]] = r[1];
            wOccupied[r[0]] = true;
            bOccupied[r[1]] = true;
        }
        return results;
    }

    public static int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
