package com.chapter7;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CancellingExecutor extends ThreadPoolExecutor {

	public CancellingExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		// TODO Auto-generated constructor stub
	}
	
	protected<T> RunnableFuture<T> newTask(Callable<T> callable){
		if(callable instanceof CancellableTask)
			return ((CancellableTask<T>)callable).newTask();
		else return super.newTaskFor(callable);
	}
}
