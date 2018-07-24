package com.lzt.order.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * TCP/IP的NIO非阻塞方式 客户端
 */
public class ClientTwo {

	// 创建缓冲区
	private ByteBuffer buffer = ByteBuffer.allocate(512);
	// 访问服务器

	public void query(String host, int port) throws IOException {
		InetSocketAddress address = new InetSocketAddress(InetAddress.getByName(host), port);
		SocketChannel socket = null;
		byte[] bytes = new byte[512];
		while (true) {
			try {
				System.in.read(bytes);
				socket = SocketChannel.open();
				socket.connect(address);
				buffer.clear();
				buffer.put(bytes);
				buffer.flip();
				socket.write(buffer);
				buffer.clear();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (socket != null) {
					socket.close();
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new ClientTwo().query("localhost", 9099);

	}
}
