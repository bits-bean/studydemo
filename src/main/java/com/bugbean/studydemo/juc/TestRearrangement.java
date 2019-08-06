package com.bugbean.studydemo.juc;

/**
 * @author dugm
 * @description
 * @date 2019-08-06 15:38
 */
public class TestRearrangement {

	private int a = 0;
	private boolean flag = false;

	public void method1() {
		a = 1;
		flag = true;
	}

	public void method2() {
		if (flag) {
			a = a + 5;
			System.out.println("a=" + a);
		}
	}

	public static void main(String[] args) {

		TestRearrangement test = new TestRearrangement();

		new Thread(() -> {
			test.method1();
		}).start();

		for (int i = 0; i < 10000; i++) {
			new Thread(() -> {
				test.method2();
			}).start();
		}

	}

}
