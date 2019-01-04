package com.test02;

import java.util.concurrent.*;

public class ThreadTest01 implements Runnable {
	private String tab = "";

	public ThreadTest01(int tab) {
		for (int i = 0; i <= tab; i++) {
			this.tab += "  ";

		}
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(tab + i);
			try {
				Thread.sleep(333);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService ex = Executors.newSingleThreadExecutor();
		System.out.println("[Sending Tasks....]");

		for (int i = 0; i < 3; i++) {
			ex.execute(new ThreadTest01(i * 3));
		}
		System.out.println("[Finish Sending!]");
		ex.shutdown();
//		List<Runnable> all = ex.shutdownNow();
//		for (Runnable r : all) {
//			System.out.println(r.toString());
//		}
		System.out.println("[ShutDown]");
	}
}
