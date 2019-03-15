package com.su;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.su.Filter.SecondFilter;
import com.su.Listener.SecondListener;
import com.su.Servlet.SecondServlet;

@SpringBootApplication
public class App1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(App1.class, args);
	}
	
	@Bean
	public ServletRegistrationBean getServletRegistrationBean() {
		ServletRegistrationBean bean=new ServletRegistrationBean(new SecondServlet());
		bean.addUrlMappings("/second");
		return bean;
	}
	
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean() {
		FilterRegistrationBean bean=new FilterRegistrationBean(new SecondFilter());
		bean.addUrlPatterns("/second");
		return bean;
	}
	
	@Bean
	public ServletListenerRegistrationBean<SecondListener> getServletListenerRegistrationBean(){
		ServletListenerRegistrationBean<SecondListener> bean=new ServletListenerRegistrationBean<SecondListener>(new SecondListener());
		return bean;
	}
}
