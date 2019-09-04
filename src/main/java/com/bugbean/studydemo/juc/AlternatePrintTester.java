package com.bugbean.studydemo.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dugm
 * @description
 * @date 2019-09-03 19:56
 */
public class AlternatePrintTester {

	public static void main(String[] args) {

		Printer printer = new Printer();

		new Thread(() -> {
			for (int j = 1; j <= 10; j++) {
//				System.out.println("第" + j + "轮打印");
				printer.print5();
			}
		}, "AA").start();

		new Thread(() -> {
			for (int j = 1; j <= 10; j++) {
//				System.out.println("第" + j + "轮打印");
				printer.print10();
			}
		}, "BB").start();

		new Thread(() -> {
			for (int j = 1; j <= 10; j++) {
//				System.out.println("第" + j + "轮打印");
				printer.print15();
			}

		}, "CC").start();
	}
}

class Printer {
	private int num = 1;

	Lock lock = new ReentrantLock();
	Condition conditionA = lock.newCondition();
	Condition conditionB = lock.newCondition();
	Condition conditionC = lock.newCondition();


	public void print5() {
		lock.lock();
		try {
			while (num != 1) {
				conditionA.await();
			}

			for (int i = 1; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName() + "第" + i + "次打印");
			}
			conditionB.signal();
			num++;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void print10() {
		lock.lock();
		try {
			while (num != 2) {
				conditionB.await();
			}
			for (int i = 1; i <= 10; i++) {
				System.out.println(Thread.currentThread().getName() + "第" + i + "次打印");
			}
			conditionC.signal();
			num++;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void print15() {
		lock.lock();
		try {
			while (num != 3) {
				conditionC.await();
			}
			for (int i = 1; i <= 15; i++) {
				System.out.println(Thread.currentThread().getName() + "第" + i + "次打印");
			}
			conditionA.signal();
			num = num - 2;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}