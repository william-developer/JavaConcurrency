package com.chapter2;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import common.NotThreadSafe;
@NotThreadSafe
public class UnsafeCountingFactorizer implements Servlet {
	private Long count = 0l;
	public Long getCount(){
		return count;
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
		BigInteger[] factors = factor(i);
		count++;
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
