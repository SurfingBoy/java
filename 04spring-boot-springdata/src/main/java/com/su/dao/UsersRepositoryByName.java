package com.su.dao;


import java.util.List;

import org.springframework.data.repository.Repository;

import com.su.model.Users;

public interface UsersRepositoryByName extends Repository<Users,Integer>{
	//方法名称必须遵循驼峰命名规则，findBy(关键字)+属性名称(首字母要大写)+查询条件(首字母大写)
	List<Users> findByName(String name);
	
	List<Users> findByNameAndAge(String name,int age);
	
	List<Users> findByNameLike(String nameString);
	
}
