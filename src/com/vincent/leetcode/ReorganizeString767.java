package com.vincent.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString767 {

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
    }

    public static String reorganizeString(String s) {
        if (s == null || s.length() == 0) return "";
        if (s.length() == 1) return s;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        PriorityQueue<Character> priorityQueue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (map.get(o2) == map.get(o1)) {
                    return o2 - o1;
                } else {
                    return map.get(o2) - map.get(o1);
                }
            }
        });

        int validationCondition = s.length() / 2 + 1;
        if (s.length() % 2 == 0) validationCondition = s.length() / 2;
        for (Character key : map.keySet()) {
            if (map.get(key) > validationCondition) {
                return "";
            }
            priorityQueue.offer(key);
        }

        StringBuilder sb = new StringBuilder();
        while (priorityQueue.size() > 1) {
            Character c1 = priorityQueue.poll();
            Character c2 = priorityQueue.poll();
            sb.append(c1);
            sb.append(c2);
            if (map.get(c1) == 1) {
                map.remove(c1);
            } else {
                map.put(c1, map.get(c1) - 1);
                priorityQueue.offer(c1);
            }
            if (map.get(c2) == 1) {
                map.remove(c2);
            } else {
                map.put(c2, map.get(c2) - 1);
                priorityQueue.offer(c2);
            }
        }

        while (priorityQueue.size() > 0) {
            sb.append(priorityQueue.poll());
        }

        return sb.toString();
    }
}
