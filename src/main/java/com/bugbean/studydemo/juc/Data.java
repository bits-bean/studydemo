package com.bugbean.studydemo.juc;

/**
 * @author dugm
 * @description
 * @date 2019-08-05 17:34
 */
public class Data {
	private volatile int number = 0;

	public void increment() {
    	number++;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
