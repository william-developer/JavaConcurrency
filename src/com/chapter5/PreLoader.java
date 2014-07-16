package com.chapter5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class PreLoader {
	private final FutureTask<ProductInfo> future = new FutureTask(new Callable<ProductInfo>(){
		public ProductInfo call(){
			return loadProductInfo();
		}
	});
	public ProductInfo loadProductInfo(){
		return null;
	}
	public final Thread thread = new Thread(future);
	public void start(){
		thread.start();
	}
	public ProductInfo get() throws Exception{
		try {
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof DataLoadException)
                throw (DataLoadException) cause;
            else
                throw LaunderThrowable.launderThrowable(cause);
        }
	}
}
class DataLoadException extends Exception { }
interface ProductInfo {
}
class LaunderThrowable extends Exception{

	public static Exception launderThrowable(Throwable cause) {
		// TODO Auto-generated method stub
		return null;
	}
	
}