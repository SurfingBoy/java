package com.su.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.su.model.Users;

public interface UsersRepositoryPagingAndSorting extends PagingAndSortingRepository<Users, Integer>{

}
