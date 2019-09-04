package com.bugbean.studydemo.juc;

/**
 * @author dugm
 * @description
 * @date 2019-09-03 17:31
 */
public class BlockingQueueTester {
	public static void main(String[] args) throws InterruptedException {
//		BlockingQueue
		Object lock = new Object();
		lock.wait();
	}
}
