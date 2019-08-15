package com.bugbean.studydemo.juc;

/**
 * @author dugm
 * @description
 * @date 2019-08-12 14:07
 */
public class ReentryTester {
	public static void main(String[] args) {
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
