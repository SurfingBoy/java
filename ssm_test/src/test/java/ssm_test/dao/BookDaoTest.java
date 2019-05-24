package ssm_test.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.su.dao.BookDao;
import com.su.entity.Book;

import ssm_test.BaseTest;

public class BookDaoTest extends BaseTest{

	@Autowired
	private BookDao bookDao;
	
	@Test
	public void testQueryById() {
		Book book=bookDao.queryById(1001);
		System.out.println(book);
	}
	
	@Test
	public void testQueryAll() {
		List<Book> books=bookDao.queryAll(0, 5);
		for(Book book:books) {
			System.out.println(book);
		}
	}
	
	@Test
	public void testRedume() {
		bookDao.reduceNumber(1000);
		System.out.println(bookDao.queryById(1000));
	}
}
