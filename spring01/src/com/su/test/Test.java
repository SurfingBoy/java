package com.su.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.su.model.People;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext aContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		People people=aContext.getBean("peo",People.class);
		System.out.println(people);
		
		People people2=aContext.getBean("peo2",People.class);
		System.out.println(people2);
		
//		String[] names=aContext.getBeanDefinitionNames();
//		for(String name:names) {
//			System.out.println(name);
//		}
	} 

}
