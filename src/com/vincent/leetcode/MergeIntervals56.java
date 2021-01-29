package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals56 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> mergeInterval(List<List<Integer>> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        int currentStart = intervals.get(0).get(0);
        int currentEnd = intervals.get(0).get(1);

        for (int i = 1; i < intervals.size(); i++) {
            List<Integer> currentInterval = intervals.get(i);
            if (currentInterval.get(1) <= currentEnd) {
                currentEnd = currentInterval.get(1);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(currentStart);
                temp.add(currentEnd);
                res.add(temp);
                currentStart = currentInterval.get(0);
                currentEnd = currentInterval.get(1);
            }
        }
        return res;
    }
}
