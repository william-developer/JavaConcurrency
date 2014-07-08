package com.chapter3;

import java.awt.Event;

import common.NotThreadSafe;
@NotThreadSafe
public class ThisEscape {
	public ThisEscape(EventSource source){
		source.registerListener(
				new EventListener(){
					public void onEvent(Event e){
						doSomething(e);
					}
				}
		);
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
}
