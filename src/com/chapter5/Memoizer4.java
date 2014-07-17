package com.chapter5;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import common.LaunderThrowable;

public class Memoizer4<A, V> implements Computable<A,V>{
	private final ConcurrentHashMap<A, Future<V>> cache
    = new ConcurrentHashMap<A, Future<V>>();
	private final Computable<A, V> c;
	
	public Memoizer4(Computable<A, V> c) {
	this.c = c;
	}
	
	public V compute(final A arg) throws InterruptedException {
		Future<V> f = cache.get(arg);
		if (f == null) {
		    Callable<V> eval = new Callable<V>() {
		        public V call() throws InterruptedException {
		            return c.compute(arg);
		        }
		    };
		    FutureTask<V> ft = new FutureTask<V>(eval);
            f = cache.putIfAbsent(arg, ft);
            if(f==null){
            	cache.put(arg, ft);
    		    ft.run(); // call to c.compute happens here
            }
		}
		try {
		    return f.get();
		} catch (ExecutionException e) {
		    throw LaunderThrowable.launderThrowable(e.getCause());
		}
	}
}
