package com.bugbean.studydemo.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dugm
 * @description
 * @date 2019-09-23 16:21
 */
public class Lianxi3 {
	public static void main(String[] args) throws IOException {

		markStr("D:\\Downloads\\商户公私钥.txt");

//		InputStreamReader
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
//		outputStreamWriter.write();
	}

	public static void markStr(String filePath) throws IOException {

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {

			HashMap<Character, Integer> map = new HashMap<>();

			int i;
			while ((i = bufferedReader.read()) != -1) {
				char c = (char) i;
				Integer count = map.get(c);
				if (count == null) {
					count = 0;
				}
				map.put(c, ++count);
			}

			map.remove("\n");

			bufferedWriter.newLine();
			bufferedWriter.write("统计如下");
			bufferedWriter.newLine();
			for (Map.Entry<Character, Integer> entry : map.entrySet()) {
				Character key = entry.getKey();
				String keyStr = "";
				if (key.equals('\n')) {
					keyStr = "换行符";
				} else if (key.equals('\t')) {
					keyStr = "制表符";
				} else if (key.equals('\r')) {
					keyStr = "回车";
				} else {
					keyStr = key.toString();
				}
				bufferedWriter.write(keyStr + ":" + entry.getValue());
				bufferedWriter.newLine();
			}

		}
	}
}
