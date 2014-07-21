package com.chapter7;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureThreadInterrupte {
	private static final ExecutorService taskExec = 
			Executors.newCachedThreadPool();
	public static void timeRun(final Runnable r,long timeout,TimeUnit unit) throws InterruptedException{
		Future<?> task = taskExec.submit(r);
		try{
			task.get(timeout, unit);
		}catch(TimeoutException e){
			
		}catch(ExecutionException e){
			
		}finally{
			task.cancel(true);
		}
	}
	
}
