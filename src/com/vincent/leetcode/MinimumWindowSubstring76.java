package com.vincent.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {

    public static void main(String[] args) {
        System.out.println(minimumWindowSubstring("ADOBECODEBANC", "ABC"));
    }

    public static String minimumWindowSubstring(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        String res = "";
        int resLength = Integer.MAX_VALUE;
        int start = 0;
        Map<String, Integer> count = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            String currentEnd = s.substring(end, end + 1);
            if (t.indexOf(currentEnd) > -1) {
                if (count.containsKey(currentEnd)) {
                    count.put(currentEnd, count.get(currentEnd) + 1);
                } else {
                    count.put(currentEnd, 1);
                }
                while (count.size() == t.length() && end > start) {
                    if ((end - start + 1) < resLength) {
                        res = s.substring(start, end + 1);
                        resLength = res.length();
                    }
                    String currentStart = s.substring(start, start + 1);
                    if (count.containsKey(currentStart)) {
                        if (count.get(currentStart) > 1) {
                            count.put(currentStart, count.get(currentStart) - 1);
                            start++;
                        } else {
                            break;
                        }
                    } else {
                        start++;
                        continue;
                    }


                }
            }
        }
        return res;
    }
}
