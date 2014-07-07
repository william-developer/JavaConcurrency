package com.chapter2;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import common.GuardedBy;
import common.ThreadSafe;
@ThreadSafe
public class CacheFactorizer implements Servlet {
	@GuardedBy("this") private BigInteger lastNumber; 
	@GuardedBy("this") private BigInteger[] lastFactors;
	@GuardedBy("this") private long hits;
	@GuardedBy("this") private long cacheHits;
	
	public synchronized long getHits(){
		return hits;
	}
	public synchronized double getCacheHitRatio(){
		return (double)cacheHits/(double)hits;
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors=null;
		synchronized(this){
			++hits;
			if(i.equals(lastNumber)){
				++cacheHits;
				factors = lastFactors.clone();
			}
		}
		if(factors==null){
			factors = factor(i);
			synchronized(this){
					lastNumber = i;
					lastFactors = factors.clone();
				}
			}
		encodeIntoResponse(resp,factors);
	}
	public BigInteger extractFromRequest(ServletRequest req){
		return BigInteger.valueOf(100);
	}
	public BigInteger[] factor(BigInteger i){
		//业务处理
		return new BigInteger[]{BigInteger.valueOf(2),BigInteger.valueOf(2)};
	} 
	public void encodeIntoResponse(ServletResponse resp,BigInteger[] factors){
		
	} 
}
