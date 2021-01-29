package com.vincent.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutRepeatingCharacters("abcabcbb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters("bbbbb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters("pwwkew"));
    }

    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        if (s == null && s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int res = 0;
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        char[] chs = s.toCharArray();
        while (end < s.length()) {
            if (!set.contains(chs[end])) {
                set.add(chs[end]);
                res = Math.max(res, end - start + 1);
                end++;
            } else {
                set.remove(chs[end]);
                start++;
            }
        }
        return res;
    }
}
