package com.vincent.leetcode;

public class ReverseString344 {
    public static void main(String[] args) {
        char[] ccs = new char[]{};

    }

    public static void reverseString(char[] s) {
        if (s == null || s.length == 0 || s.length == 1) {
            return;
        }
        int left = 0, right = s.length - 1;
        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

}
