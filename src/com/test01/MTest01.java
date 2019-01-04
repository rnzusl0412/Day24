package com.test01;

public class MTest01 extends Thread {
	public void run() {
		for (int i = 3; i >= 0; i--) {
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		MTest01 t = new MTest01();
		t.start();

		try {
			System.out.println("\"스레드 t의 종료를 기다립니다.\"");
			t.join(); // 카운트다운이 종료될때까지 기다린다.
			System.out.println("\"스레드 t가 종료되었습니다.\"");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
