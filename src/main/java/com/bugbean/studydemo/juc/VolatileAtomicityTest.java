package com.bugbean.studydemo.juc;

/**
 * @author dugm
 * @description
 * @date 2019-08-05 16:34
 */
public class VolatileAtomicityTest {

	public static void main(String[] args) throws InterruptedException {

		Data data = new Data();

		for (int i = 0; i < 20; i++) {
			new Thread(() -> {
				for (int j = 0; j < 1000; j++) {
					data.increment();
				}
			}, "Thread--" + i).start();
		}

		while (Thread.activeCount() > 2) {
			Thread.yield();
		}

		System.out.println(data.getNumber());
	}
}
