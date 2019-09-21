package com.bugbean.studydemo.io;


import org.junit.Test;

import java.io.*;

/**
 * @author dugm
 * @description
 * @date 2019-09-19 16:44
 */
public class FrwTester {

	@Test
	public void test() {
		FileReader fileReader = null;
		try {
			File file = new File(getClass().getClassLoader().getResource("abc.txt").getFile());
			fileReader = new FileReader(file);
			int data;

			while ((data = fileReader.read()) != -1) {
				System.out.print((char) data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void test2() {
		FileReader fileReader = null;
		try {

			File file = new File(getClass().getClassLoader().getResource("abc.txt").getFile());
			fileReader = new FileReader(file);

			char[] chars = new char[5];

			int len;
			while ((len = fileReader.read(chars)) != -1) {
				for (int i = 0; i < len; i++) {
					System.out.print(chars[i]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void test3() {
		FileWriter fileWriter = null;
		FileReader fileReader = null;
		try {

			File file = new File("abc.txt");
			fileReader = new FileReader(file);

			File copyFile = new File("copy.txt");
			fileWriter = new FileWriter(copyFile);

			char[] chars = new char[5];

			int len;
			while ((len = fileReader.read(chars)) != -1) {
				fileWriter.write(chars, 0, len);
			}
		} catch (IOException e) {

		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testCopy() {
		long start = System.currentTimeMillis();
		copy("F:\\学习资料\\尚硅谷第38季公开课-快速入门JVM\\jvm.avi", "C:\\Users\\Administrator\\Desktop\\copy.avi");
		long end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
	}

	public void copy(String src, String dest) {
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {

			File file = new File(src);
			bufferedInputStream = new BufferedInputStream(new FileInputStream(file));

			File copyFile = new File(dest);
			bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(copyFile));

			byte[] bytes = new byte[1024];

			int len;
			while ((len = bufferedInputStream.read(bytes)) != -1) {
				bufferedOutputStream.write(bytes, 0, len);
			}
		} catch (IOException e) {

		} finally {
			if (bufferedInputStream != null) {
				try {
					bufferedInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bufferedOutputStream != null) {
				try {
					bufferedInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
