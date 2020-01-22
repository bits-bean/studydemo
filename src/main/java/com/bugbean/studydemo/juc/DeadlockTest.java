package com.bugbean.studydemo.juc;

public class DeadlockTest {
    public static void main(String[] args) {
        Object lockA = new Object();
        Object lockB = new Object();

        Runnable taskA = () -> {
            synchronized (lockA) {
                System.out.println("线程a持有lockA");
                System.out.println("线程a尝试获取lockB");
                synchronized (lockB) {
                    System.out.println("线程a持有lockB");
                }
            }
        };

        Runnable taskB = () -> {
            synchronized (lockB) {
                System.out.println("线程b持有lockB");
                System.out.println("线程b尝试获取lockA");

                synchronized (lockA) {
                    System.out.println("线程b持有lockA");
                }
            }
        };

        new Thread(taskA).start();
        new Thread(taskB).start();

        //jps
    }
}
