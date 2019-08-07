package com.bugbean.studydemo.juc;

/**
 * @author dugm
 * @description
 * @date 2019-08-07 13:50
 */
public class Singleton {

	private volatile static Singleton instance;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
