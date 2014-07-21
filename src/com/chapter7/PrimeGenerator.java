package com.chapter7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PrimeGenerator implements Runnable {
	private final List<BigInteger> primes = new ArrayList<BigInteger>();
	private volatile boolean cancelled;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BigInteger p = BigInteger.ONE;
		while(!cancelled){
			p = p.nextProbablePrime();
			synchronized(this){
				primes.add(p);
			}
		}
	}
	public void cancel(){
		this.cancelled = true;
	}
	public synchronized List<BigInteger> get(){
		return new ArrayList<BigInteger>(primes);
	}

}
