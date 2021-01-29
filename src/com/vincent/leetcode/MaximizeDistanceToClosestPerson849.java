package com.vincent.leetcode;

public class MaximizeDistanceToClosestPerson849 {
    public static void main(String[] args) {
//        System.out.println(maximizeDistanceToClosestPerson(new int[]{1, 0, 0, 0}));
        System.out.println(maximizeDistanceToClosestPerson(new int[]{1,0,0,0,1,0,1}));
    }

    public static int maximizeDistanceToClosestPerson(int[] seats) {
        if (seats == null || seats.length == 0) {
            return 0;
        }
        int[] forwards = new int[seats.length];
        int[] backwards = new int[seats.length];
        for (int i = 0; i < seats.length; i++) {
            forwards[i] = -1;
            backwards[i] = -1;
        }
        int[] res = new int[seats.length];
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                forwards[i] = 0;
            } else {
                if (i == 0) {
                    continue;
                } else {
                    if (forwards[i - 1] != -1) {
                        forwards[i] = forwards[i - 1] + 1;
                    }
                }
            }
        }
        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                backwards[i] = 0;
            } else {
                if (i == seats.length - 1) {
                    continue;
                } else {
                    if (backwards[i + 1] != -1) {
                        backwards[i] = backwards[i + 1] + 1;
                    }
                }
            }
        }
        int result = -1;
        for (int i = 0; i < seats.length; i++) {
            if (forwards[i] == -1) {
                result = (result > backwards[i]) ? result : backwards[i];
            } else if (backwards[i] == -1) {
                result = (result > forwards[i]) ? result : forwards[i];
            } else {
                int temp = Math.min(forwards[i], backwards[i]);
                result = (result > temp) ? result : temp;
            }
        }
        return result;
    }
}
