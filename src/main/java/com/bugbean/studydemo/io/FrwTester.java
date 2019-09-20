package com.bugbean.studydemo.io;


import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
}
