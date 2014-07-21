package com.chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class LifecycleWebServer {
	private final ExecutorService exec= Executors.newCachedThreadPool();
	
	public void start() throws IOException{
		ServerSocket socket = new ServerSocket(80);
		while(true){
			try{
				final Socket conn = socket.accept();
				exec.execute(new Runnable(){
					public void run(){
						handleRequest(conn);
					}
				});
			}catch(RejectedExecutionException e){
				if(!exec.isShutdown())
					System.out.println("task submission rejected");
			}
		}
	}
	public void shutdown(){
		exec.shutdown();
	}
	void handleRequest( Socket conn){
		
	}
}
