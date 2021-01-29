package com.vincent.leetcode;

public class ValidAnagram242 {

    public static void main(String[] args) {
        System.out.println(validAnagram("anagram", "nagaram"));
        System.out.println(validAnagram("rat", "car"));
    }

    public static boolean validAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] sc = new int[256];
        int[] tc = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            sc[cs - 'a'] = sc[cs - 'a'] + 1;
            tc[ct - 'a'] = tc[ct - 'a'] + 1;
        }
        for (int i = 0; i < 256; i++) {
            if (sc[i] != tc[i]) {
                return false;
            }
        }
        return true;
    }
}
