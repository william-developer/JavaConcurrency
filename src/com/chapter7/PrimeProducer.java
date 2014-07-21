package com.chapter7;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class PrimeProducer extends Thread {
	private final BlockingQueue queue;
	public PrimeProducer(BlockingQueue queue){
		this.queue = queue;
	}
	public void run(){
		try {
			BigInteger p = BigInteger.ONE;
		while(!Thread.currentThread().isInterrupted())
				queue.put(p=p.nextProbablePrime());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
