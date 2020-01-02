package com.bugbean.studydemo.io;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author dugm
 * @description
 * @date 2019-10-12 15:58
 */
public class SocketTest {

	@Test
	public void client() throws IOException {
		InetAddress address = InetAddress.getByName("127.0.0.1");

		try (Socket socket = new Socket(address, 8888); OutputStream outputStream = socket.getOutputStream()) {
			outputStream.write("hello".getBytes());
		}

	}

	@Test
	public void server() throws IOException {

		try (ServerSocket serverSocket = new ServerSocket(8888); Socket socket = serverSocket.accept()) {
			InputStream inputStream = socket.getInputStream();
			byte[] bytes = new byte[1024];
			inputStream.read(bytes);
			System.out.println(new String(bytes));
		}
	}
}
