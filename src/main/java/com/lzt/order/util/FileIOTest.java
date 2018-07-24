package com.lzt.order.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileIOTest {

	static String word2048 = "abcdefghijabcdefabcdghijabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijabcdefabcdghijabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijabcdefabcdghijabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijabcdefabcdghijabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmno\n";

	static String word1024 = "abcdefghijabcdefabcdghijabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmnoabcdefghijklmno\n";

	static String wordtmp = "abcdef\n";

	// FileOutputStream的写入方式类似，在此略
	static void writeBuffer(File file) throws IOException {
		long timestart = System.currentTimeMillis();
		FileOutputStream fos = new FileOutputStream(file);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
		int i = 1000000;
		while (i > 0) {
			writer.write(word2048);
			i--;
		}
		writer.close();
		fos.close();
		long timeend = System.currentTimeMillis();
		System.out.println(timeend - timestart);
	}

	static void byteBuffer(File file) throws IOException {
		long timestart = System.currentTimeMillis();
		FileOutputStream fos = new FileOutputStream(file);
		FileChannel fc = fos.getChannel();
		// 此数字可优化
		int times = 100;
		// word2048为字符串常量，刚好4800个字节
		byte[] datas = word2048.getBytes();
		ByteBuffer bbuf = ByteBuffer.allocate(datas.length * times);
		int i = 10000;
		while (i > 0) {
			for (int j = 0; j < times; j++) {
				bbuf.put(datas);
			}
			bbuf.flip();
			fc.write(bbuf);
			bbuf.clear();
			i--;
		}
		long timeend = System.currentTimeMillis();
		System.out.println(timeend - timestart);
	}

	static void fileChannel(File file) throws IOException {
		long timestart = System.currentTimeMillis();
		FileOutputStream fos = new FileOutputStream(file);
		FileChannel fc = fos.getChannel();
		ByteBuffer bbuf = ByteBuffer.allocateDirect(1024);
		long value = 10 * 1024 * 1024;
		// 为什么不一步到位？直接将position设置10G
		for (int i = 1; i < 1025; i = i * 2) {
			bbuf.put((byte) 1);
			bbuf.flip();
			fc.position(i * value);
			fc.write(bbuf);
			bbuf.clear();
		}
		fc.close();
		fos.close();
		long timeend = System.currentTimeMillis();
		System.out.println(timeend - timestart);
	}

	static void mappedByteBuffer(File file) throws IOException {
		long timestart = System.currentTimeMillis();
		// 必须采用RandomAccessFile，并且是rw模式
		RandomAccessFile acf = new RandomAccessFile(file, "rw");
		FileChannel fc = acf.getChannel();
		byte[] bs = word2048.getBytes();
		int len = bs.length * 1000;
		long offset = 0;
		int i = 1000000;
		while (i > 0) {
			MappedByteBuffer mbuf = fc.map(FileChannel.MapMode.READ_WRITE, offset, len);
			for (int j = 0; j < 1000; j++) {
				mbuf.put(bs);
			}
			offset = offset + len;
			i = i - 1000;
		}
		fc.close();
		long timeend = System.currentTimeMillis();
		System.out.println(timeend - timestart);
	}

	static void readByFis(File file) throws IOException {
		long timestart = System.currentTimeMillis();
		InputStream is = new FileInputStream(file);
		byte[] buff = new byte[4096];
		long counts = 0;
		int offset = 0;
		while ((offset = is.read(buff)) != -1) {
			String test = new String(buff);
			System.out.println(test);
		}
		is.close();
		long timeend = System.currentTimeMillis();
		System.out.println(timeend - timestart);
	}

	static void readByBuffer(File file) throws IOException {
		long timestart = System.currentTimeMillis();
		FileInputStream fileInputStream = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fileInputStream);
		BufferedReader br = new BufferedReader(isr);
		String lineTxt = null;
		while ((lineTxt = br.readLine()) != null) {
			System.out.println(lineTxt);;
		}
		br.close();
		isr.close();
		fileInputStream.close();
		long timeend = System.currentTimeMillis();
		System.out.println(timeend - timestart);
	}

	static void readByBos(File file) throws Exception {
		long timestart = System.currentTimeMillis();
	    int offset = 0;
		BufferedInputStream bos = new BufferedInputStream(new FileInputStream(file));
	    byte[] buff = new byte[1024];
	    while((offset= bos.read(buff)) != -1) {
	    	String test = new String(buff);
			System.out.println(test);
	    }
	    long timeend = System.currentTimeMillis();
		System.out.println(timeend - timestart);
	}

	static void test() {
		long timestart = System.currentTimeMillis();
		long k = 0;
		for (int i = 0; i < 10000000; i++) {
			k = k + i;
		}
		long timeend = System.currentTimeMillis();
		System.out.println(timeend - timestart);
		System.out.println(k);
	}

	public static void main(String args[]) throws Exception {
		File file = new File("/Users/xupeng/Documents/testdata/iotest/208800000000_transaction_20180719.txt");
		readByBos(file);
	}

}
