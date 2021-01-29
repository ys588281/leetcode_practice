package com.vincent.leetcode;

public class ValidPalindrome125 {

    public  static void main(String[] args) {
        System.out.println(validPalindrome(""));
        System.out.println(validPalindrome("a"));
        System.out.println(validPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome("race a car"));
    }

    public static boolean validPalindrome(String input) {
        if (input == null || input.length() == 0 || input.length() == 1) {
            return true;
        }
        int start = 0;
        int end = input.length() - 1;
        input = input.toLowerCase();
        while((start < end) && start < input.length() && end >= 0) {
            while((start < end) && !( (input.charAt(start) <='z' && input.charAt(start) >= 'a') ||  (input.charAt(start) >= '0' && input.charAt(start) <= '9') ) ) {
                start++;
            }
            while((start < end) && !( (input.charAt(end) <='z' && input.charAt(end) >= 'a') ||  (input.charAt(end) >= '0' && input.charAt(end) <= '9') )) {
                end--;
            }
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
