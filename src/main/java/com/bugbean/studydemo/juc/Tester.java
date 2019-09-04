package com.bugbean.studydemo.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tester {

	private Lock lock = new ReentrantLock();

	public synchronized void method1() {
		System.out.println("method1");
	}

	public void method2() {
		lock.lock();
		System.out.println("method2");
		lock.unlock();
	}

	public void method3() {
		synchronized (this) {
			System.out.println("method3");
		}
	}

	public static void main(String[] args) {
	}
}