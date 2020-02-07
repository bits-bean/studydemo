package com.bugbean.studydemo.jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JConsoleThreadMonitoringTest {
    /**
     * 线程死循环演示
     */
    public static void createBusyThread() {
        new Thread(() -> {
            while (true) {

            }
        }, "testBusyThread").start();
    }

    /**
     * 线程等待演示
     */
    public static void createLockThread(final Object lock) {
        new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "testLockThread").start();
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br.readLine();
//        createBusyThread();
//        br.readLine();
//        Object lock = new Object();
//        createLockThread(lock);
        new Thread(new SynAddRunable(1, 2)).start();
        new Thread(new SynAddRunable(2, 1)).start();
    }

    /**
     * 线程死锁等待演示
     */
    static class SynAddRunable implements Runnable {
        int a, b;

        public SynAddRunable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }

        }
    }
}
