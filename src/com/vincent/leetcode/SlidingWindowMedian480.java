package com.vincent.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMedian480 {
    public static void main(String[] args) {

    }

    public static double[] slidingWindowMedian(int[] nums, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>(nums.length);
        PriorityQueue<Integer> max = new PriorityQueue<>(nums.length, Comparator.reverseOrder());
        double[] results = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            min.add(current);
            max.add(min.poll());
            if (min.size() > max.size()) {
                max.add(min.poll());
            }
            if (i >= k) {
                if (current < min.peek()) {
                    max.remove(nums[i - k]);
                } else {
                    min.remove(nums[i - k]);
                }
                if (min.size() > max.size()) {
                    max.add(min.poll());
                }
            }

            if (i >= k - 1) {
                if (min.size() == max.size()) {
                    results[i - k + 1] = (min.peek() + max.peek()) / 2;
                } else {
                    results[i - k + 1] = max.peek();
                }
            }
        }
        return results;
    }
}
