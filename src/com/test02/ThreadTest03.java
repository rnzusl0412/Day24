package com.test02;

import java.util.concurrent.*;

// newCachedThreadPool()
//여러 스레드에서 작업을 처리하지만, 만약 처리 종료된 스레드가 있으면, Thread를 재사용한다.
//60초 사용되지 않은 스레드는 삭제된다.
//단기간에 처리가 끝나는 작업을 대량으로 처리하는 경우 유용

public class ThreadTest03 implements Runnable {
	private int number;

	public ThreadTest03(int number) {
		this.number = number;
	}

	public void run() {
		System.out.println("Task" + number + "Start");

		try {
			Thread.sleep(333);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Task" + number + "End");

	}

	public static void main(String[] args) {
		ExecutorService ex = Executors.newCachedThreadPool();

		/*
		 * Thread.currentThread().getThreadGroup().list(); -> 
		 * 스레드 싫애하는 목록의 리턴
		 * ExecutorService를 취득한 경우에는 아직 작업처리 스레드가 없다. 
		 * 첫번째 작업을 전송했을때 작업처리 스레드 하나 생상 두전째
		 * 작업을 전송했을때 아직 처리가 끝나지 않았기 때문에 새로운 스레드를 만든다. 
		 * 세번째 작업을 제출 한 때에는 Task0 처리가 끝낫기 때문에
		 * 스레드는 생성되지 않는다.
		 */

		System.out.println("============================");
		System.out.println("Sending Tasks....");
		for (int i = 0; i < 3; i++) {
			ex.execute(new ThreadTest03(i));
			Thread.currentThread().getThreadGroup().list();
			try {
				Thread.sleep(333);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ex.shutdown();

	}
}
