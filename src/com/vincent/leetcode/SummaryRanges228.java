package com.vincent.leetcode;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges228 {

    public static void main(String[] args){
        int[] input = new int[]{0,1,2,4,5,7};
//        int[] input = new int[]{0,2,3,4,6,8,9};
        List output = summaryRanges(input);
        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }
    }

    public static List<String> summaryRanges(int[] input) {
        List<String> output = new LinkedList<>();
        if (input.length == 0) {
            return output;
        }
        if (input.length == 1) {
            output.add(String.valueOf(input[0]));
            return output;
        }
        int left = input[0];
        int right = input[0];
        int small = left;
        for (int i = 1; i < input.length; i++) {
            int temp = input[i];
            if (temp - small > 1) {
                output.add(composeString(left, right));
                left = temp;
                right = temp;
                small = temp;
            } else {
                right = temp;
                small = temp;
            }
        }
        output.add(composeString(left, right));
        return output;
    }

    private static String composeString(int left, int right) {
        if (left == right) {
            return String.format("%d", left);
        }
        return String.format("%d->%d", left, right);
    }
}
