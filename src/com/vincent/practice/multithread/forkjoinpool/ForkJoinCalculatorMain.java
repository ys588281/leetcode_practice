package com.vincent.practice.multithread.forkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

public class ForkJoinCalculatorMain {

    public static void main(String[] args) throws Exception {
//        long[] numbers = LongStream.rangeClosed(1, 1000).toArray();
//        Calculator calculator = new ForkJoinCalculator();
//        System.out.println(calculator.sumUp(numbers));

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(new MyRecursiveAction(0, 1000));
        forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);

        forkJoinPool.shutdown();

    }
}
