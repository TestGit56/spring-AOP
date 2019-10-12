package com.datageeks.service;

import org.springframework.stereotype.Service;

@Service
public class SampleService {

	public boolean demo(String cardType, Float amount) {

		System.out.println(" *** From Core Concern :: SampleService => demo(..) JoinPoint => Transfer Successful");
		return true;
	}
	
	
	public Float order()
	{
		System.out.println(" ***From Core Concern :: SampleService => order(..) JoinPoint => Order Successful");
		return 1000f;
	}
	
	
	public boolean transfer()
	{
		System.out.println(" ***From Core Concern :: SampleService => transfer() JoinPoint => Execution completed");
		return true;
	}
	
	public void testExp() 
	{
		System.out.println(" ***From Core Concern :: SampleService => testExp() JoinPoint => Execution completed");
		throw new RuntimeException(" Exception from the JoinPoint testExp() !!!");

	}

}
