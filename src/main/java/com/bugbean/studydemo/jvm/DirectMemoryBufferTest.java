package com.bugbean.studydemo.jvm;

import sun.misc.VM;

import java.nio.ByteBuffer;

public class DirectMemoryBufferTest {
    public static void main(String[] args) {
//        System.out.println("maxDirectMemory:" + VM.maxDirectMemory() / 1024 / 1024 + "MB");
//        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);
        int i = 0;
        while (true) {
            System.out.println(++i);
            new Thread(()-> {
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
