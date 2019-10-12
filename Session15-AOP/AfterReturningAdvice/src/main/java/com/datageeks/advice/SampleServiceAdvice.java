package com.datageeks.advice;

import org.aspectj.lang.JoinPoint;

public class SampleServiceAdvice {
	
	//Before Advice Logic
	
	public void checkOffer(JoinPoint joinpoint)
	{
		System.out.println(" \n\n From SampleServiceAdvice :: BeforeAdvice Method checkOffer(...) Started  ");
		System.out.println("PointCut Expression => "+joinpoint.getSignature());
		System.out.println(" Type of selecting JoinPoint => "+joinpoint.getKind());
		Object[] objArry = joinpoint.getArgs();
		String cardType = (String)objArry[0];
		System.out.println(" Crad Type => "+cardType);
		if(cardType.equalsIgnoreCase("HDFC"))
		{
			System.out.println("===> Congrats Offer eligibility Applied for 10% ");
		}else
		{
			System.out.println("!!! Sorry not eligible for cashback offer");
		}
		System.out.println(" From SampleServiceAdvice :: BeforeAdvice Method checkOffer(...) Ended ");
		
	}
	
	
	public void cashBack(JoinPoint joinPoint, Float orderAmount)
	{
		System.out.println(" \n\n From SampleServiceAdvice :: AfterRetuning Method cashBack(...) Started  ");
		System.out.println("Congrats !!!"+(orderAmount/10) +" Cashback applied !!!!");
		System.out.println(" From SampleServiceAdvice :: AfterRetuning Method cashBack(...) Ended  ");
		
	}

}
