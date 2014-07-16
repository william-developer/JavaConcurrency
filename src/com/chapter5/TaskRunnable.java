package com.chapter5;

import java.util.concurrent.BlockingQueue;

public class TaskRunnable implements Runnable {
	BlockingQueue<Task> queue;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			processTask(queue.take());
		}catch(InterruptedException e){
			Thread.currentThread().interrupted();
		}
	}
	public void processTask(Task task){
		
	}
	interface Task{
		
	}

}
