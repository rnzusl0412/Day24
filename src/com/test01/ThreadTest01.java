package com.test01;

public class ThreadTest01 implements Runnable {

	public static void main(String[] args) {
		ThreadTest01 manager = new ThreadTest01();
		Thread managerThread = new Thread(manager);
		managerThread.start();
	}

	public void run() {
		System.out.println("������ �����մϴ�.");
		ReadImp reader = new ReadImp();
		WriteImp writer = new WriteImp();
		Thread readerThread = new Thread(reader);
		Thread writerThread = new Thread(writer);
		readerThread.start();

		try {
			System.out.println("�б� ����");
			readerThread.join();
			System.out.println("�б� ��");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		writer.setText(reader.getText());
		writerThread.start();
		try {
			System.out.println("���� ���� ����");
			readerThread.join();
			System.out.println("���� ���� ��");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("������ �����߽��ϴ�.");
	}

}
