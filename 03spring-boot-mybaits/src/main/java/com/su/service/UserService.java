package com.su.service;

import java.util.List;

import com.su.model.Users;

public interface UserService {
	public void addUser(Users user);
	
	public List<Users> findUsersAll();
	
	public Users findUserById(int id);
	
	public void updateUser(Users users);
	
	public void deleteUser(int id);
}
