package com.bugbean.studydemo.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dugm
 * @description
 * @date 2019-07-11 16:42
 */
public class TestLock {
    public static void main(String[] args) {
        YuThread yuThread = new YuThread();
        new Thread(yuThread, "1号窗口").start();
        new Thread(yuThread, "2号窗口").start();
        new Thread(yuThread, "3号窗口").start();
    }
}

class YuThread implements Runnable {

    private int tick = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {

                if (tick > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {

                    }
                    System.out.println(Thread.currentThread().getName() + "完成售票,余票为" + --tick);
                }
            } finally {
                lock.unlock();
            }
        }
    }
}