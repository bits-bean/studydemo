package com.bugbean.studydemo.io;

import java.io.*;

/**
 * @author dugm
 * @description
 * @date 2019-09-26 11:23
 */
public class IorwTest {
	public static void main(String[] args) {

		File file = new File("E:\\projects\\studydemo\\src\\main\\resources\\abc.txt");
		File copyFile = new File("E:\\projects\\studydemo\\src\\main\\resources\\abc_gbk.txt");

		try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "utf-8");
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream((copyFile)),"gbk")) {
			char[] chars = new char[1024];
			int lens;
			while ((lens = inputStreamReader.read(chars)) != -1) {
				outputStreamWriter.write(chars, 0, lens);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
