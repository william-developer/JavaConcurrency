package com.chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutionWebServer {
	private static final int NTHREADS = 10;
	private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket socket = new ServerSocket(80);
		while(true){
			final Socket connection = socket.accept();
			Runnable task = new Runnable(){
				public void run(){
					handleRequest(connection);
				}
			};
			exec.execute(task);
		}

	}
	public static void handleRequest(Socket connection){
		
	}

}
