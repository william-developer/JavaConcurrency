package com.chapter3;

import java.awt.Event;

import common.ThreadSafe;
@ThreadSafe
public class SafeListener {
	private final EventListener listener;
	
	public SafeListener(){
		listener = new EventListener(){
			public void onEvent(Event e){
				doSomething(e);
			}
		};
	}
	
	public void doSomething(Event e){
		System.out.println("here");
	} 
	public class EventSource{
		public void registerListener(EventListener e){
			
		}
	}
	public interface EventListener{
		public void onEvent(Event e);
	}
	public static SafeListener newIntance(EventSource source){
		SafeListener safe = new SafeListener();
		source.registerListener(safe.listener);
		return safe;
	}
}
