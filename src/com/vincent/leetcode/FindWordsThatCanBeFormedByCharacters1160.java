package com.vincent.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedByCharacters1160 {

    public static void main(String[] args) {
        System.out.println(findWordsThatCanBeFormedByCharacters(new String[]{"cat","bt","hat","tree"}, "atach"));
        System.out.println(findWordsThatCanBeFormedByCharacters(new String[]{"hello","world","leetcode"}, "welldonehoneyr"));
    }

    public static int findWordsThatCanBeFormedByCharacters(String[] words, String chars) {
        int result = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        char[] charArr = chars.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charMap.containsKey(charArr[i])) {
                charMap.put(charArr[i], charMap.get(charArr[i]) + 1);
            } else {
                charMap.put(charArr[i], 1);
            }
        }
        for (String word : words) {
            Map<Character, Integer> wordMap = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (wordMap.containsKey(c)) {
                    wordMap.put(c, wordMap.get(c) + 1);
                } else {
                    wordMap.put(c, 1);
                }
            }
            boolean valid = true;
            for (Character key : wordMap.keySet()) {
                if (!charMap.containsKey(key)) {
                    valid = false;
                    break;
                } else {
                    int count = charMap.get(key);
                    if (wordMap.get(key) > count) {
                        valid = false;
                        break;
                    }
                }
            }
            if (valid) {
                result += word.length();
            }
        }
        return result;
    }
}
