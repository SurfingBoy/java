package com.su.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("切点方法对象"+arg0+"  方法名"+arg0.getName());
		System.out.println("切点方法参数"+arg1);
		System.out.println("对象"+arg2);
		System.out.println("执行前置通知");
	}
	
}
