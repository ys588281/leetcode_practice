package com.vincent.leetcode;

public class FindTheCelebrity277 {
    public static void main(String[] args) {
        findTheCelebrity(8);
    }

    public static int findTheCelebrity(int n) {
        for (int i = 0; i < n; i++) {
            boolean isCelebrity = true;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (knows(j, i) && !knows(i, j)) {
                    continue;
                } else {
                    isCelebrity = false;
                    break;
                }
            }
            if (isCelebrity) {
                return i;
            }
        }
        return -1;
    }

    public static int findTheCelebrity2(int n) {
        int celebrity = 0;
        for (int i = 1; i < n; i++) {
            celebrity = (knows(i, celebrity)) ? celebrity : i;
        }
        for (int i = 0; i < n; i++) {
            if (i != celebrity && !knows(celebrity, i)) {
                continue;
            } else {
                return -1;
            }
        }
        return celebrity;
    }

    private static boolean knows(int a, int b) {
        return Math.random() < 0.5;
    }
}
