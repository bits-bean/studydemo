package com.bugbean.studydemo.juc;

/**
 * @author dugm
 * @description
 * @date 2019-07-11 11:07
 */
public class TestCAS {
    public static void main(String[] args) {

        final Cas cas = new Cas();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean b = cas.compareAndSet(cas.getValue(), (int) (Math.random() * 101));
                    System.out.println(b);
                }
            }).start();
        }

    }
}

class Cas {
    private int value;

    public synchronized int getValue() {
        return value;
    }

    /**
     * 这里加锁的原因是模拟硬件提供的CAS方案
     * 在真实的操作中compareAndSwap是硬件级别的操作,可以看做是原子性的
     * jdk的原子类这一步也是native方法
     *
     * @param expectValue
     * @param newValue
     * @return
     */
    private synchronized int compareAndSwap(int expectValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectValue) {
            value = newValue;
        }
        return oldValue;
    }

    public boolean compareAndSet(int expectValue, int newValue) {
        return expectValue == compareAndSwap(expectValue, newValue);
    }
}
