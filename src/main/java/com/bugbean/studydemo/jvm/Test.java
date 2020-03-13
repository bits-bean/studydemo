package com.bugbean.studydemo.jvm;

import java.util.Random;

public class Test {
    public static void main(String[] args) throws InterruptedException {
//        int i = 2;
//        int j = 3;
//        int k = i + j;
//        new Test().test1();
//        int i = 0;
//        String str = "asdasda";
//        try {
//
//            while (true) {
//                str += str + new Random().nextInt(888888888) + new Random().nextInt(77777777);
//                str.intern();
//            }
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        Thread.sleep(Integer.MAX_VALUE);
        byte[] bytes = new byte[2* 1024 * 1024];
    }

    public void test1() {
        int a = 0;
        {
            int b = 0;
            b = a + 1;
        }
        int c = a + 1;
    }

    public void test2() {
        int a = 0;
        int c = a + 1;
        if (a == 1) {
            int b = 0;
            b = a + 1;
        } else {
            int e = 9;
            System.out.println();
        }
    }
}
