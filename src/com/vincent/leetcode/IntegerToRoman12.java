package com.vincent.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman12 {
    public static void main(String[] args) {
        System.out.println(integerToRoman(3));
        System.out.println(integerToRoman(9));
        System.out.println(integerToRoman(58));
        System.out.println(integerToRoman(1994));
    }

    public static String integerToRoman(int num) {
        int[] romanSeq = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        Map<Integer, String> romanMap = new HashMap<>();
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int temp = num / romanSeq[i];
            if (temp > 0) {
                for (int j = 0; j < temp; j++) {
                    sb.append(romanMap.get(romanSeq[i]));
                }
                num = num % romanSeq[i];
                i++;
            } else {

                i++;
            }
        }
        return sb.toString();
    }
}
