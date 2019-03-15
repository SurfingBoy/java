package com.su.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.su.model.Users;

public interface UsersRepository extends JpaRepository<Users,Integer>{

}
