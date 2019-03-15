package com.su.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.su.model.Flower;
import com.su.service.FlowerService;
import com.su.service.impl.FlowerServiceImpl;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext aContext=new ClassPathXmlApplicationContext("applicationContext.xml");

		FlowerServiceImpl bean=aContext.getBean("flowerService",FlowerServiceImpl.class);
		List<Flower> flower=bean.show();
		System.out.println(flower);

		
//		String[] names=aContext.getBeanDefinitionNames();
//		for(String name:names) {
//			System.out.println(name);
//		}
	} 

}
