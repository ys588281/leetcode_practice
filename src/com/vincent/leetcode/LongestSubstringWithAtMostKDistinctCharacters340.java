package com.vincent.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters340 {

    public static void main(String[] args) {
        System.out.println(longestSubstringWithAtMostKDistinctCharacters("eceba"));
        System.out.println(longestSubstringWithAtMostKDistinctCharacters("aa"));
    }

    public static int longestSubstringWithAtMostKDistinctCharacters(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int res = Integer.MIN_VALUE;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(chars[end]) && map.size() <= 2) {
                map.put(chars[end], map.get(chars[end]) + 1);
                res = Math.max(res, end - start + 1);
            }
            if (!map.containsKey(chars[end]) && map.size() < 2) {
                map.put(chars[end], 1);
                res = Math.max(res, end - start + 1);
            }
            if (!map.containsKey(chars[end]) && map.size() == 2) {
                while (map.size() == 2) {
                    if (map.get(chars[start]) > 1) {
                        map.put(chars[start], map.get(chars[start]) - 1);
                    } else {
                        map.remove(chars[start]);
                    }
                    start++;
                }
                res = Math.max(res, end - start + 1);
            }
        }
        return res;
    }
}
