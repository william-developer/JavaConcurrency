package com.chapter2;

import common.NotThreadSafe;

@NotThreadSafe
public class LazyInitRace {
	private ExpensiveObject instance = null;
	public ExpensiveObject getInstance(){
		if(instance == null)
			instance = new ExpensiveObject();
		return instance;
	} 
	public class ExpensiveObject{
		
	}
}