package com.vincent.practice.multithread.executorservice;

import java.util.stream.LongStream;

public class CommonThreadPoolTest {

    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 1000).toArray();
        Calculator calculator = new ExecutorServiceCalculator();
        System.out.println(calculator.sumUp(numbers));
    }
}
