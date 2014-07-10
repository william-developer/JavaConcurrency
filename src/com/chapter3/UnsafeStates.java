package com.chapter3;

import common.NotThreadSafe;

@NotThreadSafe
public class UnsafeStates {
	private String[] states = new String[]{"AK","AL"};
	public String[] getStates(){
		return states;
	}
}
