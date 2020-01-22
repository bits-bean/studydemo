package com.bugbean.studydemo.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

/**
 * 1通道
 * 2缓冲区
 * 3选择器
 */
public class TestBlocking {

    //客户端
    @Test
    public void client() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        FileChannel fileChannel = FileChannel.open(Paths.get("123.png"));
        while ((fileChannel.read(buffer)) != -1) {
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }
        socketChannel.shutdownOutput();
        int len = 0;
        while ((len = socketChannel.read(buffer)) != -1) {
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, len));
            buffer.clear();
        }

        fileChannel.close();
        socketChannel.close();

    }

    @Test
    public void server() throws IOException {

        Map<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(null,null);
        objectObjectHashMap.put(1,1);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9898));

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        FileChannel fileChannel = FileChannel.open(Paths.get("456.png"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        SocketChannel socketChannel = serverSocketChannel.accept();
        while (socketChannel.read(buffer) != -1) {
            buffer.flip();
            fileChannel.write(buffer);
            buffer.clear();
        }

        buffer.put("接收成功！".getBytes());
        buffer.flip();
        socketChannel.write(buffer);

        fileChannel.close();
        socketChannel.close();
        serverSocketChannel.close();
    }
}
