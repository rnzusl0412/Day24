package com.test02;

import java.util.concurrent.*;

public class ThreadTest02 implements Runnable {
	private String tab = "";

	public ThreadTest02(int tab) {
		for (int i = 0; i <= tab; i++) {
			this.tab += "  ";

		}
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(tab + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService ex = Executors.newFixedThreadPool(7);
		System.out.println("[Sending Tasks....]");

		for (int i = 0; i < 11; i++) {
			ex.execute(new ThreadTest02(i * 3));
		}
		System.out.println("[Finish Sending!]");
		ex.shutdown();
		System.out.println("[ShutDown]");
	}
}
