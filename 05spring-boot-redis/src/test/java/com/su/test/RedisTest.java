package com.su.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.su.App;
import com.su.model.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class RedisTest {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
//	@Test
//	public void testSet() {
//		this.redisTemplate.opsForValue().set("spring02", "配置文件中设置");
//	}
//	
//	@Test
//	public void testGet() {
//		String valueString=(String) this.redisTemplate.opsForValue().get("spring02");
//		System.out.println(valueString);
//	}
	
//	@Test
//	public void testSetUsers() {
//		Users users=new Users();
//		users.setId(1);
//		users.setName("张三");
//		users.setAge(23);
//		
//		//重新设置序列化器
//		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
//		this.redisTemplate.opsForValue().set("users", users);
//	}
	
//	@Test
//	public void testGetUsers() {
//		//重新设置序列化器
//		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
//		Users users=(Users) this.redisTemplate.opsForValue().get("users");
//		System.out.println(users);
//	}
	
//	@Test
//	public void testSetJson() {
//		Users users=new Users();
//		users.setId(2);
//		users.setName("李四");
//		users.setAge(12);
//		
//		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
//		this.redisTemplate.opsForValue().set("users_json", users);
//	}
	
	@Test
	public void testGetJson() {
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
		Users users=(Users) this.redisTemplate.opsForValue().get("users_json");
		System.out.println(users);
	}
}
