package com.bugbean.studydemo.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dugm
 * @description
 * @date 2019-07-11 9:54
 */
public class TestAtomicDemo {
    public static void main(String[] args) {
        AtomicDemo atomicDemo = new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(atomicDemo).start();
        }
    }
}

class AtomicDemo implements Runnable {

    private AtomicInteger sn = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {

        }

        System.out.println(Thread.currentThread().getName() + ":" + getSn());
    }

    public int getSn() {
        return sn.getAndIncrement();
    }
}