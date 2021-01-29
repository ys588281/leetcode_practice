package com.vincent.leetcode;

public class ReverseStringII541 {
    public static void main(String[] args) {
        System.out.println(reverseString("abcdefg", 2));
    }

    public static String reverseString(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int r = i / k;
            if (r % 2 == 0) {
                sb.append(s.charAt(i + 1));
                sb.append(s.charAt(i));
                i = i + 2;
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}
