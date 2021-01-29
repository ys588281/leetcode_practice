package com.vincent.practice.multithread.forkjoinpool;

import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {

    private static final int MAX = 5;
    private int start;
    private int end;

    public MyRecursiveAction(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start < MAX) {
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + " i value : " + i);
            }
        } else {
            int middle = start + (end - start) / 2;
            MyRecursiveAction left = new MyRecursiveAction(start, middle);
            MyRecursiveAction right = new MyRecursiveAction(middle, end);
            left.fork();
            right.fork();
        }
    }
}
