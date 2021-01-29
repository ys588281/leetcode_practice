package com.vincent.leetcode;

public class CompareVersionNumbers165 {
    public static void main(String[] args) {
        compareVersionNumbers("0.1", "1.1");
    }

    public static int compareVersionNumbers(String version1, String version2) {
        System.out.println(version1);
        System.out.println(version2);
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");
        int i = 0;
        System.out.println(v1s.length);
        System.out.println(v2s.length);
        while (i < v1s.length || i < v2s.length) {
            System.out.println(i);
            int v1 = 0;
            int v2 = 0;
            if (i < v1s.length) {
                v1 = convertToInt(v1s[i]);
            }
            if (i < v2s.length) {
                v2 = convertToInt(v2s[i]);
            }
            if (v1 > v2) {
                return 1;
            }
            if (v1 < v2) {
                return -1;
            }
        }
        return 0;
    }
    public static int convertToInt(String s) {
        System.out.println(s);
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.toCharArray()[i] != '0') {
                String temp = s.substring(i);
                System.out.println(temp);
                return Integer.valueOf(temp);
            }
        }
        return 0;
    }
}
