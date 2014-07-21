package com.chapter7;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SpecialThreadInterrupte {
	private static final ScheduledExecutorService cancelExec = 
			Executors.newScheduledThreadPool(2);
	public static void timeRun(final Runnable r,long timeout,TimeUnit unit) throws InterruptedException{
		class RethrowableTask implements Runnable{
			private volatile Throwable t;
			public void run(){
				try{
					r.run();
				}catch(Throwable t){
					this.t = t;
				}
			}
			void rethrow() throws InterruptedException{
				if(t!=null)
					throw new InterruptedException();
			}
		}
		RethrowableTask task = new RethrowableTask();
		final  Thread taskThread  =  new Thread(task);
		taskThread.start();
		cancelExec.schedule(new Runnable(){
			public void run(){
				taskThread.interrupt();
			}
		}, timeout, unit);
		task.rethrow();
	}
	
}
