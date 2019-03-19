package com.su.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 单独Quartz测试
 * @author Administrator
 *
 */
public class QuartzMain {

	public static void main(String[] args) throws SchedulerException {
		//1.创建Job对象
		JobDetail jobDetail=JobBuilder.newJob(QuartzDemo.class).build();
		//2.创建Trigger对象
		Trigger trigger=TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.
				cronSchedule("0/5 * * * * ?")).build();
		//3.创建Scheduler对象
		Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
		scheduler.scheduleJob(jobDetail,trigger);
		
		//启动
		scheduler.start();
	}

}
