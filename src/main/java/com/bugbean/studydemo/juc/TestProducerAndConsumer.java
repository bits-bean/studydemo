package com.bugbean.studydemo.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dugm
 * @description
 * @date 2019-07-11 16:51
 */
public class TestProducerAndConsumer {
    public static void main(String[] args) {
        Clerkl clerkl = new Clerkl();
        Producerl producerl = new Producerl(clerkl);
        Consumerl consumerl = new Consumerl(clerkl);
        new Thread(producerl, "生产者A").start();
        new Thread(consumerl, "消费者B").start();
        new Thread(producerl, "生产者C").start();
        new Thread(consumerl, "消费者D").start();
    }
}

class Clerk {
    private int product = 0;

    private Lock lock = new ReentrantLock();

    public synchronized void get() {
        while (product >= 1) {
            System.out.println("产品已满!");
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + ++product);
        this.notifyAll();

    }

    public synchronized void sale() {
        while (product <= 0) {
            System.out.println("缺货");
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + --product);
        this.notifyAll();
    }
}

class Producer implements Runnable {
    private Clerkl clerkl;

    public Producer(Clerkl clerkl) {
        this.clerkl = clerkl;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
            System.out.println("生产" + (i + 1) + "次");
            clerkl.get();
        }
    }
}

class Consumer implements Runnable {

    private Clerkl clerkl;

    public Consumer(Clerkl clerkl) {
        this.clerkl = clerkl;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("消费" + (i + 1) + "次");
            clerkl.sale();
        }

    }
}
