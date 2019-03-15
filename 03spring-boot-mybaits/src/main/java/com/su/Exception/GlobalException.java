package com.su.Exception;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class GlobalException implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// TODO Auto-generated method stub
		ModelAndView mView=new ModelAndView();
		if(ex instanceof ArithmeticException) {
			mView.setViewName("error1");
		}
		
		if(ex instanceof NullPointerException) {
			mView.setViewName("error2");
		}
		
		mView.addObject("error",ex.toString());
		return mView;
	}
	
}
