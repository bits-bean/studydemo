package com.bugbean.studydemo.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dugm
 * @description
 * @date 2019-08-12 14:07
 */
public class ReentryTester {
	public static void main(String[] args) {

		ReentrantLock lock = new ReentrantLock();
		lock.lock();
		try {
			System.out.println("获取第一把锁");
			lock.lock();
			try {
				System.out.println("获取第二把锁");
			} finally {
				lock.unlock();
			}
		} finally {
			lock.unlock();
		}

		Phone phone = new Phone();
		new Thread(() -> {
			phone.sendSMS();
		}, "T1").start();

		new Thread(() -> {
			phone.sendSMS();
		}, "T2").start();
	}
}

class Phone {
	public synchronized void sendSMS() {
		synchronized(this.getClass()){

		}
		System.out.println(Thread.currentThread().getName() + " sendSMS");
		sendEmail();
	}

	public synchronized void sendEmail() {
		System.out.println(Thread.currentThread().getName() + " sendEmail");
	}
}
