package com.bugbean.studydemo.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dugm
 * @description
 * @date 2019-08-06 14:47
 */
public class AtomicData {
	private AtomicInteger number = new AtomicInteger(0);

	public void increment() {
		number.incrementAndGet();
	}

	public int getNumber() {
		return number.get();
	}

	public void setNumber(int number) {
		this.number.set(number);
	}
}