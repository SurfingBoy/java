package com.su.service;

import java.util.List;

import com.su.dto.AppointExecution;
import com.su.entity.Book;

public interface BookService {
	/**
	 * 查询一本书
	 * @param bookId
	 * @return
	 */
	public Book getById(long bookId);
	
	/**
	 * 查询所有书
	 * @return
	 */
	public List<Book> getList();
	
	/**
	 * 预约书
	 * @param bookId
	 * @param studentId
	 * @return
	 */
	public AppointExecution appoint(long bookId,long studentId);
}
