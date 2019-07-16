package com.bugbean.studydemo.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author dugm
 * @description
 * @date 2019-07-11 15:50
 */
public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread1 myThread1 = new MyThread1();
        FutureTask<Integer> result = new FutureTask<>(myThread1);

        new Thread(result).start();
        Integer integer = result.get();
        System.out.println(integer);
        System.out.println("====================================================");
    }
}

class MyThread1 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }
}
