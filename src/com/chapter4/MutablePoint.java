package com.chapter4;

import common.NotThreadSafe;

@NotThreadSafe
public class MutablePoint {
	public int x,y;

	public MutablePoint(){
		x=0;
		y=0;
	}
	public MutablePoint(MutablePoint p){
		x = p.x;
		y = p.y;
	}
	
}
