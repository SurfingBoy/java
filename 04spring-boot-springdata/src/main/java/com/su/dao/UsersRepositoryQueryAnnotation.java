package com.su.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.su.model.Users;

/**
 * Repository @Query
 * @author Administrator
 *
 */
public interface UsersRepositoryQueryAnnotation extends Repository<Users, Integer>{
	
	//对象查询
	@Query("from Users where name= ?")
	List<Users> queryByNameUseHQL(String name);
	
	//sql查询
	@Query(value="select * from users where name= ?",nativeQuery=true)
	List<Users> queryByNameUseSQL(String name);
	
	@Query("update Users set name=? where id=?")
	@Modifying //需要执行一个更新操作
	void updateUserNameById(String name,int id);
}
