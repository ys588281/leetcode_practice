package com.vincent.leetcode;

public class RobotReturnToOrigin657 {
    public static void main(String[] args) {
        System.out.println(RobotReturnToOrigin("UD"));
        System.out.println(RobotReturnToOrigin("LL"));
        System.out.println(RobotReturnToOrigin(""));
    }

    public static boolean RobotReturnToOrigin(String input) {
        if (input.length() == 0) {
            return true;
        }
        int totalX = 0;
        int totalY = 0;
        char[] inputChars = input.toCharArray();
        for (int i = 0; i < inputChars.length; i++) {
            char c = inputChars[i];
            if (c == 'U') {
                totalY++;
            } else if (c == 'D') {
                totalY--;
            } else if (c == 'R') {
                totalX++;
            } else if (c == 'L') {
                totalX--;
            } else {
                return false;
            }
        }
        if (totalX == 0 && totalY == 0) {
            return true;
        }
        return false;
    }
}
