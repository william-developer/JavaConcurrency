package com.chapter5;

import java.util.concurrent.CountDownLatch;

public class TestHarness {
	public Long timeTasks(int nThreads,final Runnable task) throws InterruptedException{
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);
		for(int i=0;i<nThreads;i++){
			Thread t = new Thread(){
				public void run(){
					try{
						startGate.await();
						try{
							task.run();
						}finally{
							endGate.countDown();
						}
					}catch(InterruptedException e){
						Thread.currentThread().interrupted();
					}
				}
			};
			t.start();
		}
		Long start = System.nanoTime();
		startGate.countDown();
		endGate.await();
		Long end = System.nanoTime();
		return end - start;
	}
}
