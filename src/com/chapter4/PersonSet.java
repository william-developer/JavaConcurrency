package com.chapter4;

import java.util.HashSet;
import java.util.Set;

import common.GuardedBy;
import common.ThreadSafe;

@ThreadSafe
public class PersonSet {
	@GuardedBy("this") private final Set<Person>  mySet  = new HashSet<Person>();
	public synchronized void addPerson(Person p){
		mySet.add(p);
	}
	
	public synchronized boolean containsPerson(Person p){
		return mySet.contains(p);
	}
	
	class Person{
		public Person(){
			
		}
	}
}
