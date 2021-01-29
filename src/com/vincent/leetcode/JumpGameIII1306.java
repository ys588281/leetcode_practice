package com.vincent.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII1306 {

    public static void main(String[] args) {
        System.out.println(jumpGame(new int[]{4,2,3,0,3,1,2}, 5));
        System.out.println(jumpGame(new int[]{4,2,3,0,3,1,2}, 0));
        System.out.println(jumpGame(new int[]{3,0,2,1,2}, 2));
    }

    public static boolean jumpGame(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            visited[i] = false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            int step = arr[num];
            visited[num] = true;
            if (start + step < arr.length) {
                if (arr[start + step] == 0) {
                    return true;
                }
                if (visited[start + step] == false) {
                    queue.add(start + step);
                }
            }
            if (start - step >= 0) {
                if (arr[start - step] == 0) {
                    return true;
                }
                if (visited[start - step] == false) {
                    queue.add(start - step);
                }
            }
        }
        return false;
    }
}
