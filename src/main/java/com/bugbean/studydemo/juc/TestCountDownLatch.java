package com.bugbean.studydemo.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author dugm
 * @description 闭锁
 * @date 2019-07-11 15:35
 */
public class TestCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        MyThread myThread = new MyThread(countDownLatch);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            new Thread(myThread).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {

        }
        long end = System.currentTimeMillis();

        System.out.println("耗时:" + (end - start));
    }
}

class MyThread implements Runnable {

    private CountDownLatch latch;

    public MyThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public synchronized void run() {
        try {
            for (int i = 0; i < 50000; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        } finally {
            latch.countDown();
        }
    }
}
