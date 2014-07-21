package com.chapter4;

import common.GuardedBy;
import common.IllgalStateException;
import common.ThreadSafe;
@ThreadSafe
public final class Counter {
	@GuardedBy("this") private long value = 0;
	public synchronized long getValue(){
		return value;
	}
	public synchronized long increase() throws IllgalStateException{
		if(value==Long.MAX_VALUE)
			throw new IllgalStateException("count overflow");
		return ++value;
	}
}
