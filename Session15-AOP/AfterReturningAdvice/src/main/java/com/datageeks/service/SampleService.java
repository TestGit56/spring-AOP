package com.datageeks.service;

public class SampleService {

	public boolean demo(String cardType, Float amount) {

		System.out.println(" \n\n From Core Concern :: SampleService => demo(..) JoinPoint => Transfer Successful");
		return true;
	}
	
	
	public Float order()
	{
		System.out.println("\n\n From Core Concern :: SampleService => order(..) JoinPoint => Order Successful");
		return 1000f;
	}

}
