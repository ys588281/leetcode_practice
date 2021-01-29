package com.vincent.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements347 {

    public static void main(String[] args) {
        System.out.println(topKFrequentElements(new int[]{1,1,1,2,2,3}, 2));
    }

    public static List<Integer> topKFrequentElements(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return counts.get(02) - counts.get(01);
            }
        });

        for (int key : counts.keySet()) {
            priorityQueue.offer(key);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        System.out.println(priorityQueue.size());
        List<Integer> results = new LinkedList<>();
        while (priorityQueue.size() != 0) {
            int temp = priorityQueue.poll();
            System.out.println(temp);
            results.add(temp);
        }
        return results;
    }
}
