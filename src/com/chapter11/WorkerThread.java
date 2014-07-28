package com.chapter11;

import java.util.concurrent.BlockingQueue;

public class WorkerThread extends Thread {
	private final BlockingQueue<Runnable> queue;
	public WorkerThread( BlockingQueue<Runnable> queue){
		this.queue = queue;
	}
	public void run(){
		while(true){
			Runnable task;
			try {
				task = queue.take();
				task.run();
			} catch (InterruptedException e) {
				break;
			}
		}
	}
}
