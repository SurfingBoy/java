package com.su.mapper;


import java.util.List;

import com.su.model.Users;

public interface UserMapper {
	public void insertUser(Users users);
	
	public List<Users> selectUsersAll();
	
	public Users selectUserById(int id);
	
	public void updateUser(Users users);
	
	public void deleteUserById(int id);
}
