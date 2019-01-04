package com.test01;

import java.util.*;
import java.util.Map.Entry;

public class MTest02 {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Map<Thread, StackTraceElement[]> maps = Thread.getAllStackTraces();
		Iterator<Entry<Thread, StackTraceElement[]>> itr = maps.entrySet().iterator();

		while (itr.hasNext()) {
			Map.Entry entry = (Entry) itr.next();
			Thread thread = (Thread) entry.getKey();
			StackTraceElement[] trace = (StackTraceElement[]) entry.getValue();
			System.out.println(thread);
			for (int i = 0; i < trace.length; i++) {
				System.out.println(trace[i]);
			}
			System.out.println();
		}
	}
}
