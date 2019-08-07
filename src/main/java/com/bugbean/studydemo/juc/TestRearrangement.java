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
}
