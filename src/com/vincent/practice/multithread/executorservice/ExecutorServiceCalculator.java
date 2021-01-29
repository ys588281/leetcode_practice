package com.vincent.practice.multithread.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceCalculator implements Calculator {

    private int parallism;
    private ExecutorService executorService;

    public ExecutorServiceCalculator() {
        parallism = Runtime.getRuntime().availableProcessors();
        System.out.println(parallism);
        executorService = Executors.newFixedThreadPool(parallism);
    }

    private static class SumTask implements Callable<Long> {

        private long[] numbers;
        private int from;
        private int to;

        public SumTask(long[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call() throws Exception {
            long total = 0L;
            for (int i = from; i <= to; i++) {
                total += numbers[i];
            }
            return total;
        }
    }

    @Override
    public long sumUp(long[] numbers) {
        List<Future<Long>> results = new ArrayList<>();
        int part = numbers.length / parallism;

        for (int i = 0; i < numbers.length; i++) {
            int from = i * part;
            int to = (i == parallism - 1) ? numbers.length - 1 : (i + 1) * part - 1;
            results.add(executorService.submit(new SumTask(numbers, from, to)));
        }

        long res = 0;
        for (Future<Long> f : results) {
            try {
                res += f.get();
            } catch (Exception e) {

            }

        }
        return res;
    }
}
