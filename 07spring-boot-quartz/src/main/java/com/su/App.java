package com.su;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //开启任务
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
