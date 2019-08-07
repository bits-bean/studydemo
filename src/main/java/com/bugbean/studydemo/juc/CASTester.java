package com.bugbean.studydemo.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dugm
 * @description
 * @date 2019-08-07 15:09
 */
public class CASTester {
	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger();
		System.out.println("atomicInteger.incrementAndGet() = " + atomicInteger.incrementAndGet());
	}
}
