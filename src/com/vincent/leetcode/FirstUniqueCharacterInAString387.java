package com.vincent.leetcode;

public class FirstUniqueCharacterInAString387 {

    public static void main(String[] args) {
        System.out.println(firstUniqueCharacterInAString("leetcode"));
        System.out.println(firstUniqueCharacterInAString("loveleetcode"));
    }

    public static int firstUniqueCharacterInAString(String s) {
        int[] frequent = new int[26];
        int[] index = new int[26];
        for (int i = 0; i < frequent.length; i++) {
            frequent[i] = 0;
            index[i] = 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            frequent[c - 'a']++;
            if (index[c - 'a'] == 0) {
                index[c - 'a'] = i;
            }
        }
        for (int i = 0; i < frequent.length; i++) {
            if (frequent[i] == 1) {
                if (index[i] < min) {
                    min = index[i];
                }
            }
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
}
