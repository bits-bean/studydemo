package com.bugbean.studydemo.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dugm
 * @description
 * @date 2019-07-11 16:51
 */
public class TestProducerAndConsumerByLock {
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

class Clerkl {
    private int product = 0;

    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void get() {
        lock.lock();
        try {
            while (product >= 1) {
                System.out.println("产品已满!");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + ++product);
            condition.signalAll();
        } finally {
            lock.unlock();
        }


    }

    public void sale() {
        lock.lock();
        try {
            while (product <= 0) {
                System.out.println("缺货");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + --product);
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }
}

class Producerl implements Runnable {
    private Clerkl clerkl;

    public Producerl(Clerkl clerkl) {
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

class Consumerl implements Runnable {

    private Clerkl clerkl;

    public Consumerl(Clerkl clerkl) {
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
