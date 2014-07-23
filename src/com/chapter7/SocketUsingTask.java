package com.chapter7;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public abstract class SocketUsingTask<T> implements CancellableTask<T> {
	private Socket socket;
	protected synchronized void setSocket(Socket s){
		this.socket = s;
	}
	
	
	@Override
	public T call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public synchronized void cancel() {
		// TODO Auto-generated method stub
		try{
			if(socket!=null)
				socket.close();
		}catch(IOException e){
			
		}
	}

	@Override
	public RunnableFuture<T> newTask() {
		// TODO Auto-generated method stub
		return new FutureTask<T>(this){
			public boolean cancel(boolean mayInterruptIfRunning){
				try{
					SocketUsingTask.this.cancel();
				}finally{
					return super.cancel(mayInterruptIfRunning);
				}
			}
		};
	}

}
