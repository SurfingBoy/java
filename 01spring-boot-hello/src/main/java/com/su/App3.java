package com.su;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.su.Servlet.SecondServlet;

/**
 * 启动SecondServlet
 * @author Administrator
 *
 */
@SpringBootApplication
public class App3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(App3.class, args);
	}
	
	@Bean
	public ServletRegistrationBean getServletRegistrationBean() {
		ServletRegistrationBean bean=new ServletRegistrationBean(new SecondServlet());
		bean.addUrlMappings("/second");
		return bean;
	}
}
