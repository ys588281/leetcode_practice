package com.vincent.leetcode;

public class ValidPalindromeII680 {

    public static void main(String[] args) {
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("abccbda"));
    }

    public static boolean validPalindrome(String input) {
        if (input == null || input.length() == 0 || input.length() == 1) {
            return true;
        }
        int start = 0;
        int end = input.length() - 1;
        boolean deleted = false;
        input = input.toLowerCase();
        while((start < end) && start < input.length() && end >= 0) {
            while((start < end) && !( (input.charAt(start) <='z' && input.charAt(start) >= 'a') ||  (input.charAt(start) >= '0' && input.charAt(start) <= '9') ) ) {
                start++;
            }
            while((start < end) && !( (input.charAt(end) <='z' && input.charAt(end) >= 'a') ||  (input.charAt(end) >= '0' && input.charAt(end) <= '9') )) {
                end--;
            }
            if (input.charAt(start) != input.charAt(end)) {
                if (deleted) {
                    return false;
                } else {
                    deleted = true;
                    end--;
                    continue;
                }
            }
            start++;
            end--;
        }
        return true;
    }
}
