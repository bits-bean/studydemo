package com.bugbean.studydemo.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author dugm
 * @description
 * @date 2019-10-08 23:25
 */
public class OtherStreamTest {
	public static void main(String[] args) {

		try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

			while (true) {
				System.out.println("输入:");
				String inputStr = bufferedReader.readLine();
				if ("e".equalsIgnoreCase(inputStr) || "exit".equalsIgnoreCase(inputStr)) {
					System.out.println("程序结束");
					break;
				}
				System.out.println(inputStr.toUpperCase());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
