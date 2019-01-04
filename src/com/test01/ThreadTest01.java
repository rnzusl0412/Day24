package com.test01;

public class ThreadTest01 implements Runnable {

	public static void main(String[] args) {
		ThreadTest01 manager = new ThreadTest01();
		Thread managerThread = new Thread(manager);
		managerThread.start();
	}

	public void run() {
		System.out.println("파일을 복사합니다.");
		ReadImp reader = new ReadImp();
		WriteImp writer = new WriteImp();
		Thread readerThread = new Thread(reader);
		Thread writerThread = new Thread(writer);
		readerThread.start();

		try {
			System.out.println("읽기 시작");
			readerThread.join();
			System.out.println("읽기 끝");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		writer.setText(reader.getText());
		writerThread.start();
		try {
			System.out.println("파일 쓰기 시작");
			readerThread.join();
			System.out.println("파일 쓰기 끝");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("파일을 복사했습니다.");
	}

}
