package com.datageeks.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class SampleServiceAdvice {

	// Before Advice Logic

	@Before(value = "execution(* com.datageeks.service.SampleService.demo(..))")
	public void checkOffer(JoinPoint joinpoint) {
		System.out.println(" \nFrom SampleServiceAdvice :: BeforeAdvice Method checkOffer(...) Started  ");
		System.out.println("PointCut Expression => " + joinpoint.getSignature());
		System.out.println(" Type of selecting JoinPoint => " + joinpoint.getKind());
		Object[] objArry = joinpoint.getArgs();
		String cardType = (String) objArry[0];
		System.out.println(" Crad Type => " + cardType);
		if (cardType.equalsIgnoreCase("HDFC")) {
			System.out.println("===> Congrats Offer eligibility Applied for 10% ");
		} else {
			System.out.println("!!! Sorry not eligible for cashback offer");
		}
		System.out.println(" From SampleServiceAdvice :: BeforeAdvice Method checkOffer(...) Ended ");

	}

	@AfterReturning(returning = "orderAmount",pointcut = "execution(* com.datageeks.service.SampleService.order())")
	public void cashBack(JoinPoint joinPoint, Float orderAmount) {
		System.out.println(" \nFrom SampleServiceAdvice :: AfterRetuning Method cashBack(...) Started  ");
		System.out.println("Congrats !!!" + (orderAmount / 10) + " Cashback applied !!!!");
		System.out.println(" From SampleServiceAdvice :: AfterRetuning Method cashBack(...) Ended  ");

	}

	@Around(value = "execution(* com.datageeks.service.SampleService.transfer())")
	public Boolean transactional(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println(
				"\nFrom SampleServiceAdvice :: AroundAdvice method transactional() => Transaction Initiated  ");

		Boolean flag = (Boolean) joinPoint.proceed();

		if (flag) {
			System.out.println(
					"\nFrom SampleServiceAdvice :: AroundAdvice method transactional() => Transaction Successfull  ");
		} else {
			System.out.println(
					"\n From SampleServiceAdvice :: AroundAdvice method transactional() => Transaction Rollbacked  ");
		}

		return flag;
	}

	@AfterThrowing(throwing = "exp",pointcut = "execution(* com.datageeks.service.SampleService.testExp())")
	public void handleException(Throwable exp) {
		System.out.println(
				"\nFrom SampleServiceAdvice :: After-Throwing Advice  method handleException(...) => Exception Handled  ");
		System.out.println(exp);
	}

	@After(value = "execution(* com.datageeks.service.SampleService.testExp())")
	public void finalMethod() {
		System.out.println(
				"\nFrom SampleServiceAdvice :: Finally Advice  method finalMethod(...) => execution Completed");
	}

}
