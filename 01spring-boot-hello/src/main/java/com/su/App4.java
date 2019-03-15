package com.su;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 启动FirstFilter
 * @author Administrator
 *
 */
@SpringBootApplication
@ServletComponentScan
public class App4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(App4.class, args);
	}

}
