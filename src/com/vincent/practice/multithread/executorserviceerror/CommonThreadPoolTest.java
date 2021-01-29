package com.vincent.practice.multithread.executorserviceerror;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CommonThreadPoolTest {

    public static ExecutorService fixPoolExcutor = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //计算 1+2+...+10  的结果
        CountTaskCallable task = new CountTaskCallable(1,10);
        //提交主人翁
        Future<Integer> future = fixPoolExcutor.submit(task);
        System.out.println("计算的结果："+future.get());
    }
}

class CountTaskCallable implements Callable<Integer> {

    //设置阀值为2
    private static final int THRESHOLD = 5;
    private int start;
    private int end;

    public CountTaskCallable(int start, int end) {
        super();
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        //判断任务的大小是否超过阀值
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            System.out.println("切割的任务："+start+"加到"+end+"   执行此任务的线程是 "+Thread.currentThread().getName());
            int middle = (start + end) / 2;

            CountTaskCallable leftTaskCallable = new CountTaskCallable(start, middle);
            CountTaskCallable rightTaskCallable = new CountTaskCallable(middle + 1, end);
            // 将子任务提交到线程池中
            Future<Integer> leftFuture = CommonThreadPoolTest.fixPoolExcutor.submit(leftTaskCallable);
            Future<Integer> rightFuture = CommonThreadPoolTest.fixPoolExcutor.submit(rightTaskCallable);
            //阻塞等待子任务的执行结果
            int leftResult = leftFuture.get();
            int rightResult = rightFuture.get();
            // 合并子任务的执行结果
            sum = leftResult + rightResult;

        }
        return sum;
    }

}
