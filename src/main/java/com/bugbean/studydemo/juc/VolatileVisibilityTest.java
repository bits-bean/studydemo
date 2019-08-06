package com.bugbean.studydemo.juc;

public class VolatileVisibilityTest {
    public static void main(String[] args) {

        Data data = new Data();

        //线程T更新number的值
        new Thread(() -> {
            try {
                //先睡3秒，让main线程读取到number的原始值
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.setNumber(100);
            System.out.println(Thread.currentThread().getName() + ": 修改number的值为" + data.getNumber());
        }, "T").start();

        //线程main读取number的值，如果线程main能感知到线程T修改了number的值，将会结束循环，否则一直在死循环中
        while (data.getNumber() == 0) {}
        System.out.println(Thread.currentThread().getName() + ": 结束循环，number的值已变为" + data.getNumber());

    }

}

