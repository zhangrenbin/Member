package com.ice.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

@Component("logAdvice")
public class LogAdvice implements AfterReturningAdvice {

	public void afterReturning(Object returnValue, Method m, Object[] arg2, Object target) throws Throwable {
//		System.out.println("1213213213213");
	}

}
