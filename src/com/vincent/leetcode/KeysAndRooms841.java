package com.vincent.leetcode;

public class KeysAndRooms841 {

    public static void main(String[] args) {

    }

    public static boolean keysAndRooms(int[][] nums) {
        int[] visited = new int[nums.length];
        for (int[] num : nums) {
            for (int n : num) {
                if (visited[n] == 1) continue;
                visited[n] = 1;
            }
        }
        for (int visit : visited) {
            if (visit == 0) return false;
        }
        return true;
    }
}
