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
			System.out.println("\"������ t�� ���Ḧ ��ٸ��ϴ�.\"");
			t.join(); // ī��Ʈ�ٿ��� ����ɶ����� ��ٸ���.
			System.out.println("\"������ t�� ����Ǿ����ϴ�.\"");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
