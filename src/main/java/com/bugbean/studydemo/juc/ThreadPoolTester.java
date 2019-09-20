package com.bugbean.studydemo.juc;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dugm
 * @description
 * @date 2019-09-06 22:01
 */
public class ThreadPoolTester {
	public static void main(String[] args) {
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 500L, TimeUnit.SECONDS,
				new LinkedBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

		//		ExecutorService executorService = Executors.newCachedThreadPool();
		//		ExecutorService executorService = Executors.newSingleThreadExecutor();
		//		ExecutorService executorService = Executors.newFixedThreadPool(100);
		//
		//		executorService.execute();
		//
		//		threadPoolExecutor.submit();
		//		threadPoolExecutor.execute();
		//
		//		public static ExecutorService newSingleThreadExecutor (ThreadFactory threadFactory){
		//			return new Executors.FinalizableDelegatedExecutorService(
		//					new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(),
		//							threadFactory));
		//		}

		Lock lock = new ReentrantLock();
		Condition conditionA = lock.newCondition();
		Condition conditionB = lock.newCondition();
		Condition conditionC = lock.newCondition();
		conditionA.signal();
	}
}
