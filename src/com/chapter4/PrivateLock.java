package com.chapter4;

import common.GuardedBy;

public class PrivateLock {
	private final Object myLock = new Object();
	@GuardedBy("myLock") Widget widget;
	
	void someMethod(){
		synchronized(myLock){
			//���ʻ��޸�widget��״̬
		}
	}
	class Widget{
		
	}
}
