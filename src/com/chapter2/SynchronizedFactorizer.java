package com.chapter2;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import common.GuardedBy;
import common.ThreadSafe;
@ThreadSafe
public class SynchronizedFactorizer implements Servlet {

	@GuardedBy("this") private final AtomicReference<BigInteger> lastNumber = new AtomicReference<BigInteger>();
	@GuardedBy("this") private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<BigInteger[]>();
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
	public synchronized void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		BigInteger i = extractFromRequest(req);
		if(i.equals(lastNumber))
			encodeIntoResponse(resp,lastFactors.get());
		else{
			BigInteger[] factors = factor(i);
			lastNumber.set(i);
			lastFactors.set(factors);
			encodeIntoResponse(resp,factors);
		}

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
