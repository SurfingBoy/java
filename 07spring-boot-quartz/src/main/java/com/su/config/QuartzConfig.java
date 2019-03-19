package com.su.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import com.su.quartz.QuartzDemo;

/**
 * 整合spring-boot Quartz配置类
 * 
 * @author Administrator
 *
 */
@Configuration
public class QuartzConfig {

	// 1.创建Job对象
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean() {
		JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
		// 关联job类
		factoryBean.setJobClass(QuartzDemo.class);
		return factoryBean;
	}

	/**
	 * 2.创建Trigger对象 简单trigger
	 * 
	 * @param jobDetail
	 * @return
	 */
	
//	  @Bean 
//	  public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetail) {
//		  SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();
//		  //关联jobDetail对象 
//		  factory.setJobDetail(jobDetail.getObject()); 
//		  //执行的毫秒级
//		  factory.setRepeatInterval(3000); 
//		  //重复次数 
//		  factory.setRepeatCount(3); 
//		  
//		  return factory;
//	  }
	 

	/**
	 * CronTrigger
	 * 
	 * @param jobDetail
	 * @return
	 */
	@Bean
	public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetail) {
		CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
		factoryBean.setJobDetail(jobDetail.getObject());
		// 设置触发时间
		factoryBean.setCronExpression("0/5 * * * * ?");
		return factoryBean;
	}

	/**
	 * 3.创建Scheduler对象
	 * 
	 * @param simpleTrigger
	 * @return
	 */
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTrigger,
			MyAdaptableJobFactory myAdaptableJobFactory) {
		SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
		// 关联Trigger
		factoryBean.setTriggers(cronTrigger.getObject());
		factoryBean.setJobFactory(myAdaptableJobFactory);
		return factoryBean;

	}
}
