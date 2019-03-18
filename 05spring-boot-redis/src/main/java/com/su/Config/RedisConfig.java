package com.su.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis的配置
 * @author Administrator
 *
 */
@Configuration
public class RedisConfig {
	/**
	 * 1.创建JedisPoolConfig对象，完成连接池的配置
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix="spring.redis.pool")
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig config=new JedisPoolConfig();
		//在配置文件中设置
/*		//最大空闲数
		config.setMaxIdle(10);
		//最小空闲数
		config.setMinIdle(5);
		//最大链接数
		config.setMaxTotal(20);
		*/
		
		return config;
	}
	
	/**
	 * 2.创建JedisConnectionFactory,配置redis连接信息
	 * @param config
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix="spring.redis")
	public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig config) {
		JedisConnectionFactory factory=new JedisConnectionFactory();
		//关联连接池配置对象
		factory.setPoolConfig(config);
		/*
		 * //配置连接redis信息 
		 * //主机地址 
		 * factory.setHostName("127.0.0.1"); 
		 * //端口
		 * factory.setPort(6379); 
		 * //密码 
		 * factory.setPassword("123456");
		 */
		
		return factory;
	}
	
	/**
	 * 创建RedisTemplate,用于执行Redis操作的方法
	 * @param factory
	 * @return
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory factory){
		RedisTemplate<String, Object> template=new RedisTemplate<String, Object>();
		//关联连接信息
		template.setConnectionFactory(factory);
		
		//为key设置序列化器
		template.setKeySerializer(new StringRedisSerializer());
		//为value设置序列化器
		template.setValueSerializer(new StringRedisSerializer());
		
		return template;
	}
}
