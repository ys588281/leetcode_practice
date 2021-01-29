package com.vincent.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestNumber179 {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));
        System.out.println(largestNumber(new int[]{10, 2}));
    }

    public static String largestNumber(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                char[] c2 = String.valueOf(o2).toCharArray();
                char[] c1 = String.valueOf(o1).toCharArray();
                int i = 0;
                while (i < c2.length && i < c1.length) {
                    int i2 = c2[i] - '0';
                    int i1 = c1[i] - '0';
                    if (i2 > i1) return 1;
                    if (i2 < i1) return -1;
                    i++;
                }
                return o2 - o1;
            }
        });

        for (int num : nums) {
            priorityQueue.offer(num);
        }

        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            sb.append(priorityQueue.poll());
        }
        return sb.toString();
    }
}
