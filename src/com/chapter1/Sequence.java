package com.chapter1;

import common.GuardedBy;
import common.ThreadSafe;

@ThreadSafe
public class Sequence {
	@GuardedBy("this") private int Value;
	public synchronized int getNext(){
		return Value++;
	}
}
