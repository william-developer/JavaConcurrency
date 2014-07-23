package com.chapter8;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyAppThread extends Thread {
	private static final String DEFAULT_NAME="MyAppThread";
	private static volatile boolean debuglifecyle=false;
	private static final AtomicInteger created = new AtomicInteger();
	
	private static final AtomicInteger alive = new AtomicInteger();
	private static final Logger log = Logger.getAnonymousLogger();
	
	public MyAppThread(Runnable r){
		this(r,DEFAULT_NAME);
	}
	public MyAppThread(Runnable r,String name){
		super(r,name+"-"+created.incrementAndGet());
		setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				// TODO Auto-generated method stub
				log.log(Level.SEVERE, "UNCAUGHT IN THREAD "+t.getName(),e);
			}
		});
	}
	public void run(){
		boolean debug = debuglifecyle;
		if(debug) log.log(Level.FINE,"Created "+getName());
		try{
			alive.incrementAndGet();
			super.run();
		}finally{
			alive.decrementAndGet();
			if(debug) log.log(Level.FINE,"Exiting "+getName());
		}
	}
	public static int getThreadsCreated(){
		return created.get();
	}
	public static int getThreadsAlive(){
		return alive.get();
	}
	public static boolean getDubug(){
		return debuglifecyle;
	}
	public static void setDebug(boolean b){
		debuglifecyle= b;
	}
}
