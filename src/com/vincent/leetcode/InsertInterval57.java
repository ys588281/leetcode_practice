package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval57 {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> insertInterval(List<List<Integer>> intervals, List<Integer> newInterval) {
        if (newInterval == null && intervals == null) {
            return intervals;
        }
        if (newInterval == null) {
            return intervals;
        }
        List<List<Integer>> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0 && newInterval != null) {
            res.add(newInterval);
            return res;
        }
        int currentStart = intervals.get(0).get(0);
        int currentEnd = intervals.get(0).get(1);

        int i = 1;

        for (; i < intervals.size(); i++) {
            List<Integer> curentInterval = intervals.get(i);
            if (currentEnd >= curentInterval.get(1)) {
                currentEnd = curentInterval.get(1);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(currentStart);
                temp.add(currentEnd);
                res.add(temp);
                break;
            }
        }
        if (i < intervals.size()) {
            for (int j = i; j < intervals.size(); j++) {
                res.add(intervals.get(j));
            }
        }
        return res;
    }
}
