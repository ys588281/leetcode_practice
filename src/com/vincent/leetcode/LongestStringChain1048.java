package com.vincent.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain1048 {

    public static void main(String[] args) {
        System.out.println(longestStringChain(new String[]{"a","b","ba","bca","bda","bdca"}));
    }

    public static int longestStringChain(String[] words) {
        if (words == null || words.length == 0) return 0;
        if (words.length == 1) return 1;
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();

        for (String word : words) {
            map.putIfAbsent(word, 1);
        }
        int result = Integer.MIN_VALUE;
        for (String word : words) {
            result = Math.max(result, 1 + dfs(word, map, counts));
        }
        return result;
    }

    private static int dfs(String sb, Map<String, Integer> map, Map<String, Integer> counts) {
        System.out.println(sb);
        if (sb.length() == 0) {
            return 0;
        }
        if (counts.containsKey(sb)) return counts.get(sb);
        int max = 0;
        for (int i = 0; i < sb.length(); i++) {
            StringBuilder sbb = new StringBuilder(sb);
            sbb.deleteCharAt(i);
            int res = 0;
            if (map.containsKey(sbb.toString())) {
                int temp = dfs(sbb.toString(), map, counts);
                System.out.println("sbb.toString(): " + sbb.toString() + " " + temp);
                res = 1 + temp;
            }
            max = Math.max(res, max);
            System.out.println(sb + "  " + max);
        }
        counts.put(sb, max);
        return max;
    }
}