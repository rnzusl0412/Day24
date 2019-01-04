package com.test02;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class AtomicTest01 {
	public static void main(String[] args) {
		long[] longArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
				, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
				, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 };
		LongAdder adder = new LongAdder();
		LongAdder count = new LongAdder();
		for (long longValue : longArray) {
			adder.add(longValue);
			count.increment();
		}
		System.out.println("count = " + count.sum() + ", sum = " + adder.sum());

		LongAccumulator accumulator = new LongAccumulator((x, y) -> x + y * y, 0L);
		for (long longValue : longArray) {
			accumulator.accumulate(longValue);
		}
		System.out.println("accumulator sum = " + accumulator.get());
	}
}
