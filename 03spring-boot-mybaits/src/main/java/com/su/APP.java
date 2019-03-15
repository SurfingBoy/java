package com.su;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.su.mapper") //mybatis扫描mapper
@EnableCaching //开启ehcache缓存
public class APP {
	public static void main(String[] args) {
		SpringApplication.run(APP.class, args);
	}
}

