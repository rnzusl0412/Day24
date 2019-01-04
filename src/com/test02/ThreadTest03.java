package com.test02;

import java.util.concurrent.*;

// newCachedThreadPool()
//���� �����忡�� �۾��� ó��������, ���� ó�� ����� �����尡 ������, Thread�� �����Ѵ�.
//60�� ������ ���� ������� �����ȴ�.
//�ܱⰣ�� ó���� ������ �۾��� �뷮���� ó���ϴ� ��� ����

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
		 * ������ �Ⱦ��ϴ� ����� ����
		 * ExecutorService�� ����� ��쿡�� ���� �۾�ó�� �����尡 ����. 
		 * ù��° �۾��� ���������� �۾�ó�� ������ �ϳ� ���� ����°
		 * �۾��� ���������� ���� ó���� ������ �ʾұ� ������ ���ο� �����带 �����. 
		 * ����° �۾��� ���� �� ������ Task0 ó���� ������ ������
		 * ������� �������� �ʴ´�.
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
