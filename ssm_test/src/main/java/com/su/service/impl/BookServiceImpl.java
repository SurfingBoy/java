package com.su.service.impl;

import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.su.dao.AppointmentDao;
import com.su.dao.BookDao;
import com.su.dto.AppointExecution;
import com.su.entity.Appointment;
import com.su.entity.Book;
import com.su.enums.AppointStateEnum;
import com.su.exception.AppointException;
import com.su.exception.NoNumberException;
import com.su.exception.RepeatAppointException;
import com.su.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BookDao bookDao;
	@Autowired
	private AppointmentDao appointmentDao;
	
	/**
	 * 查询一本书
	 */
	@Override
	public Book getById(long bookId) {
		// TODO Auto-generated method stub
		return bookDao.queryById(bookId);
	}

	/**
	 * 查询所有图书
	 */
	@Override
	public List<Book> getList() {
		// TODO Auto-generated method stub
		return bookDao.queryAll(0, 30);
	}

	/**
	 * 预约所有图书
	 */
	@Override
	public AppointExecution appoint(long bookId, long studentId) {
		try {
			//减少库存
			int update=bookDao.reduceNumber(bookId);
			if(update<=0) {
				throw new NoNumberException("no number");
			}else {
				//插入记录
				int insert=appointmentDao.insertAppointment(bookId, studentId);
				if(insert<=0) {
					throw new RepeatAppointException("repeat appoint");
				}else {
					Appointment appointment=appointmentDao.queryByKeyWithBook(bookId, studentId);
					return new AppointExecution(bookId, AppointStateEnum.SUCCESS,appointment);
				}
			}
		//要先于catch Exception异常前先catch住再抛出，不然自定义的异常也会被转换为AppointException,导致控制层无法识别是那个异常
		} catch (NoNumberException e1) {
			throw e1;
		} catch (RepeatAppointException e2) {
			throw e2;
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			
			throw new AppointException("appoint inner error:"+e.getMessage());
		}
	}

}
