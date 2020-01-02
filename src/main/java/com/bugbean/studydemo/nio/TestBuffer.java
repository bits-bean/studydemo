package com.bugbean.studydemo.nio;

import java.nio.ByteBuffer;

public class TestBuffer {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        String str = "abc";
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();
        System.out.println((char) byteBuffer.get());

        ByteBuffer buf = ByteBuffer.allocateDirect(1024);
        System.out.println(buf.isDirect());
    }
}
