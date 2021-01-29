package com.vincent.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAStream703 {

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3));// returns 4
        System.out.println(kthLargest.add(5));// returns 5
        System.out.println(kthLargest.add(10));// returns 5
        System.out.println(kthLargest.add(9));// returns 8
        System.out.println(kthLargest.add(4));// returns 8
    }

}

class KthLargest {
    int size = 0;
    PriorityQueue<Integer> priorityQueue = null;

    public KthLargest(int k, int[] nums) {
        this.size = k;
        this.priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int num : nums) {
            this.priorityQueue.offer(num);
            if (this.priorityQueue.size() > this.size) {
                this.priorityQueue.poll();
            }
        }
    }

    public int add(int val) {
        this.priorityQueue.offer(val);
        if (this.priorityQueue.size() > size) {
            this.priorityQueue.poll();
        }
        return this.priorityQueue.peek();
    }
}
