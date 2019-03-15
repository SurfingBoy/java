package com.su.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext aContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Demo demo=aContext.getBean("demo",Demo.class);
		demo.demo1();
		demo.demo2();
		demo.demo3();
		
		
//		String[] names=aContext.getBeanDefinitionNames();
//		for(String name:names) {
//			System.out.println(name);
//		}
	} 

}
