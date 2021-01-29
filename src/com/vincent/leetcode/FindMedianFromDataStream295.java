package com.vincent.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream295 {

    public static void main(String[] args) {

    }
}

class MedianFinder {
    /** initialize your data structure here. */
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public MedianFinder() {

    }

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        }
        return maxHeap.peek();

    }
}
