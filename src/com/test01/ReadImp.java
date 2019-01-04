package com.test01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadImp implements Runnable {

	public String text;

	public ReadImp() {
		super();
	}

	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
			String line;
			StringBuffer tmp = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				tmp.append(line+"\n"); // StringBuffer를 쓴 이유는 append가 있기 때문
			}
			reader.close();
			text = tmp.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getText() {
		return text;
	}

}