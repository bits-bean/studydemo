package com.bugbean.studydemo.juc;

/**
 * @author dugm
 * @description
 * @date 2019-08-15 11:42
 */
public class AccountTester {
	public static void main(String[] args) {
		Account account = new Account();
		new Thread(() -> {
			for (int i = 0; i < 3; i++) {
				account.deposit(1000);
			}
		}).start();

		new Thread(() -> {
			for (int i = 0; i < 3; i++) {
				account.deposit(1000);
			}
		}).start();

//		while (Thread.activeCount() > 2) {}
//
//		System.out.println(account.getBalance());
	}
}

class Account {
	private Integer balance = 0;

	public /*synchronized*/ void deposit(int money) {
		balance += money;
		System.out.println(balance);
	}

	public Integer getBalance() {
		return balance;
	}
}
