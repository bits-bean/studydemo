package com.bugbean.studydemo.troubleshooting;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CountDownLatch countDownLatch = new CountDownLatch(2);


        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            countDownLatch.countDown();
            return 1;
        });
        new Thread(futureTask).start();

        FutureTask<Integer> futureTask2 = new FutureTask<>(() -> {
            countDownLatch.countDown();
            return 1;
        });
        new Thread(futureTask2).start();

        countDownLatch.await();
        Integer r1 = futureTask.get();
        Integer r2 = futureTask.get();

        int r = r1 + r2;
        System.out.println(r);
    }
}
