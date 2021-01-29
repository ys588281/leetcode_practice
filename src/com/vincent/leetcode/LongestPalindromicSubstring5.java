package com.vincent.leetcode;

public class LongestPalindromicSubstring5 {

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstring("babad"));
        System.out.println(longestPalindromicSubstring("cbbd"));
    }

    public static int longestPalindromicSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int result = 1;
        for (int i = 0; i < s.length(); i++) {
            String longest = helper(s, i, i);
            result = (longest.length() > result)? longest.length() : result;
            longest = helper(s, i, i + 1);
            result = (longest.length() > result) ? longest.length() : result;
        }
        return result;
    }

    private static String helper(String s, int begin, int end) {
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }
}
