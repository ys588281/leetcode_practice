package com.vincent.leetcode;

import java.util.Arrays;

public class TaskScheduler621 {
    public static void main(String[] args) {
        System.out.println(taskScheduler(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }

    public static int taskScheduler(char[] tasks, int n) {
        int[] cc = new int[26];
        for (char task : tasks) {
            cc[task - 'A']++;
        }
        Arrays.sort(cc);
        int max = cc[25] - 1;
        int space = max * n;
        for (int i = 24; i >= 0 && cc[i] > 0; i--) {
            space -= Math.min(max, cc[i]);
        }

        return space == 0 ? tasks.length : tasks.length + space;
    }
}
