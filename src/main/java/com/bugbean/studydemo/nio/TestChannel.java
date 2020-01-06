package com.bugbean.studydemo.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestChannel {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("abc.txt");
        FileOutputStream fos = new FileOutputStream("abc1.txt");

        //获取通道
        FileChannel fisChannel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();

        //分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1);

        while (fisChannel.read(buf) != -1) {
            buf.flip();
            fosChannel.write(buf);
            buf.clear();
        }

        fisChannel.close();
        fosChannel.close();
        fis.close();
        fos.close();
    }

    @Test
    public void test1() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("abc.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("abcqwe.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE, StandardOpenOption.CREATE_NEW);

        MappedByteBuffer inMappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedByteBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        byte[] dst = new byte[inMappedByteBuffer.limit()];
        inMappedByteBuffer.get(dst);
        outMappedByteBuffer.put(dst);

    }
}