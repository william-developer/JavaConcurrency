package com.chapter4;

import common.Immutable;

@Immutable
public class Point {
	private final int x,y;
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}
} 