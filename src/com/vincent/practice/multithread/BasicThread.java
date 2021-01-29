package com.vincent.practice.multithread;

public class BasicThread {

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread starts");
        }
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("MyRunnable starts");
        }
    }

    public static void main(String[] args) {
        System.out.println("before start the thread");
        MyThread t = new MyThread();
        t.start();

        MyRunnable r = new MyRunnable();
        r.run();
        new MyRunnable().run();
        r.run();
        new Thread(()->{
            System.out.println("functional programming");
        }).start();
        t.start();
    }
}
