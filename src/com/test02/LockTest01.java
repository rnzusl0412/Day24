package com.test02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest01 implements Runnable {
	private static final Lock lock = new ReentrantLock();
	private static final Condition condition = lock.newCondition();
	private static int time = 0;
	private final int step;

	public LockTest01(int step) {
		this.step = step;
	}

	@Override
	public void run() {
		lock.lock();
		try {
			while (time != step) {
				System.out.println("step : " + step + "---- time : " + time);
				condition.await();
			}
			time++;
			condition.signal();
			System.out.println("step : " + step + " -- condition.signal(); -- time : " + time);

		} catch (Exception e) {
			Thread.currentThread().interrupt();
		} finally {
			lock.unlock();

		}
	}

	public static void main(String[] args) {
		for (int i = 4; i >= 0; i--) {
			new Thread(new LockTest01(i)).start();
		}
	}
}
