package com.chapter8;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

import common.ThreadSafe;
@ThreadSafe
public class BoundedExecutor {
	private final Executor exec;
	private final Semaphore semaphore;
	
	public BoundedExecutor(Executor exec,int bound){
		this.exec = exec;
		this.semaphore = new Semaphore(bound);
	}
	public void submitTask(final Runnable command) throws InterruptedException{
		semaphore.acquire();
		try{
			exec.execute(new Runnable(){
				public void run(){
					try{
						command.run();
					}finally{
						semaphore.release();
					}
				}
			});
		}catch(RejectedExecutionException e){
			
		}
	}
}
