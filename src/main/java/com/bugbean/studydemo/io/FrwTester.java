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
	public void testCopy() throws FileNotFoundException {

		String src = "F:\\学习资料\\尚硅谷第38季公开课-快速入门JVM\\jvm.avi";
		String dest = "C:\\Users\\Administrator\\Desktop\\copy.avi";

				InputStream is = new BufferedInputStream(new FileInputStream(new File(src)));
//		InputStream is = new FileInputStream(new File(src));

				OutputStream os = new BufferedOutputStream(new FileOutputStream(new File(dest)));
//		OutputStream os = new FileOutputStream(new File(dest));

		long start = System.currentTimeMillis();
		copy(src, dest, is, os);
		long end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
	}

	public void copy(String src, String dest, InputStream inputStream, OutputStream outputStream) {
		try {
			byte[] bytes = new byte[8192];

			int len;
			while ((len = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, len);
			}
		} catch (IOException e) {

		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
