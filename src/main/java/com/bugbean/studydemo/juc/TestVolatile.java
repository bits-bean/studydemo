package com.bugbean.studydemo.juc;

/**
 * @author dugm
 * @description
 * @date 2019-07-10 17:47
 */
public class TestVolatile {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        new Thread(threadDemo).start();

        while (true) {
            synchronized (threadDemo) {
                if (threadDemo.isFlag()) {
                    System.out.println("---------------");
                    break;
                }
            }
        }
    }
}


class ThreadDemo implements Runnable {

    private boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {

        }

        flag = true;
        System.out.println("flag=" + isFlag());
    }

    public boolean isFlag() {
        return flag;
    }
}