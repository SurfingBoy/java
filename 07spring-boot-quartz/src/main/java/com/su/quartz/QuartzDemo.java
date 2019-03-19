package com.su.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.su.service.UserService;

public class QuartzDemo implements Job{

	@Autowired
	private UserService userService;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("任务执行...."+new Date());
		this.userService.AddUser();
	}

}
