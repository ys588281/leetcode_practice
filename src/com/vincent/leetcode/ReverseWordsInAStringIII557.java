package com.vincent.leetcode;

public class ReverseWordsInAStringIII557 {
    public static void main(String[] args) {
        System.out.println(reverseWordsInAStringIII("Let's take LeetCode contest"));
    }

    public static String reverseWordsInAStringIII(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        String[] sArr = s.split(" ");
        for (String ss : sArr) {
            int left = 0, right = ss.length() - 1;
            char[] cArr = ss.toCharArray();
            while (left <= right) {
                char temp = cArr[left];
                cArr[left] = cArr[right];
                cArr[right] = temp;
                left++;
                right--;
            }
            StringBuilder tsb = new StringBuilder();
            for (int i = 0; i < cArr.length; i++) {
                tsb.append(cArr[i]);
            }
            sb.append(tsb.toString());
            sb.append(" ");
        }
        String result = sb.toString();
        return result.substring(0, result.length() - 1);
    }
}
