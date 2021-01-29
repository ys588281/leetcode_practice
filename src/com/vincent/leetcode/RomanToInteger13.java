package com.vincent.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger13 {

    public static void main(String[] args) {
        System.out.println(romanToInteger("IV"));
        System.out.println(romanToInteger("IX"));
        System.out.println(romanToInteger("III"));
        System.out.println(romanToInteger("LVIII"));
        System.out.println(romanToInteger("MCMXCIV"));
    }

    public static int romanToInteger(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        if (s.length() == 1) {
            return romanMap.get(s);
        }
        int sum = romanMap.get(s.charAt(s.length() - 1));
        char[] chars = s.toCharArray();
        for (int i = s.length() - 2; i >= 0; i--) {
            int current = romanMap.get(s.charAt(i));
            int next = romanMap.get(s.charAt(i + 1));
            if (current < next) {
                sum = sum - current;
            } else {
                sum = sum + current;
            }
        }
        return sum;
    }
}
