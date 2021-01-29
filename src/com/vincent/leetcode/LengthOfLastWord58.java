package com.vincent.leetcode;

public class LengthOfLastWord58 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }

    public static int lengthOfLastWord(String s) {
        String[] split = s.split( " ");
        return split[split.length - 1].length();
    }
}
