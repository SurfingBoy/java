package com.su.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.su.mapper.UserMapper;
import com.su.model.Users;
import com.su.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void addUser(Users users) {
		this.userMapper.insertUser(users);
	}

	@Override
	public List<Users> findUsersAll() {
		// TODO Auto-generated method stub
		return this.userMapper.selectUsersAll();
	}

	@Override
	public Users findUserById(int id) {
		// TODO Auto-generated method stub
		return this.userMapper.selectUserById(id);
	}

	@Override
	public void updateUser(Users users) {
		// TODO Auto-generated method stub
		this.userMapper.updateUser(users);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		this.userMapper.deleteUserById(id);
	}

}
