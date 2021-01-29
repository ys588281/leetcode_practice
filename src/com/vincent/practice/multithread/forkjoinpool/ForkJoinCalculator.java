package com.vincent.practice.multithread.forkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculator implements Calculator {

    private ForkJoinPool forkJoinPool;

    public ForkJoinCalculator() {
        this.forkJoinPool = new ForkJoinPool();
    }

    private static class SumTask extends RecursiveTask<Long> {
        private long[] numbers;
        private int from;
        private int to;

        public SumTask(long[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if (to - from <= 6) {
                long total = 0;
                for (int i = from; i <= to; i++) {
                    total += numbers[i];
                }
                return total;
            } else {
                int middle = from + (to - from) / 2;
                SumTask left = new SumTask(numbers, from, middle);
                SumTask right = new SumTask(numbers, middle + 1, to);
                left.fork();
                right.fork();
                return left.join() + right.join();
            }
        }
    }

    @Override
    public long sumUp(long[] numbers) {
        return forkJoinPool.invoke(new SumTask(numbers, 0, numbers.length - 1));
    }
}
