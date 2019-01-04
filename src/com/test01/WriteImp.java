package com.test01;

import java.io.*;

public class WriteImp implements Runnable {

	private String text;

	public WriteImp() {

	}

	public void run() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
			writer.write(text);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setText(String text) {
		this.text = text;
	}
}
