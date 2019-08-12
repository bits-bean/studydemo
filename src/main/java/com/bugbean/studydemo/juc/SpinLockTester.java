package com.bugbean.studydemo.juc;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author dugm
 * @description
 * @date 2019-08-12 16:57
 */
public class SpinLockTester {
	private AtomicReference<Thread> atomicThread = new AtomicReference<>();

	public void lock() {
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getName() + " come in");
		while (!atomicThread.compareAndSet(null, currentThread)) {}
	}

	public void unlock() {
		Thread currentThread = Thread.currentThread();

		System.out.println(currentThread.getName() + " unlock");

		atomicThread.compareAndSet(currentThread, null);
	}

	public static void main(String[] args) {
		SpinLockTester spinLockTester = new SpinLockTester();
		new Thread(() -> {
			spinLockTester.lock();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {

			}
			spinLockTester.unlock();
		}, "A").start();

		new Thread(() -> {
			spinLockTester.lock();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {

			}
			spinLockTester.unlock();
		}, "B").start();
	}

}
