package com.chapter4;

import common.GuardedBy;

public class PrivateLock {
	private final Object myLock = new Object();
	@GuardedBy("myLock") Widget widget;
	
	void someMethod(){
		synchronized(myLock){
			//访问或修改widget的状态
		}
	}
	class Widget{
		
	}
}
