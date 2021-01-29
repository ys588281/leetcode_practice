package com.vincent.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class DesignPhoneDirectory379 {

    public static void main(String[] args) {

    }


}

class PhoneDirectory {

    int n;
    Queue<Integer> queue;
    boolean[] used;

    /** Initialize your data structure here
     @param n - The maximum numbers that can be stored in the phone directory. */

    public PhoneDirectory(int n) {
        this.n = n;
        this.queue = new LinkedList<>();
        this.used = new boolean[n];
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (!this.queue.isEmpty()) return -1;
        int r = queue.peek();
        this.used[r - 1] = true;
        queue.poll();
        return r;
    }

    public boolean check(int number) {
        return this.used[number - 1];
    }

    public void release(int number) {
        this.used[number - 1] = false;
        this.queue.add(number);
    }
}
