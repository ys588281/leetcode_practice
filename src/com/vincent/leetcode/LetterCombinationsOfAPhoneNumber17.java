package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber17 {
    public static void main(String[] args) {
        List<String> results = letterCombinations("23");
        System.out.println(results.size());
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }

        List<String> results1 = letterCombinations2("23");
        System.out.println(results1.size());
        for (int i = 0; i < results1.size(); i++) {
            System.out.println(results1.get(i));
        }
    }


    public static List<String> letterCombinations2(String digits) {
        if (digits == null || digits.length() == 0) {
            return null;
        }
        List<String> results = new ArrayList<>();
        dfs2(results, digits, new StringBuilder(), 0);
        return results;
    }


    public static void dfs2(List<String> results, String digits, StringBuilder item, int index) {
        char[][] digitsmap = new char[][]{
                {},
                {},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                { 'g', 'h', 'i' },
                { 'j', 'k', 'l' },
                { 'm', 'n', 'o' },
                { 'p', 'q', 'r', 's' },
                { 't', 'u', 'v' },
                { 'w', 'x', 'y', 'z' }
        };
        if (item.length() == digits.length()) {
            results.add(item.toString());
        } else {
            char current = digits.charAt(index);
            char[] currentArr =  digitsmap[current - '0'];
            for (int i = 0; i < currentArr.length; i++) {
                item.append(currentArr[i]);
                dfs2(results, digits, item, index + 1);
                item.deleteCharAt(item.length() - 1);
            }
        }
    }



    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return null;
        }
        List<String> results = new ArrayList<>();
        return dfs(results, digits, 0);
    }

    public static List<String> dfs(List<String> results, String digits, int current) {
        Map<String, List<String>> digitsMap = new HashMap<>();
        digitsMap.put("2", Arrays.asList(new String[]{"a", "b", "c"}));
        digitsMap.put("3", Arrays.asList(new String[]{"d", "e", "f"}));
        digitsMap.put("4", Arrays.asList(new String[]{"g", "h", "i"}));
        digitsMap.put("5", Arrays.asList(new String[]{"j", "k", "l"}));
        digitsMap.put("6", Arrays.asList(new String[]{"m", "n", "o"}));
        digitsMap.put("7", Arrays.asList(new String[]{"p", "q", "r", "s"}));
        digitsMap.put("8", Arrays.asList(new String[]{"t", "u", "v"}));
        digitsMap.put("9", Arrays.asList(new String[]{"w", "x", "y", "z"}));
        if (current >= digits.length()) {
            return results;
        }
        String temp = digits.substring(current, current + 1);
        if (digitsMap.containsKey(temp)) {
            List<String> tempArr = digitsMap.get(temp);
            if (current == 0) {
                for (int i = 0; i < tempArr.size(); i++) {
                    results.add(tempArr.get(i));
                }
            } else {
                List<String> res = new ArrayList<>();
                for (int j = 0; j < results.size(); j++) {
                    for (int i = 0; i < tempArr.size(); i++) {
                        String currentElem = tempArr.get(i);
                        res.add(results.get(j) + currentElem);
                    }
                }
                results = res;
            }
            return dfs(results, digits, current + 1);
        }
        return results;
    }
}
