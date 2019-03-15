package com.su;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 启动FirstServlet
 * @author Administrator
 *
 */
@SpringBootApplication
@ServletComponentScan //在springboot启动时会扫描@WebServlet，并将该类实例化
public class App2 {

	public static void main(String[] args) {
		SpringApplication.run(App2.class, args);
	}

}
