package com.su.scheduled;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledDemo {
	@Scheduled(cron="0/5 * * * * ?") //每5秒执行一次
	public void scheduledMethod() {
		System.out.println("定时器触发"+new Date());
	}
}
