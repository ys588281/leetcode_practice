package com.vincent.leetcode;

public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps1296 {

    public static void main(String[] args) {
        System.out.println(numberOfWaysToStayInTheSamePlaceAfterSomeSteps(3, 2));
        System.out.println(numberOfWaysToStayInTheSamePlaceAfterSomeSteps(2, 4));
    }

    public static int numberOfWaysToStayInTheSamePlaceAfterSomeSteps(int steps, int arrLen) {
        return helper(steps, 0, 0, arrLen);
    }

    private static int helper(int steps, int currentStep, int currentPos, int arrLen) {
        if (currentStep == steps && currentPos == 0) {
            return 1;
        }
        if (currentPos > arrLen) {
            return 0;
        }
        return helper(steps, currentStep + 1, currentPos + 1, arrLen)
                + helper(steps, currentStep + 1, currentPos - 1, arrLen)
                + helper(steps, currentStep + 1, currentPos, arrLen);
    }
}
