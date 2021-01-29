package com.vincent.practice.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Callable {

    public static class MyCallable implements java.util.concurrent.Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(1000);
            return 2;
        }
    }

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        MyCallable myCallable = new MyCallable();
        Future<Integer> future = executorService.submit(myCallable);
        System.out.println(future.get());
    }
}
