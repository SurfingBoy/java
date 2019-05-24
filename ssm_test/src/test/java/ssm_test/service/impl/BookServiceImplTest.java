package ssm_test.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.su.dto.AppointExecution;
import com.su.service.BookService;

import ssm_test.BaseTest;

public class BookServiceImplTest extends BaseTest{
	
	@Autowired
	private BookService bookService;
	
	@Test
	public void testAppoint(){
		AppointExecution execution=bookService.appoint(1000, 3);
		System.out.println(execution);
	}
}
