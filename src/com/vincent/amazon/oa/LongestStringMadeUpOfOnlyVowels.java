package com.vincent.amazon.oa;

public class LongestStringMadeUpOfOnlyVowels {

    public static void main(String[] args) {

    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static int longestStringMadeUpOfOnlyVowels(String s) {
        int len = s.length();
        int start = 0;
        int end = s.length() - 1;
        while (start < len && isVowel(s.charAt(start))) start++;
        while (end >= 0 && isVowel(s.charAt(end))) end--;
        if ( start >= len) return len;
        int res = start + (len - end + 1);

        int i = start + 1;
        int sum = 0;
        int max = 0;
        while (i <= end) {
            if (isVowel(s.charAt(i))) {
                sum++;
                max = Math.max(max, sum);
            } else {
                sum = 0;
                max = Math.max(max, sum);
            }
            i++;
        }
        return max + res;
    }
}
