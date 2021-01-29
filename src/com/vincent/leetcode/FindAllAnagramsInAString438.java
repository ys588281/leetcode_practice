package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString438 {

    public static void main() {

    }

    public static List<Integer> findAllAnagramsInAString(String s, String p) {
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return new ArrayList<Integer>();
        }
        List<Integer> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        int count = p.length();
        int[] pChars = new int[256];
        char[] pCharArr = p.toCharArray();
        for (int i = 0; i < pCharArr.length; i ++) {
            pChars[pCharArr[i]]++;
        }
        for (end = 0; end < s.length(); end++) {

        }
        return new ArrayList<Integer>();
    }

}
