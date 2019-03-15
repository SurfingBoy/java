package com.su.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.su.App;
import com.su.dao.UsersRepository;
import com.su.dao.UsersRepositoryByName;
import com.su.dao.UsersRepositoryPagingAndSorting;
import com.su.dao.UsersRepositoryQueryAnnotation;
import com.su.model.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class UsersRepositoryTest {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UsersRepositoryByName UsersRepositoryByName;
	
	@Autowired
	private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;
	
	@Autowired
	private UsersRepositoryPagingAndSorting usersRepositoryPagingAndSorting;
	
	/**
	 * JpaRepository(继承了PagingAndSortingRepository)
	 */
//	@Test
//	public void saveTest() {
//		Users users=new Users();
//		users.setName("测试2");
//		users.setAge(16);
//		this.usersRepository.save(users);
//	}
	
	/**
	 * Repository --ByName测试
	 */
//	@Test
//	public void testFindName() {
//		List<Users> users=this.UsersRepositoryByName.findByNameLike("%测%");
//		for(Users user:users) {
//			System.out.println(user);
//		}
//	}
	
	/**
	 * Repository--@Query测试
	 */
//	@Test
//	public void testQueryByNameUseSQL() {
//		List<Users> users=this.usersRepositoryQueryAnnotation.queryByNameUseSQL("测试1");
//		for(Users user:users) {
//			System.out.println(user);
//		}
//	}
	
	/**
	 * Repository--@Query测试
	 */
//	@Test
//	@Transactional //@Transactional与@Test一起使用时事物是自动回滚的
//	@Rollback(false) //取消自动回滚
//	public void testUpdateUserNameById() {
//		this.usersRepositoryQueryAnnotation.updateUserNameById("又是测试", 1);
//	}
	
	/**
	 * Repository-PagingAndSoring 分页排序
	 */
	@Test
	public void testPagingAndSortingRepository() {
		Order order1=new Order(Direction.ASC,"age");
		Order order2=new Order(Direction.DESC,"id");
		Sort sort=new Sort(order1,order2);
		//排序
		List<Users> users=(List<Users>) this.usersRepositoryPagingAndSorting.findAll(sort);
		for(Users user:users) {
			System.out.println(user);
		}
		//分页
//		Pageable pageable=new PageRequest(0, 2,sort);
//		Page<Users> page=this.usersRepositoryPagingAndSorting.findAll(pageable);
//		System.out.println("总条数："+page.getTotalElements());
//		System.out.println("总页数："+page.getTotalPages());
//		
//		List<Users> users=page.getContent();
//		for(Users user:users) {
//			System.out.println(user);
//		}
	}
}
