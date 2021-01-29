package com.vincent.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation433 {

    public static void main(String[] args) {
        System.out.println(minimumGeneticMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        System.out.println(minimumGeneticMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
        System.out.println(minimumGeneticMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }

    public static int minimumGeneticMutation(String start, String end, String[] bank) {
        if (start.length() != end.length()) return -1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> banks = new HashSet<>();
        for (String b : bank) {
            banks.add(b);
        }

        int step = 0;
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            if (temp.equals(end)) {
                return step;
            }
            Iterator<String> pos = banks.iterator();
            while(pos.hasNext()) {
                String next = pos.next();
                if(valid(temp, next)) {
                    queue.add(next);
                    pos.remove();
                }
            }
            step++;
        }
        return -1;
    }

    private static boolean valid(String temp, String b) {
        int count = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        if (count > 1) return false;
        return true;
    }
}
