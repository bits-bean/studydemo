package com.bugbean.studydemo.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author dugm
 * @description
 * @date 2019-08-16 16:07
 */
public class ReadWriteLockDemo {

	public static void main(String[] args) {
		Cache cache = new Cache();

		for (int i = 1; i <= 5; i++) {
			final int tempI = i;
			new Thread(() -> {
				cache.put(tempI + "", tempI + "");
			}, String.valueOf(i)).start();
		}

		for (int i = 1; i <= 5; i++) {
			final int tempI = i;
			new Thread(() -> {
				cache.get(tempI + "");
			}, String.valueOf(i)).start();
		}

	}
}

class Cache {
	private volatile Map<String, Object> map = new HashMap<>();
	private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

	public void put(String key, Object value) {
		rwLock.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + " 正在写入:" + key);
			Thread.sleep(300);
			map.put(key, value);
			System.out.println(Thread.currentThread().getName() + " 写入完成");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			rwLock.writeLock().unlock();
		}

	}

	public Object get(String key) {
		rwLock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + " 正在读取");
			Thread.sleep(300);
			Object value = map.get(key);
			System.out.println(Thread.currentThread().getName() + " 读取完成" + value);
			return value;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			rwLock.readLock().unlock();
		}
		return null;
	}
}
