package com.bugbean.studydemo.juc;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author dugm
 * @description
 * @date 2019-08-10 12:37
 */
public class ABATester {
	public static void main(String[] args) {
		int v = 1;
		int initStamp = 0;
		AtomicStampedReference<Integer> i = new AtomicStampedReference<>(v, initStamp);

		//获取v值和初始版本号
		Integer expectedReference = i.getReference();
		int expectedStamp = i.getStamp();
		//开启线程T对V值修改两次
		new Thread(() -> {
			Integer expectedReference1 = i.getReference();
			int newReference1 = expectedReference1 + 1;
			int expectedStamp1 = i.getStamp();
			int newStamp1 = expectedStamp1 + 1;
			boolean result1 = i.compareAndSet(expectedReference1, newReference1, expectedStamp1, newStamp1);
			System.out.println(
					"线程" + Thread.currentThread().getName() + "第一次修改" + result1 + ",结果为" + i.getReference() + ",版本号为"
							+ i.getStamp());

			Integer expectedReference2 = i.getReference();
			int expectedStamp2 = i.getStamp();
			int newStamp2 = expectedStamp2 + 1;
			boolean result2 = i.compareAndSet(expectedReference2, 1, expectedStamp2, newStamp2);
			System.out.println(
					"线程" + Thread.currentThread().getName() + "第二次修改" + result2 + ",结果为" + i.getReference() + ",版本号为"
							+ i.getStamp());
		}, "T").start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}

		int newReference = expectedReference + 1;
		int newStamp = expectedStamp + 1;
		boolean result = i.compareAndSet(expectedReference, newReference, expectedStamp, newStamp);

		System.out.println(
				"线程" + Thread.currentThread().getName() + "修改" + result + ",结果为" + i.getReference() + ",版本号为" + i
						.getStamp());
	}
}
